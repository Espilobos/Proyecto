package com.siamese.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitasController {
    @GetMapping("/citas")
    public String mostrarCitas(){
        return "citas/fragmentosCitas";
    }
}
