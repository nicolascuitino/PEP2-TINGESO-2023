package com.tingeso.acopio.controllers;

import com.tingeso.acopio.entities.SubirDataEntity;
import com.tingeso.acopio.services.SubirDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/acopio")
public class SubirDataController {

    @Autowired
    private SubirDataService subirData;

    @GetMapping("/fileUpload")
    public String main() {
        return "fileUpload";
    }

    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        subirData.leerCsv("Acopio.csv");
        return "redirect:/fileUpload";
    }

    @GetMapping("/fileInformation")
    public String listar(Model model) {
        List<SubirDataEntity> datas = subirData.obtenerData();
        model.addAttribute("datas", datas);
        return "fileInformation";
    }

    @GetMapping("/data")
    public ResponseEntity<List<SubirDataEntity>> obtenerData(){
        List<SubirDataEntity> datas = subirData.obtenerData();
        if(datas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(datas);
    }

    @GetMapping("/data/{codigo}")
    public ResponseEntity<List<SubirDataEntity>> obtenerPorProveedor(@PathVariable String codigo){
        List<SubirDataEntity> datas = subirData.obtenerPorProveedor(codigo);
        if(datas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(datas);
    }
}
