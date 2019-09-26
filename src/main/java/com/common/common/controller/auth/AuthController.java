package com.common.common.controller.auth;

import com.common.common.model.user.User;
import com.common.common.service.user.JwtUserDetailsService;
import com.common.common.util.auth.security.JwtRequest;
import com.common.common.util.auth.security.JwtResponse;
import com.common.common.util.auth.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin

public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    JwtUserDetailsService userDetailsService;


    @RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        userDetailsService.validatePassword(authenticationRequest.getUsername() ,authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
