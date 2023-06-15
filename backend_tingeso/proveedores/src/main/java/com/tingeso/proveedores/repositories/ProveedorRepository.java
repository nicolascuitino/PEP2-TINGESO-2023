package com.tingeso.proveedores.repositories;

import com.tingeso.proveedores.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {

    ProveedorEntity findByCodigo(String codigo);

}
