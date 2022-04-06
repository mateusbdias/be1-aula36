package com.dh.hibernate.aula33.controller;

import com.dh.hibernate.aula33.model.Time;
import com.dh.hibernate.aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public ResponseEntity<List<Time>> buscarTodos() {
        return ResponseEntity.ok(timeService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Time>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(timeService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarTime(@RequestBody Time time) {
        timeService.salvar(time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> atualizarTime(@RequestBody Time time) {
        timeService.atualizar(time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTime(@PathVariable Integer id) {
        timeService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
