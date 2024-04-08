package com.excelr.groupfive.backend.controller;

import com.excelr.groupfive.backend.models.Employee;
import com.excelr.groupfive.backend.models.LoginRequest;
import com.excelr.groupfive.backend.models.LoginResponse;
import com.excelr.groupfive.backend.repository.EmployeeRepository;
import com.excelr.groupfive.backend.security.JwtHelper;
import com.excelr.groupfive.backend.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeService employeeService;
    private final JwtHelper helper;
    final
    PasswordEncoder passwordEncoder;

    public AuthController(EmployeeService employeeService, AuthenticationManager manager, JwtHelper helper, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.helper = helper;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login-employee")
    public ResponseEntity<Object> loginEmployee(@RequestBody LoginRequest request) {
        UserDetails userDetails = employeeService.loadUserByUsername(request.getUsername());

        if (userDetails != null) {
            if (doAuthenticate(userDetails.getUsername(), request.getPassword(), userDetails.getPassword())) {
                String token = this.helper.generateToken(userDetails);
                LoginResponse response = new LoginResponse(userDetails, token);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                String errorMessage = "Invalid Password!";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("errMsg", errorMessage));
            }
        } else {
            String errorMessage = "Username doesn't exist!";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("errMsg", errorMessage));
        }
    }

    private boolean doAuthenticate(String username, String password, String realPassword) {
            return passwordEncoder.matches(password, realPassword);
    }

    @PostMapping("/create-employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        Boolean existingByUsername = employeeService.existsByUsername(employee.getUsername());
        Boolean existingByEmail = employeeService.existsByEmail(employee.getEmail());

        if (existingByUsername) {
            String errorMessage = "Username '" + employee.getUsername() + "' already exists.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("errMsg", errorMessage));
        } else if (existingByEmail) {
            String errorMessage = "Email '" + employee.getEmail() + "' already exists.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("errMsg", errorMessage));
        }
        if (employee.getIsManager()){
            employee.setManagerId(null);
        }else{
            Employee manager = employeeService.findByDepartmentIdAndIsManager(employee.getDepartmentId(),true);
            if (manager == null){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Collections.singletonMap("errMsg","This Department doesn't have a manager!"));
            }else
                employee.setManagerId(manager.getEmployeeId());
        }
        String password = employee.getPassword();
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee employeeCreated = employeeService.createEmployee(employee);

        UserDetails userDetails = employeeService.loadUserByUsername(employeeCreated.getUsername());

        boolean auth = doAuthenticate(employeeCreated.getUsername(), password,userDetails.getPassword());

        if (auth) {
            String token = this.helper.generateToken(userDetails);
            LoginResponse response = new LoginResponse(userDetails, token);
            System.out.println("GENERATING TOKEN");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return ResponseEntity.ok(employeeCreated);
    }


    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }

}
