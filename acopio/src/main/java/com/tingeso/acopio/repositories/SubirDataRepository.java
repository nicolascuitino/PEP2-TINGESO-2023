package com.tingeso.acopio.repositories;

import com.tingeso.acopio.entities.SubirDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface SubirDataRepository extends JpaRepository <SubirDataEntity, Integer>{

    ArrayList<SubirDataEntity> findByProveedor(String proveedor);
}
