package com.dh.hibernate.aula33.repository;

import com.dh.hibernate.aula33.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TimeRepository extends JpaRepository<Time, Integer> {

    //

}
