package br.ufrn.imd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufrn.imd.model.Empresa;

public class SchemaGeneration {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlgaWorksPU");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Empresa> empresas = entityManager.createNamedQuery("from Empresa", Empresa.class).getResultList();

		System.out.println(empresas);

		entityManager.close();
		entityManagerFactory.close();
	}
}
