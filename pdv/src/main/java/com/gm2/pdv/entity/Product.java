package com.gm2.pdv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo descrição é obrigatório")
    private String description;

    @Column(length = 20, precision = 20, scale = 2, nullable = false)
    @NotNull(message = "O campo preço é obrigatório")
    private BigDecimal price;

    @Column(nullable = true)
    @NotNull(message = "O campo quantidade é obrigatório")
    @Min(1)
    private int quantity;
}
