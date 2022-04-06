package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Time;

import java.util.List;
import java.util.Optional;

public interface TimeService {

    List<Time> buscarTodos();
    Optional<Time> buscar(Integer id);
    void salvar(Time time);
    void atualizar(Time time);
    void deletar(Integer id);

}
