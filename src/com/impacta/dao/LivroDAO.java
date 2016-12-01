package com.impacta.dao;
import com.impacta.model.Livro;
import java.util.List;
public interface LivroDAO {

	public void addLivro(Livro livro);
	public void deletarLivro(int idLivro);
	public void alterarLivro(Livro livro);
	public List<Livro> todosLivros();
	public Livro livroPorId(int idLivro);
}
