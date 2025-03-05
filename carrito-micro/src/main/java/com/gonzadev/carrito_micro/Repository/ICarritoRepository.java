package com.gonzadev.carrito_micro.Repository;

import com.gonzadev.carrito_micro.Model.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository<CarritoCompra, Long> {
}
