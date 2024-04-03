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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
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
    public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = employeeService.loadUserByUsername(request.getUsername());

        String token = this.helper.generateToken(userDetails);

        LoginResponse response = new LoginResponse(userDetails.getUsername(),token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

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
        employee.setEmployeeId(UUID.randomUUID().toString());
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
