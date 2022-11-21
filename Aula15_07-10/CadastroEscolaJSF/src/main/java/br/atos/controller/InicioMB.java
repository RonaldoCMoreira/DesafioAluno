package br.atos.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioMB {
	public String cadastrarProfessor() {
		return "crudProfessor.xhtml";
	}

	public String cadastrarEstudante() {
		return "crudEstudante.xhtml";
	}
}
