package com.siamese.demo.controller;
//import com.siamese.demo.Producto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

public class CarritoController {

    @Controller
    public class CartController {

        @GetMapping("/cart")
        public String verCarrito(Model model) {

            return "cart";
        }
    }
}
