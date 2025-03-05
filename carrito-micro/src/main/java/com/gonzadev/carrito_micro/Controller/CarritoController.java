package com.gonzadev.carrito_micro.Controller;


import com.gonzadev.carrito_micro.DTO.CarritoDTO;
import com.gonzadev.carrito_micro.Model.CarritoCompra;
import com.gonzadev.carrito_micro.Service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carrServ;

    @PostMapping("/create")
    public void crateCarrito(@RequestBody CarritoCompra carr) {
        carrServ.createCarrito(carr);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarr(@PathVariable("id")Long id) {
        carrServ.deleteCarrito(id);
    }

    @GetMapping("/find/{id}")
    public CarritoDTO elcarrito(@PathVariable("id") Long id) {
       return carrServ.findCarrito(id);
    }

    @GetMapping("/get")
    public List<CarritoCompra> getCarritos() {
        return carrServ.getCarritos();
    }

    @PutMapping("/edit/{id}")
    public String editCarrito(@PathVariable Long id,
                              @RequestBody CarritoCompra car) {
        carrServ.editCarrito(id,car);

        return "carrito editado";
    }

}
