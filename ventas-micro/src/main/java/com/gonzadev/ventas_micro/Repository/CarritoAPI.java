package com.gonzadev.ventas_micro.Repository;


import com.gonzadev.ventas_micro.DTO.CarritoDTO;
import com.gonzadev.ventas_micro.DTO.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carritoapi",url="https://localhost:8082")
public interface CarritoAPI {

    @GetMapping("/producto/findoprod/{id}")
    public CarritoDTO buscarCarrito(@PathVariable("id")Long id);
}
