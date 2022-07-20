package com.nace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nace.repository.model.NaceModel;

public interface NaceRepository extends JpaRepository<NaceModel, Long>{

}
