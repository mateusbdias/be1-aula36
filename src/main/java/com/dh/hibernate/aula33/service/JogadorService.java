package com.dh.hibernate.aula33.service;

import com.dh.hibernate.aula33.model.Jogador;
import com.dh.hibernate.aula33.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(Integer id) {
        return jogadorRepository.findById(id);
    }

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador atualizar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void excluir(Integer id) {
        jogadorRepository.deleteById(id);
    }
}
