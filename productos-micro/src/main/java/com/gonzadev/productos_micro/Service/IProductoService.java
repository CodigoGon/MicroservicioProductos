package com.gonzadev.productos_micro.Service;

import com.gonzadev.productos_micro.Model.Producto;

import java.util.List;

public interface IProductoService {
    public void crearProducto(Producto produ);
    public void borrarProducto(Long id);
    public List<Producto> getProductos();
    public Producto findProducto(Long id);
    public void editProducto(Long id,Producto produEdit);

}
