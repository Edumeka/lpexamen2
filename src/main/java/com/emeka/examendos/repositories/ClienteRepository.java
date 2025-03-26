package com.emeka.examendos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emeka.examendos.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

    

}
