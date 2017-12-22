package com.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Sobre;

@Repository
public interface SobreRepository extends CrudRepository<Sobre, Long>{

}
