package com.gonzadev.ventas_micro.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
    public Long id;
    public List<ProductoDTO> listaCompra;
    public Double total;
}
