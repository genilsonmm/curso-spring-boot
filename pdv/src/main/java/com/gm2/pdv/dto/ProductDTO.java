package com.gm2.pdv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String description;
    @NotNull(message = "O campo preço é obrigatório")
    private BigDecimal price;
    @NotNull(message = "O campo quantidade é obrigatório")
    private int quantity;
}
