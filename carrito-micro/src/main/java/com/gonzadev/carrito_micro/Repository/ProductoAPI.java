package com.gonzadev.carrito_micro.Repository;

import com.gonzadev.carrito_micro.DTO.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productoapi",url = "https://localhost:8081")
public interface ProductoAPI {

    @GetMapping("/producto/findoprod/{id}")
    public ProductoDTO buscarProdu(@PathVariable("id")Long id);
}
