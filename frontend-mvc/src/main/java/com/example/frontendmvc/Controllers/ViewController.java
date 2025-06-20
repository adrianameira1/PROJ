package com.example.frontendmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/dashboard-cliente")
    public String mostrarDashboard() {
        return "dashboard-cliente"; // Retorna o nome da template HTML (sem .html)
    }
}
