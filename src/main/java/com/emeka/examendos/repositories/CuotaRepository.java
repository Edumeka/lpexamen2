package com.emeka.examendos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emeka.examendos.models.Cuota;

@Repository
public interface CuotaRepository extends JpaRepository<Cuota, Integer>{
    
}
