package com.siamese.demo.controller;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.domain.Mascota;
import com.siamese.demo.domain.Usuario;
import com.siamese.demo.service.CitaService;
import com.siamese.demo.service.MascotaService;
import com.siamese.demo.service.UsuarioService;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CitasController {

    @Autowired
    private CitaService citaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/citas")
    public String mostrarCitas() {
        return "citas/fragmentosCitas";
    }

    @GetMapping("/general")
    public String mostrarGeneral() {
        return "general/fragmentos";
    }

    @GetMapping("/crearCita")
    public String crearCitas(Model model, Principal principal) {
        Usuario usuario = usuarioService.getUsuarioPorUsername(principal.getName()).get();
        List<Mascota> mascotas = mascotaService.buscarPorUsuario(usuario);
        model.addAttribute("cita", new Cita());
        model.addAttribute("mascotas", mascotas);
        return "citas/crearCita";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Cita cita, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "citas/crearCitas";
        }
        Usuario usuario = usuarioService.getUsuarioPorUsername(principal.getName()).get();
        cita.setUsuario(usuario);
        citaService.guardar(cita);
        return "redirect:/citas";
    }

    @GetMapping("/consultarCita")
    public String consultarCitas(Model model) {
        model.addAttribute("citas", citaService.listar());
        return "citas/consultarCita";
    }

    @GetMapping("/cancelarCita")
    public String cancelarCitas() {
        return "citas/cancelarCita";
    }

    @PostMapping("/eliminarCita")
    public String eliminar(@RequestParam Long id) {
        citaService.eliminar(id);
        return "redirect:/citas";
    }

    @PostMapping("/eliminarCitaConsultas")
    public String eliminarConsultas(@RequestParam Long id) {
        citaService.eliminar(id);
        return "redirect:/consultarCita";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mascota/citas/{id}")
    public String historial(@PathVariable Long id, Model model) {

        Mascota mascota = mascotaService.buscarPorId(id);
        List<Cita> citas = citaService.buscarPorMascota(id);

        model.addAttribute("mascota", mascota);
        model.addAttribute("citas", citas);

        return "historial/fragmentos"; // o la vista donde lo insertes
    }
}
