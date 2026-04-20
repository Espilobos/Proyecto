package com.siamese.demo.controller;

import com.siamese.demo.domain.Usuario;
import com.siamese.demo.service.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PerfilController {
    
    private final UsuarioService usuarioService;

    public PerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    
    
    @GetMapping("/perfil")
    public String mostrarPerfil(Model model, Authentication authentication){

        String username = authentication.getName();

        Usuario usuario = usuarioService.getUsuarioPorUsername(username).get();

        model.addAttribute("usuario", usuario);
        model.addAttribute("mascotas", usuario.getMascotas());
        return "perfil/listado";
    }
}
