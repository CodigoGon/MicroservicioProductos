package com.gonzadev.ventas_micro.Repository;

import com.gonzadev.ventas_micro.Model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends JpaRepository<Ventas,Long> {
}
