package com.example.frontendmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarHome() {
        return "index"; // carrega o ficheiro index.html em /templates
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // carrega login.html
    }

    @GetMapping("/register")
    public String mostrarRegisto() {
        return "register"; // carrega register.html
    }
}
