package com.adrien.sgc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.sgc.dtos.LoginRequestDTO;
import com.adrien.sgc.dtos.LoginResponseDTO;
import com.adrien.sgc.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto) {
        LoginResponseDTO response = usuarioService.autenticar(dto);
        return ResponseEntity.ok().body(response);
    }
}