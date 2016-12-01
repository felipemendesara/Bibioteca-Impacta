package com.impacta.model;

public class Aluno {
//Java bean com os dados e o get and sets
	private int alunoId;
	private String nomeAluno;
	private String RA;
	private String senha;
	private int idade;
 public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
@Override
	    public String toString() {
	        return "Aluno [alunoId=" + alunoId + ", nomeAluno=" + nomeAluno
	                + ", ra=" + RA + ", senha=" + senha + ", idade="
	                + idade + "]";//override dos valores com os sets
	    }
}
