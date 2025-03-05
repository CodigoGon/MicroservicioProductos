package com.gonzadev.carrito_micro.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {

    public Long id;
    public List<ProductoDTO> listaCompra;
    public Double total;
}
