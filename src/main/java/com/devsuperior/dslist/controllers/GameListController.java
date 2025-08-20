package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {  // porta de entrada para o back end para o front end

    @Autowired
    private GameListService gameListService; // controller injeta um service

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> resultado = gameListService.findAll();
        return resultado;
    }
}
