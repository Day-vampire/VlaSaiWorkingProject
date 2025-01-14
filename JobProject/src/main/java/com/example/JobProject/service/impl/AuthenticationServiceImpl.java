package com.example.JobProject.service.impl;

import com.example.JobProject.configuration.UserDetailsImpl;
import com.example.JobProject.dto.AuthenticationRequest;
import com.example.JobProject.dto.AuthenticationResponse;
import com.example.JobProject.dto.RegistrationRequest;
import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;
import com.example.JobProject.exception.AlreadyExistsException;
import com.example.JobProject.exception.NotFoundException;
import com.example.JobProject.repository.RoleRepository;
import com.example.JobProject.repository.UserRepository;
import com.example.JobProject.service.AuthenticationService;
import com.example.JobProject.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public AuthenticationResponse register(RegistrationRequest registrationRequest) {
        String login = registrationRequest.login();
        if (userRepository.findByLogin(login
        ).isPresent()) {
            throw new AlreadyExistsException("User with email: %s already exists".formatted(login));
        }
        User user = new User()
                .setLogin(login)
                .setPassword(passwordEncoder.encode(registrationRequest.password()))
                .setStatus(true)
                .setRole(roleRepository
                        .findByName("ROLE_USER")
                        .orElseThrow(()->new NotFoundException("Role not found")));
        userRepository.save(user);
        String token = jwtService.generateToken(new UserDetailsImpl(user));
        return new AuthenticationResponse(token);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.login(),
                        authenticationRequest.password()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.login());
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }
}