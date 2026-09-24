package br.ufrn.imd.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufrn.imd.model.Empresa;
import br.ufrn.imd.model.RamoAtividade;
import br.ufrn.imd.model.TipoEmpresa;

public class CamadaPersistencia {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		RamoAtividades ramoAtividades = new RamoAtividades(entityManager);
		Empresas empresas = new Empresas(entityManager);
		
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisarEmpresaDescricao("");
		List<Empresa> listaEmpresas = empresas.buscarEmpresaPorNome("");
		
		System.out.println(listaEmpresas);
		
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("Vinicus Davi");
		empresa.setCnpj("12.529.519/0001-57");
		empresa.setRazaoSocial("Viniciuss 178712361276787212");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaRamoAtividades.get(0));
		
		empresas.salvarEmpresa(empresa);
		
		entityManager.getTransaction().commit();
		
		List<Empresa> listaEmpresas2 = empresas.buscarEmpresaPorNome("");
		System.out.println(listaEmpresas2);
		
		entityManager.close();
		entityManagerFactory.close();
	
	}
}
