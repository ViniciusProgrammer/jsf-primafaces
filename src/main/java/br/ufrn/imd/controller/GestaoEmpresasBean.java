package br.ufrn.imd.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.ufrn.imd.model.Empresa;
import br.ufrn.imd.model.TipoEmpresa;

@Named()
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Empresa empresa = new Empresa();

	public Empresa getEmpresa() {
		return empresa;
	}

	public TipoEmpresa[] getTiposEmpresas() {
		return TipoEmpresa.values();
	}
	
	public void salvar() {
		System.out.println("Razão Social " + empresa.getRazaoSocial()
		+ " Nome Fantasia " + empresa.getNomeFantasia());
	}
}
