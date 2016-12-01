package com.impacta.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impacta.dao.LivroDAO;
import com.impacta.dao.LivroDAOImplementation;
import com.impacta.model.Livro;
import com.impacta.model.Professor;


@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private LivroDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_LIVRO = "/listarLivros.jsp";
    public static final String INSERIR_OU_DELETAR = "/livros.jsp";
    public static final String LOGIN = "/login.jsp";
    public static final String TESTE = "/teste.jsp";
 
    public LivroController() {
        dao = new LivroDAOImplementation();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" ); 
        
        if(action==null ||  action.trim().equalsIgnoreCase( "listarLivro" )){
        	 forward = LISTAR_LIVRO;
             request.setAttribute("livro", dao.todosLivros());
        }else if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LISTAR_LIVRO;
            int idLivro = Integer.parseInt( request.getParameter("livroId") );
            dao.deletarLivro(idLivro);
            request.setAttribute("livro", dao.todosLivros());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERIR_OU_DELETAR;
            int idLivro = Integer.parseInt( request.getParameter("livroId") );
            Livro livro = dao.livroPorId(idLivro);
            request.setAttribute("livro", livro );
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERIR_OU_DELETAR;
        }
        else if( action.equalsIgnoreCase( "login" ) ) {
            forward = LOGIN;
            request.setAttribute("livro", dao.todosLivros());
        }
        else if( action.equalsIgnoreCase( "teste" ) ) {
            forward = TESTE;
            request.setAttribute("livro", dao.todosLivros());
        }
        else{
        	
        }
        
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Livro livro = new Livro();
        livro.setNomeLivro( request.getParameter( "nomeLivro" ) );
        livro.setAnoLivro( request.getParameter( "anoLivro" ) );
        livro.setAutorLivro( request.getParameter( "autorLivro" ) );
        String idLivro = request.getParameter("idLivro");
 
        if( idLivro == null || idLivro.isEmpty() )
            dao.addLivro(livro);
        else {
        	
            dao.alterarLivro(livro);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_LIVRO );
        request.setAttribute("livro", dao.todosLivros());
        view.forward(request, response);
 
}
}