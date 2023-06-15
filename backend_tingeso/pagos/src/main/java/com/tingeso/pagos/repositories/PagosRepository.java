package com.tingeso.pagos.repositories;

import com.tingeso.pagos.entities.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PagosRepository extends JpaRepository<PagosEntity, Integer> {

    PagosEntity findByQuincena(String quincena);

    ArrayList<PagosEntity> findByCodigo(String codigo);
}
