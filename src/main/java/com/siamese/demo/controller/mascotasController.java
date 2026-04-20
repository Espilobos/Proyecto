
package com.siamese.demo.controller;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.domain.Mascota;
import com.siamese.demo.domain.Usuario;
import com.siamese.demo.service.CitaService;
import com.siamese.demo.service.MascotaService;
import com.siamese.demo.service.UsuarioService;
import org.springframework.security.core.Authentication;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class mascotasController {
    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CitaService citaService;
    
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
    public String guardar(@Valid Mascota mascota,Authentication auth, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "mascotas/guardarMascota";
        }
        String username = auth.getName();
        
        Usuario usuario = usuarioService.getUsuarioPorUsername(username).get();
        
        
        mascota.setUsuario(usuario);
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
    
    @PostMapping("/eliminarMascotaLista")
    public String eliminarLista(@RequestParam Long id) {
        mascotaService.eliminar(id);
        return "redirect:/listadoMascotas";
    }
    @PostMapping("/eliminarMascotaPerfil")
    public String eliminarMascotaPerfil(@RequestParam Long id) {
        mascotaService.eliminar(id);
        return "redirect:/perfil";
    }
    
    @GetMapping("/historial")
    public String historial(@PathVariable Long id, Model model){
        List<Cita> citas = citaService.buscarPorMascota(id);
        model.addAttribute("citas", citas);
        return "citas/historial";
    }
    
     @GetMapping("/modificarMascotas")
    public String mascotasModificar(){
        return "mascotas/modificarMascotas";
    }
}
