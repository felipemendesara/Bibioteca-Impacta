package com.impacta.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impacta.model.Aluno;

public class EcontraAluno {
	
	private AlunoDAO alunos;
	private ProfessorDAO professores;
	private UsuarioDAO usuarios;

	public EcontraAluno(AlunoDAO alunos, ProfessorDAO professores, UsuarioDAO usuarios) {
		this.alunos = alunos;
		this.professores = professores;
		this.usuarios = usuarios;
		
	}
	
	public Aluno encontra(HttpServletRequest request, HttpServletResponse response){
		String ra = (String) request.getParameter("ra");
		String senha = (String) request.getParameter("senha");
		Aluno login = alunos.login(ra, senha);
		request.getSession().setAttribute("alunoLogado", login);
		return login;
	}

}
