package com.impacta.dao;
import com.impacta.model.Aluno;
import java.util.List;;
public interface AlunoDAO {

	public void addAluno(Aluno aluno);
	public void deletarAluno(int alunoId);
	public void alterarAluno(Aluno aluno);
	public List<Aluno> todosAlunos();
	public Aluno alunoPorId(int alunoId);
}
// Interface que vai ser implementada por esta classe