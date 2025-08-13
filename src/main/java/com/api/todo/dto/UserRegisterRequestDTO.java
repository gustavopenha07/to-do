package com.api.todo.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "username é obrigatório")
    String username,

    @NotBlank(message = "Senha é obrigatória")
    String password
) {}
