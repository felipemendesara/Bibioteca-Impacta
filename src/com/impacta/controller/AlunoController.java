package com.impacta.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impacta.dao.AlunoDAO;
import com.impacta.dao.AlunoDAOImplementation;
import com.impacta.model.Aluno;


@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private AlunoDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_ALUNO = "/listarAluno.jsp";
    public static final String INSERIR_OU_DELETAR = "/aluno.jsp";
    public static final String LOGIN = "/login.jsp";
    public static final String TESTE = "/teste.jsp";
 
    public AlunoController() {
        dao = new AlunoDAOImplementation();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" ); 
        
        if(action==null ||  action.trim().equalsIgnoreCase( "listarAluno" )){
        	 forward = LISTAR_ALUNO;
             request.setAttribute("aluno", dao.todosAlunos() );
        }else if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LISTAR_ALUNO;
            int studentId = Integer.parseInt( request.getParameter("alunoId") );
            dao.deletarAluno(studentId);
            request.setAttribute("aluno", dao.todosAlunos());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERIR_OU_DELETAR;
            int alunoId = Integer.parseInt( request.getParameter("alunoId") );
            Aluno aluno = dao.alunoPorId(alunoId);
            request.setAttribute("aluno", aluno );
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERIR_OU_DELETAR;
        }
        else if( action.equalsIgnoreCase( "login" ) ) {
        	
            forward = LOGIN;
            request.setAttribute("aluno", dao.todosAlunos());
        }
        else if( action.equalsIgnoreCase( "teste" ) ) {
            forward = TESTE;
            request.setAttribute("aluno", dao.todosAlunos());
        }
        else{
        	
        }
        
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno();
        aluno.setNomeAluno( request.getParameter( "nomeAluno" ) );
        aluno.setRA( request.getParameter( "ra" ) );
        aluno.setSenha( request.getParameter( "senha" ) );
        aluno.setIdade( Integer.parseInt( request.getParameter( "idade" ) ) );
        String alunoId = request.getParameter("alunoId");
 
        if( alunoId == null || alunoId.isEmpty() )
            dao.addAluno(aluno);
        else {
        	aluno.setAlunoId( Integer.parseInt(alunoId) );
            dao.alterarAluno(aluno);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_ALUNO );
        request.setAttribute("aluno", dao.todosAlunos());
        view.forward(request, response);
 
}
}