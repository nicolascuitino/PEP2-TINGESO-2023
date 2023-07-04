package com.tingeso.pagos.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingeso.pagos.entities.PagosEntity;
import com.tingeso.pagos.models.SubirDataModel;
import com.tingeso.pagos.models.SubirDetailsModel;
import com.tingeso.pagos.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    @Autowired
    PagosService pagosService;


    @GetMapping()
    public List<PagosEntity> listarPagos(Model model) {
        mostrarPagos();
        ArrayList<PagosEntity> totalPagos = pagosService.obtenerPagos();
        return totalPagos;
    }

    //@PostMapping("/pagos")
    public void mostrarPagos(){

        List<SubirDataModel> subirData = pagosService.obtenerData();
        List<SubirDetailsModel> subirDetails = pagosService.obtenerDetails();

        boolean exists = false;

        for(SubirDataModel j: subirData){
            ArrayList<PagosEntity> pagos = pagosService.obtenerPagos();
            for(PagosEntity k: pagos){
                if(k.getCodigo().equals(j.getProveedor()) &&
                        j.getQuincena().equals(k.getQuincena())){
                    exists = true;
                }

            }
            if(exists == false){
                pagosService.guardarPagoDB(pagosService.obtenerProveedor(j.getProveedor()),j,pagosService.obtenerDetail(j.getProveedor()));
            }
            exists = false;
        }


    }



    @GetMapping("/all")
    public ArrayList<PagosEntity> obtenerPagos(){

        return pagosService.obtenerPagos();
    }

    @GetMapping("/obtener/acopios")
    public ResponseEntity<List<SubirDataModel>> obtenerAcopios(){
        List<SubirDataModel> subirData = pagosService.obtenerData();
        if(subirData.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subirData);
    }

    @Autowired
    ObjectMapper objectMapper;
    @GetMapping("/mostrar/acopios")
    public List<SubirDataModel> mostrarAcopios(){
         List<SubirDataModel> acopio = objectMapper.convertValue(pagosService.obtenerData(), new TypeReference<>(){
        });

        return acopio;
    }

}
