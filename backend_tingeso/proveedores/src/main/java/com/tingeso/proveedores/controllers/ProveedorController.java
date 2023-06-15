package com.tingeso.proveedores.controllers;

import com.tingeso.proveedores.entities.ProveedorEntity;
import com.tingeso.proveedores.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/listar")
    public String listar(Model model) {
        ArrayList<ProveedorEntity> proveedores=proveedorService.obtenerProveedores();
        model.addAttribute("proveedores",proveedores);
        return "index";
    }

    @GetMapping("/new-proveedor")
    public String newProveedor(Model model){
        ProveedorEntity proveedor = new ProveedorEntity();
        model.addAttribute("newProveedor", proveedor);
        return "new-proveedor";
    }

    @GetMapping("/proveedor/delete/{id}")
    public String deleteProveedor(@PathVariable String id){
        System.out.println("\n " + id);
        proveedorService.eliminarProveedor(id);
        return "redirect:/";
    }

    /*@PostMapping("/new-proveedor")
    public String saveProveedor(@RequestBody ProveedorEntity proveedor){
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/listar";
    }*/
    @PostMapping("/new-proveedor")
    public String saveProveedor(@RequestParam("codigo") String codigo,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria,
                                 @RequestParam("retencion") String retencion){
        proveedorService.guardarProveedorArg(codigo, nombre, categoria, retencion);
        return "redirect:/listar";
    }

    @PostMapping("/proveedores/post")
    public String crearProveedor(@RequestBody ProveedorEntity proveedor){

        proveedorService.guardarProveedor(proveedor);
        return "Proveedor creado";
    }

    @GetMapping("/getall")
    public List<ProveedorEntity> obtenerTodos(){
        return proveedorService.obtenerProveedores();
    }

    @GetMapping("/proveedores/{codigo}")
    public ResponseEntity<ProveedorEntity> obtenerProveedores(@PathVariable String codigo){
        ProveedorEntity proveedor = proveedorService.encontrarCodigo(codigo);
        if(proveedor == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedor);
    }

}
