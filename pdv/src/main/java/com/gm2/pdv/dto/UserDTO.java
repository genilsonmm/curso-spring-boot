package com.gm2.pdv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Campo nome é obrigatório")
    private String name;
    @NotBlank(message = "O campo username é obrigatório")
    private String username;
    @NotBlank(message = "O campo senha é obrigatório")
    private String password;
    private boolean isEnabled;
}
