package com.impacta.model;

public class Professor {
	private int idProfessor;
	private String nomeProfessor;
	private String ra;
	private String senha;
	
 
public int getIdProfessor() {
		return idProfessor;
	}


	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}


	public String getNomeProfessor() {
		return nomeProfessor;
	}


	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}


	public String getRa() {
		return ra;
	}


	public void setRa(String ra) {
		this.ra = ra;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


@Override
	    public String toString() {
	        return "Aluno [idProfessor=" + idProfessor + ", nomeProfessor=" + nomeProfessor
	                + ", ra=" + ra + ", senha=" + senha +"]";
	    }
}
