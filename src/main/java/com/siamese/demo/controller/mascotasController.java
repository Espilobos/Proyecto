
package com.siamese.demo.controller;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.domain.Mascota;
import com.siamese.demo.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class mascotasController {
    @Autowired
    private MascotaService mascotaService;
    
     @GetMapping("/mascotas")
    public String mascotas(){
        return "mascotas/fragmentosMascotas";
    }
     @GetMapping("/registroMascotas")
    public String mascotasRegistroController(Model model){
        model.addAttribute("mascota", new Mascota());
        return "mascotas/fragmentosRegistroMascotas";
    }
    @PostMapping("/guardarMascota")
    public String guardar(@Valid Mascota mascota, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "mascotas/guardarMascota";
        }
        mascotaService.guardar(mascota);
        redirectAttributes.addFlashAttribute("mensaje", "Mascota registrada correctamente");
        return "redirect:/mascotas";
    }
    @GetMapping("/listadoMascotas")
    public String mascotasListado(Model model){
        model.addAttribute("mascotas", mascotaService.listar());
        return "mascotas/listadoMascotas";
    }
     @GetMapping("/eliminarMascotas")
    public String mascotasEliminar(){
        return "mascotas/fragmentosEliminarM";
    }
    @PostMapping("/eliminarMascota")
    public String eliminar(@RequestParam Long id) {
        mascotaService.eliminar(id);
        return "redirect:/mascotas";
    }
    @PostMapping("/eliminarMascotaLista")
    public String eliminarLista(@RequestParam Long id) {
        mascotaService.eliminar(id);
        return "redirect:/listadoMascotas";
    }
    
    
     @GetMapping("/modificarMascotas")
    public String mascotasModificar(){
        return "mascotas/modificarMascotas";
    }
}
