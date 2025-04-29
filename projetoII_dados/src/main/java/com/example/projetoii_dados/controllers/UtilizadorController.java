package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Utilizador;
import com.example.projetoii_dados.services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilizadores")
@CrossOrigin(origins = "http://localhost:3000") // Permitir chamadas de fora se necessário
public class UtilizadorController {

    @Autowired
    private UtilizadorService utilizadorService;

    @GetMapping
    public List<Utilizador> getAllUtilizadores() {
        return utilizadorService.getAllUtilizadores();
    }

    @GetMapping("/{id}")
    public Utilizador getUtilizadorById(@PathVariable Integer id) {
        return utilizadorService.getUtilizadorById(id);
    }

    @PostMapping
    public Utilizador createUtilizador(@RequestBody Utilizador utilizador) {
        return utilizadorService.saveUtilizador(utilizador);
    }

    @PutMapping("/{id}")
    public Utilizador updateUtilizador(@PathVariable Integer id, @RequestBody Utilizador utilizador) {
        utilizador.setId(id);
        return utilizadorService.saveUtilizador(utilizador);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilizador(@PathVariable Integer id) {
        utilizadorService.deleteUtilizador(id);
    }
}
