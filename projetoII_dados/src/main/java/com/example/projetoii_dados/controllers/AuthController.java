package com.example.projetoii_dados.controllers;

import com.example.core.models.Cliente;
import com.example.core.models.Utilizador;
import com.example.projetoii_dados.DTOs.LoginResponseDTO;
import com.example.projetoii_dados.DTOs.LoginRequestDTO;
import com.example.projetoii_dados.services.UtilizadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UtilizadorService utilizadorService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UtilizadorService utilizadorService, PasswordEncoder passwordEncoder) {
        this.utilizadorService = utilizadorService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        Utilizador utilizador = utilizadorService.findByUsername(dto.getUsername());

        if (utilizador == null || !passwordEncoder.matches(dto.getPassword(), utilizador.getPasswordHash())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Credenciais inválidas."));
        }

        Cliente cliente = utilizador.getIdCliente(); // <- o nome correto do método

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("message", "Utilizador sem cliente associado."));
        }

        return ResponseEntity.ok(new LoginResponseDTO(cliente.getId(), utilizador.getNome()));
    }



}
