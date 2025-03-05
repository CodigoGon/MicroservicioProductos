package com.gonzadev.ventas_micro.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    public Long id;
    public Long idCarrito;
    public List<ProductoDTO> lsitaProductos;
    public LocalDate fecha;
    public Double total;
}
