package com.example.execute.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.execute.api.cofig.JwtTokenUtil;
import com.example.execute.api.model.User;
import com.example.execute.api.model.UserDto;
import com.example.execute.api.repository.UserRepository;
import com.example.execute.api.service.UserService;
import com.example.execute.api.serviceImpl.JwtUserDetailsService;


@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	

	@PostMapping(value = "/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {

		authenticate(userDto.getUsername(), userDto.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(token);
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		if(userService.findByUserName(user.getUsername())==null) {

				return ResponseEntity.ok(userDetailsService.save(user));
		} else {

			return new ResponseEntity<String>("{\"message\":\"User Already Used\"}", HttpStatus.BAD_REQUEST);
		}
	}

	
	/*
	@GetMapping("/get-user-detail")
	public User getUserDetail(HttpServletRequest request) {

		String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));

		User current = userService.findByEmail(username);
		Credentials cred= current.getCredentials();
		cred.setPassword(null);
		cred.setRoles(null);

		return current;

	}

	@PostMapping("/update-user")
	public User updateUser(@RequestBody User user, HttpServletRequest request) {
		String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));

		User current = userService.findByEmail(username);

		current.setName(user.getName());
	//	current.setAddress(user.getAddress());
		return userService.save(current);

	}

	@GetMapping("/checkifadmin")
	public ResponseEntity<?> testDecodeJWT(HttpServletRequest request) {
		

		if (request.getHeader("Authorization") != null) {
			String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));

			User current = userService.findByEmail(username);

			if (current.getRoles().contains("ADMIN")) {

				return new ResponseEntity<>("{\"role\":\"ADMIN\"}", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("{\"role\":\"OTHERS\"}", HttpStatus.OK);

	}

	@GetMapping("/getusername")
	public String getUserName(HttpServletRequest request) {

		if (request.getHeader("Authorization") != null) {
			String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
			return username;
		} else {
			return "INVALID JWT";
		}

	}
	
	*/

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
