package com.gonzadev.carrito_micro.Service;

import com.gonzadev.carrito_micro.DTO.CarritoDTO;
import com.gonzadev.carrito_micro.DTO.ProductoDTO;
import com.gonzadev.carrito_micro.Model.CarritoCompra;
import com.gonzadev.carrito_micro.Repository.ICarritoRepository;
import com.gonzadev.carrito_micro.Repository.ProductoAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService implements ICarritoService{

    @Autowired
    public ICarritoRepository carrRepo;

    @Autowired
    public ProductoAPI productoAPI;

    @Override
    public void createCarrito(CarritoCompra Carr) {
        carrRepo.save(Carr);
    }

    @Override
    public void deleteCarrito(Long id) {
        carrRepo.deleteById(id);
    }

    @Override
    public List<CarritoCompra> getCarritos() {
        return carrRepo.findAll();
    }

    @Override
    @CircuitBreaker(name = "productoapi",fallbackMethod = "errorCom")
    @Retry(name = "productoapi")
    public CarritoDTO findCarrito(Long id) {

        //buscamos el carrito en cuestion
        CarritoCompra carrito = carrRepo.findById(id).orElse(null);
        assert carrito != null;
        //pasamos la lista de Long a un list y lo mismo creamos una arraylist de carrito, para guardar los objetos que
        //sacararemos del microservicio productos a travez de un for.
        List<Long> arraybusca = carrito.getListaCompra();
        List<ProductoDTO> carDTO =  new ArrayList<>();

        //con el for agregamos los productos que sacamos de productos
        for (Long array : arraybusca) {
            carDTO.add(productoAPI.buscarProdu(array));
        }

        //sumamos los prrecios de los productos extraidos para sacarr el total
        Double total = carDTO.stream().mapToDouble(ProductoDTO::getPrecio).sum();

        //creamos un carrito final que se devolvera a la funcion.
        CarritoDTO carFinal= null;

        carFinal.setId(carrito.getId());
        carFinal.setListaCompra(carDTO);
        carFinal.setTotal(total);

        return carFinal;
    }

    public CarritoDTO errorCom(Throwable error) {
        List<ProductoDTO> carritoVacio = new ArrayList<>();

        return new CarritoDTO(99999L,carritoVacio,999999.99);
    }

    @Override
    public void editCarrito(Long id, CarritoCompra carr) {
        CarritoCompra carEd = carrRepo.findById(id).orElse(null);

        if (carEd != null) {
            carEd.setListaCompra(carr.getListaCompra());
            carEd.setTotal(carr.getTotal());

            createCarrito(carEd);
        }
    }
}
