package com.example.JobProject.service;

import com.example.JobProject.dto.AuthenticationRequest;
import com.example.JobProject.dto.AuthenticationResponse;
import com.example.JobProject.dto.RegistrationRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegistrationRequest registrationRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}