package com.system.exams.controller;

import com.system.exams.entity.JwtRequest;
import com.system.exams.entity.JwtResponse;
import com.system.exams.entity.User;
import com.system.exams.security.JwtUtils;
import com.system.exams.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowedHeaders = "*", allowCredentials = "true")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authentication(jwtRequest.getUsername(),jwtRequest.getPassword());

        }  catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
     private void authentication (String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException disabledException){
            throw new Exception("Disable user " + disabledException.getMessage());

        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Invalid credentials " + badCredentialsException.getMessage());
        }
     }


     @GetMapping("/current-user")
     public User getCurrentUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
     }


}
