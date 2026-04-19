
package com.siamese.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mascotasController {
    
     @GetMapping("/mascotas")
    public String mascotas(){
        return "mascotas/fragmentosMascotas";
    }
     @GetMapping("/registroMascotas")
    public String mascotasRegistroController(){
        return "mascotas/fragmentosRegistroMascotas";
    }
     @GetMapping("/eliminarMascotas")
    public String mascotasEliminarController(){
        return "mascotas/fragmentosEliminarM";
    }
     @GetMapping("/listadoMascotas")
    public String mascotasListado(){
        return "mascotas/listadoMascotas";
    }
     @GetMapping("/modificarMascotas")
    public String mascotasModificar(){
        return "mascotas/modificarMascotas";
    }
}
