package com.gonzadev.carrito_micro.Service;

import com.gonzadev.carrito_micro.DTO.CarritoDTO;
import com.gonzadev.carrito_micro.Model.CarritoCompra;

import java.util.List;

public interface ICarritoService {
    public void createCarrito(CarritoCompra Carr);
    public void deleteCarrito(Long id);
    public List<CarritoCompra> getCarritos();
    public CarritoDTO findCarrito(Long id);
    public void editCarrito(Long id, CarritoCompra carr);
}
