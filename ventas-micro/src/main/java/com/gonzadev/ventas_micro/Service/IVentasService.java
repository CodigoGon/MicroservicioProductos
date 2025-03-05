package com.gonzadev.ventas_micro.Service;

import com.gonzadev.ventas_micro.DTO.VentaDTO;
import com.gonzadev.ventas_micro.Model.Ventas;

import java.util.List;

public interface IVentasService {
    public void crearVenta(Ventas venta);
    public void deleteVenta(Long id);
    public VentaDTO findVenta(Long id);
    public List<Ventas> getVneta();
    public void editVenta(Long id, Ventas ventaeditar);
}
