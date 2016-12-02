package com.impacta.model;

public class Usuario {
	// Java bean com os dados e o get and sets
	private int idUsuario;
	private String nomeUsuario;
	private String senhaUsuario;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senha) {
		this.senhaUsuario = senha;
	}

	@Override
	public String toString() {
		return "Aluno [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario
				+ ", senhaUsuario=" + senhaUsuario + "]";// override dos valores
															// com os sets
	}
}
