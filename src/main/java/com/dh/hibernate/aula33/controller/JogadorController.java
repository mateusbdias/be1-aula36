package com.dh.hibernate.aula33.controller;

import com.dh.hibernate.aula33.model.Jogador;
import com.dh.hibernate.aula33.service.JogadorService;
import com.dh.hibernate.aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;
    private TimeService timeService;

    @Autowired
    public JogadorController(JogadorService jogadorService, TimeService timeService) {
        this.jogadorService = jogadorService;
        this.timeService = timeService;
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodos() {
        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Jogador>> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jogador> salvarJogador(@RequestBody Jogador jogador) {
        timeService.salvar(jogador.getTime());
        return ResponseEntity.ok(jogadorService.salvar(jogador));
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
