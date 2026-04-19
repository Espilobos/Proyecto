package com.siamese.demo.controller;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.service.CitaService;
import jakarta.validation.Valid;
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

    @GetMapping("/citas")
    public String mostrarCitas() {
        return "citas/fragmentosCitas";
    }
    @GetMapping("/general")
    public String mostrarGeneral() {
        return "general/fragmentos";
    }
    @GetMapping("/crearCita")
    public String crearCitas(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/crearCita";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Cita cita, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "citas/crearCitas";
        }
        citaService.guardar(cita);
        redirectAttributes.addFlashAttribute("mensaje", "Cita guardada correctamente");
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
    
    @GetMapping("/editarCita/{id}")
    public String editarCita(@PathVariable Long id, Model model){
        Cita cita = citaService.buscarPorId(id);
        model.addAttribute("cita", cita);
        return "citas/crearCita";
    }

}
