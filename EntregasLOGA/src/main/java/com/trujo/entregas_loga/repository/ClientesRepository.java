package com.trujo.entregas_loga.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.trujo.entregas_loga.model.ClientesModel;

public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {

}
