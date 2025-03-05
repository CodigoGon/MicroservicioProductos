package com.gonzadev.ventas_micro.Controller;

import com.gonzadev.ventas_micro.DTO.VentaDTO;
import com.gonzadev.ventas_micro.Model.Ventas;
import com.gonzadev.ventas_micro.Service.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private IVentasService venServ;

    @PostMapping("/crear")
    public String createVenta(@RequestBody Ventas venta) {
        venServ.crearVenta(venta);

        return "venta creada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVenta(@PathVariable Long id) {
        venServ.deleteVenta(id);
        return "venta borrada";
    }

    @GetMapping("/find/{id}")
    public VentaDTO findVenta(@PathVariable Long id) {
        return venServ.findVenta(id);
    }

    @GetMapping("/getVentas")
    public List<Ventas> getVentas() {
        return venServ.getVneta();
    }

    @PutMapping("/editar/{id}")
    public String EditVent(@PathVariable("id")Long id,
                           @RequestBody Ventas venti) {
        venServ.editVenta(id,venti);

        return "venta editada";
    }
}
