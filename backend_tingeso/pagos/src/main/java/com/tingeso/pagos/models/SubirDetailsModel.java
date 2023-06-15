package com.tingeso.pagos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubirDetailsModel {
    private Integer ID;

    private String proveedor;
    private String grasa;
    private String solido;
}
