package com.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Usuario;

@Repository
public interface UserRepository  extends CrudRepository<Usuario, Long>{

}
