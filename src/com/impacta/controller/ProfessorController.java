package com.impacta.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impacta.dao.ProfessorDAO;
import com.impacta.dao.ProfessorDAOImplementation;
import com.impacta.model.Professor;


@WebServlet("/ProfessorController")
public class ProfessorController extends HttpServlet {
	private ProfessorDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_PROFESSOR = "/listarProfessor.jsp";
    public static final String INSERIR_OU_DELETAR = "/professor.jsp";
    public static final String LOGIN = "/login.jsp";
    public static final String TESTE = "/teste.jsp";
 
    public ProfessorController() {
        dao = new ProfessorDAOImplementation();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" ); 
        
        if(action==null ||  action.trim().equalsIgnoreCase( "listarProfessor" )){
        	 forward = LISTAR_PROFESSOR;
             request.setAttribute("professor", dao.todosProfessores());
        }else if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LISTAR_PROFESSOR;
            int professorId = Integer.parseInt( request.getParameter("professorId") );
            dao.deletarProfessor(professorId);
            request.setAttribute("professor", dao.todosProfessores());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERIR_OU_DELETAR;
            int professorId = Integer.parseInt( request.getParameter("professorId") );
            Professor professor = dao.professorPorId(professorId);
            request.setAttribute("professor", professor );
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERIR_OU_DELETAR;
        }
        else if( action.equalsIgnoreCase( "login" ) ) {
            forward = LOGIN;
            request.setAttribute("aluno", dao.todosProfessores());
        }
        else if( action.equalsIgnoreCase( "teste" ) ) {
            forward = TESTE;
            request.setAttribute("aluno", dao.todosProfessores());
        }
        else{
        	
        }
        
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Professor professor = new Professor();
        professor.setNomeProfessor( request.getParameter( "nomeProfessor" ) );
        professor.setRa( request.getParameter( "ra" ) );
        professor.setSenha( request.getParameter( "senha" ) );
        String professorId = request.getParameter("professorId");
 
        if( professorId == null || professorId.isEmpty() )
            dao.addProfessor(professor);
        else {
        	professor.setIdProfessor( Integer.parseInt(professorId) );
            dao.alterarProfessor(professor);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_PROFESSOR );
        request.setAttribute("professor", dao.todosProfessores());
        view.forward(request, response);
 
}
}