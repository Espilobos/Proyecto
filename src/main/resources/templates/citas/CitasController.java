package templates.citas;


import com.siamese.demo.domain.Cita;
import com.siamese.demo.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/crearCita2")
    public String crearCitas2(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/fragmentos";
    }
    @PostMapping("/guardar")
    public String guardar(Cita cita){
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
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
