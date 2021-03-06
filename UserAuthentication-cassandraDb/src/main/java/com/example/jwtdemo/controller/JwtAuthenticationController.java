package com.example.jwtdemo.controller;


import com.example.jwtdemo.config.JwtTokenUtil;

import com.example.jwtdemo.model.JwtResponse;
import com.example.jwtdemo.model.User;
import com.example.jwtdemo.model.UserDto;
import com.example.jwtdemo.repository.UserRepository;

import com.example.jwtdemo.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    UserRepository userService;



    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {


        authenticate(userDto.getUsername(), userDto.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {

        if (userService.findByUsername(user.getUsername()) == null) {

            return ResponseEntity.ok(userDetailsService.save(user));
        } else {

            return new ResponseEntity<String>("{\"message\":\"Email Already Used\"}", HttpStatus.BAD_REQUEST);
        }
    }



    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}