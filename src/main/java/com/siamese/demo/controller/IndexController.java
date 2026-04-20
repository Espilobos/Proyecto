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
        return "index";
    }
}