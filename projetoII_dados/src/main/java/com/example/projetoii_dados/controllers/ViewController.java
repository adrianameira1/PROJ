package com.example.projetoii_dados.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/dashboard-cliente")
    public String dashboardCliente() {
        return "dashboard-cliente"; // ← este é o nome do ficheiro .html em templates
    }
}
