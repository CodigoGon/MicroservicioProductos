package com.gonzadev.productos_micro.Controller;


import com.gonzadev.productos_micro.Model.Producto;
import com.gonzadev.productos_micro.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductoService prodServ;

    @PostMapping("/create")
    public String createProduct(@RequestBody Producto prod) {
        prodServ.crearProducto(prod);
        return "producto creado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")Long id) {
        prodServ.borrarProducto(id);
        return "producto borrado";
    }

    @GetMapping("/getprod")
    public List<Producto> getProduct() {
        return prodServ.getProductos();
    }

    @GetMapping("/findprod/{id}")
    public Producto findProduct(@PathVariable("id")Long id) {
        return prodServ.findProducto(id);
    }

    @PutMapping("/editprod/{id}")
    public String editProducto(@PathVariable("id") Long id,
                               @RequestBody Producto prod) {
        prodServ.editProducto(id,prod);

        return "editado";
    }

}
