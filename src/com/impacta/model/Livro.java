package com.impacta.model;

public class Livro {
	// Java bean com os dados e o get and sets
	private int idLivro;
	private String nomeLivro;
	private String anoLivro;
	private String autorLivro;

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAnoLivro() {
		return anoLivro;
	}

	public void setAnoLivro(String anoLivro) {
		this.anoLivro = anoLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", nomeLivro=" + nomeLivro
				+ ", anoLivro=" + anoLivro + ", autorLivro=" + autorLivro + "]";// override
																				// dos
																				// valores
																				// com
																				// os
																				// sets
	}
}
