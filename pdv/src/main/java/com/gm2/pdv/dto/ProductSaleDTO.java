package com.gm2.pdv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleDTO {

    @NotNull(message = "O item da venda é obrigatório")
    private long productid;
    @NotNull(message = "O campo quantidade é obrigatório")
    private int quantity;
}
