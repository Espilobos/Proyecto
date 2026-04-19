/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siamese.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

/**
 *
 * @author alana
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        // Al retornar "index", Spring busca templates/index.html 
        // y activa el motor de Thymeleaf para traducir los textos.
        return "index";
    }
}