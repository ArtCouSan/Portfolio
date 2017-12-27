package com.portfolio.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Usuario;
import com.portfolio.service.UserService;

@SuppressWarnings("serial")
@Repository
public class UserServiceImpl implements UserService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserRepository repository;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void incluir(Usuario user) {
		entityManager.persist(user);
	}

	@Override
	public void alterar(Usuario user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Long codigoUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario obterCPF(String CPF) {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.Cpf = :cpf").setParameter("cpf", CPF);
		Usuario user = (Usuario) query.getSingleResult();
		if (user == null) {
			return null;
		}
		return user;
	}

}
