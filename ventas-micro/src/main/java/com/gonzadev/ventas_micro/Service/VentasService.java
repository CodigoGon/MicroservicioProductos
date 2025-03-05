package com.gonzadev.ventas_micro.Service;

import com.gonzadev.ventas_micro.DTO.CarritoDTO;
import com.gonzadev.ventas_micro.DTO.ProductoDTO;
import com.gonzadev.ventas_micro.DTO.VentaDTO;
import com.gonzadev.ventas_micro.Model.Ventas;
import com.gonzadev.ventas_micro.Repository.CarritoAPI;
import com.gonzadev.ventas_micro.Repository.IVentasRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasService implements IVentasService{

    @Autowired
    private IVentasRepository ventaRepo;

    @Autowired
    private CarritoAPI carAPI;

    @Override
    public void crearVenta(Ventas venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    @CircuitBreaker(name = "errorCarrito",fallbackMethod = "failed")
    @Retry(name = "carritoapi")
    public VentaDTO findVenta(Long id) {
        //aca se hace openFeign la parte mas jodida(?
        Ventas ventaGuscada = ventaRepo.findById(id).orElse(null);
        assert ventaGuscada != null;
        CarritoDTO carritoCompleto = carAPI.buscarCarrito(ventaGuscada.idCarrito);
        VentaDTO ventaFinal = new VentaDTO();

        ventaFinal.setId(ventaGuscada.getId());
        ventaFinal.setIdCarrito(ventaGuscada.getIdCarrito());
        ventaFinal.setLsitaProductos(carritoCompleto.getListaCompra());
        ventaFinal.setFecha(ventaGuscada.getFecha());
        ventaFinal.setTotal(carritoCompleto.getTotal());

        return ventaFinal;
    }

    public VentaDTO failed (Throwable throwerror) {
        VentaDTO ventaError = new VentaDTO();

        ventaError.setId(999999L);
        ventaError.setIdCarrito(9999999L);
        ventaError.setLsitaProductos(null);
        ventaError.setFecha(null);
        ventaError.setTotal(99999999.99);

        return ventaError;
    }

    @Override
    public List<Ventas> getVneta() {
        return ventaRepo.findAll();
    }

    @Override
    public void editVenta(Long id, Ventas ventaeditar) {
        Ventas ventaBuscar = ventaRepo.findById(id).orElse(null);
        assert ventaBuscar != null;

        ventaBuscar.setIdCarrito(ventaeditar.getIdCarrito());
        ventaBuscar.setFecha(ventaeditar.getFecha());
        ventaBuscar.setTotal(ventaeditar.getTotal());

        ventaRepo.save(ventaBuscar);
    }
}
