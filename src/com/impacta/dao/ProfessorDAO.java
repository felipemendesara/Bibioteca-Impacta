package com.impacta.dao;
import com.impacta.model.Professor;
import java.util.List;;
public interface ProfessorDAO {

	public void addProfessor(Professor professor);
	public void deletarProfessor(int professorId);
	public void alterarProfessor(Professor professor);
	public List<Professor> todosProfessores();
	public Professor professorPorId(int professorId);
}
