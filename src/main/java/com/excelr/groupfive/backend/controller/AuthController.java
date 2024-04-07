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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login-employee")
    public ResponseEntity<Object> loginEmployee(@RequestBody LoginRequest request) {

        boolean authenticated = this.doAuthenticate(request.getUsername(), request.getPassword());

        if (authenticated){
            UserDetails userDetails = employeeService.loadUserByUsername(request.getUsername());

            String token = this.helper.generateToken(userDetails);

            LoginResponse response = new LoginResponse(userDetails,token);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        String errorMessage ="Invalid Credentials!!";
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errMsg", errorMessage);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMap);
    }


    private boolean doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
//        try {
            Authentication authentication1 = manager.authenticate(authentication);
            if(authentication1.isAuthenticated()){
                return true;
            }
            return false;
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException(" Invalid Username or Password  !!");
//        }

    }
    @PostMapping("/create-employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        Employee existingByUsername = employeeRepository.findByUsername(employee.getUsername());
        Employee existingByEmail = employeeRepository.findByEmail(employee.getEmail());

        if (existingByUsername != null) {
            // Handle duplicate username
            String errorMessage = "Username '" + employee.getUsername() + "' already exists.";

            ErrorResponse errorResponse = ErrorResponse.builder(
                    new Exception(),
                    HttpStatus.CONFLICT,
                    errorMessage
            ).build();
            return ResponseEntity.badRequest().body(errorResponse);
        } else if (existingByEmail != null) {
            // Handle duplicate email
            String errorMessage = "Email '" + employee.getEmail() + "' already exists.";

            ErrorResponse errorResponse = ErrorResponse.builder(
                    new Exception(),
                    HttpStatus.CONFLICT,
                    errorMessage
            ).build();

            return ResponseEntity.badRequest().body(errorResponse);
        }
        if (employee.getIsManager()){
            employee.setManagerId(null);
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }

}
