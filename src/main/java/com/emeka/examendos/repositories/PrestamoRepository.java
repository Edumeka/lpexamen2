package com.emeka.examendos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emeka.examendos.models.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
    
}
