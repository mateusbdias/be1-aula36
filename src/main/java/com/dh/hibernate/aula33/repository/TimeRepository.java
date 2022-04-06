package com.dh.hibernate.aula33.repository;

import com.dh.hibernate.aula33.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TimeRepository extends JpaRepository<Time, Integer> {

    @Modifying
    @Query("UPDATE Time t SET t.nome = ?1, t.cidade = ?2, t.estado = ?3" +
            "WHERE t.id = ?4")
    void atualizar(String nome, String cidade, String estado, Integer id);

}
