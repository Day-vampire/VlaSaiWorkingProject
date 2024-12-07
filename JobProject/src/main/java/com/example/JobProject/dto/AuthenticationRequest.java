package com.example.JobProject.dto;

import jakarta.validation.constraints.NotBlank;

    public record AuthenticationRequest(@NotBlank String login,
                                        @NotBlank String password)
    {}