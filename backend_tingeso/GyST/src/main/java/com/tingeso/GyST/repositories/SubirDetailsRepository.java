package com.tingeso.GyST.repositories;

import com.tingeso.GyST.entities.SubirDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubirDetailsRepository extends JpaRepository<SubirDetailsEntity,Integer> {

    SubirDetailsEntity findByProveedor(String proveedor);
}
