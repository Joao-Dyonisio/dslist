package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; //Componente para injetar o repository dentro da camada de Serviço

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game resultado = gameRepository.findById(gameId).get();
        GameDTO dto = new GameDTO(resultado);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> resultado = gameRepository.findAll();
        List<GameMinDTO> dto = resultado.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> resultado = gameRepository.searchByList(listId);
        return resultado.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
