package com.tingeso.pagos.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubirDataModel {

    private Integer ID;
    private String fecha;
    private String quincena;
    private String turno;
    private String proveedor;
    private String kls_leche;

}
