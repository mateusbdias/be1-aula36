package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Time;
import com.dh.hibernate.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> buscarTodos() {
        return timeRepository.findAll();
    }

    public Optional<Time> buscarPorId(Integer id) {
        return timeRepository.findById(id);
    }

    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    public Time atualizar(Time time) {
        return timeRepository.save(time);
    }

    public void excluir(Integer id) {
        timeRepository.deleteById(id);
    }
}
