package com.tingeso.GyST.controllers;

import com.tingeso.GyST.entities.SubirDetailsEntity;
import com.tingeso.GyST.services.SubirDetailsService;
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
@RequestMapping
public class SubirDetailsController {
    @Autowired
    SubirDetailsService subirDetailsService;

    @GetMapping("/detailsUpload")
    public String main() {
        return "detailsUpload";
    }

    @PostMapping("/detailsUpload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirDetailsService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        subirDetailsService.leerCsv("GyST.csv");
        return "redirect:/detailsUpload";
    }

    @GetMapping("/detailsInformation")
    public String listar(Model model) {
        ArrayList<SubirDetailsEntity> details = subirDetailsService.obtenerDetails();
        model.addAttribute("details", details);
        return "fileInformation";
    }

    @GetMapping("/details")
    public ResponseEntity<List<SubirDetailsEntity>> obtenerData(){
        List<SubirDetailsEntity> details = subirDetailsService.obtenerDetails();
        if(details.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/detail/{codigo}")
    public ResponseEntity<SubirDetailsEntity> obtenerData(@PathVariable String codigo){
        SubirDetailsEntity details = subirDetailsService.obtenerPorProveedor(codigo);
        if(details == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(details);
    }


}
