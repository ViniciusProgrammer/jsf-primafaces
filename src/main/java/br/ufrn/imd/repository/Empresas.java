package br.ufrn.imd.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.ufrn.imd.model.Empresa;

public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public Empresas() {

	}

	public Empresas(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Empresa buscarPorId(Long id) {
		return entityManager.find(Empresa.class, id);
	}

	public List<Empresa> buscarEmpresaPorNome(String nome) {
		TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa WHERE nomeFantasia LIKE :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
	}
	
	public Empresa salvarEmpresa(Empresa empresa) {
		return entityManager.merge(empresa);
	}
	
	public void removerEmpresa(Empresa empresa) {
		empresa = buscarPorId(empresa.getId());
		entityManager.remove(empresa);
	}
}
