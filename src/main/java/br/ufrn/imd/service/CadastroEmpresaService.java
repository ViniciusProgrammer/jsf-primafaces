package br.ufrn.imd.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.ufrn.imd.model.Empresa;
import br.ufrn.imd.repository.Empresas;
import br.ufrn.imd.util.Transacional;

public class CadastroEmpresaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.salvarEmpresa(empresa);
	}
	
	@Transacional
	void excluir(Empresa empresa) {
		empresas.removerEmpresa(empresa);
	}
}
