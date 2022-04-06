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

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> buscarTodos() {
        return ResponseEntity.ok(timeService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Time>> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(timeService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarTime(@RequestBody Time time) {
        timeService.salvar(time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> atualizarTime(@RequestBody Time time) {
        ResponseEntity<Time> response = null;

        if (time.getId() != null && timeService.buscarPorId(time.getId()).isPresent()) {
            response = ResponseEntity.ok(timeService.atualizar(time));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirTime(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (timeService.buscarPorId(id).isPresent()) {
            timeService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    "Time excluído com sucesso!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
