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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login-employee")
    public ResponseEntity<Object> loginEmployee(@RequestBody LoginRequest request) {
        UserDetails userDetails = employeeService.loadUserByUsername(request.getUsername());

        if (userDetails != null) {
            if (doAuthenticate(userDetails.getUsername(), request.getPassword())) {
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

    private boolean doAuthenticate(String username, String password) {
        UserDetails userDetails = employeeService.loadUserByUsername(username);
        if (userDetails != null) {
            return passwordEncoder.matches(password, userDetails.getPassword());
        }
        return false;
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
            employee.setManagerId(manager.getEmployeeId());
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee employeeCreated = employeeService.createEmployee(employee);
        return ResponseEntity.ok(employeeCreated);
    }


    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }

}
