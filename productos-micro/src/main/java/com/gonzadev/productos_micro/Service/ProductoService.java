package com.gonzadev.productos_micro.Service;

import com.gonzadev.productos_micro.Model.Producto;
import com.gonzadev.productos_micro.Repository.IProductoRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository produRepo;

    @Override
    public void crearProducto(Producto produ) {
        produRepo.save(produ);
    }

    @Override
    public void borrarProducto(Long id) {
        produRepo.deleteById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return produRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Long id, Producto produEdit) {
        Producto produ = findProducto(id);

        produ.setMarca(produEdit.getMarca());
        produ.setNombre(produEdit.getNombre());
        produ.setStock(produEdit.getStock());
        produ.setPrecio(produEdit.getPrecio());

        produRepo.save(produ);
    }
}
