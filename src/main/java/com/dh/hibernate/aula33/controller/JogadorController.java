package com.dh.hibernate.aula33.controller;

import com.dh.hibernate.aula33.model.Jogador;
import com.dh.hibernate.aula33.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodos() {
        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Jogador>> buscarPorId(Integer id) {
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarJogador(@RequestBody Jogador jogador) {
        jogadorService.salvar(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> atualizarJogador(@RequestBody Jogador jogador) {
        jogadorService.atualizar(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirJogador(@PathVariable Integer id) {
        jogadorService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
