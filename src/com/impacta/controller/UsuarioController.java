package com.impacta.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.impacta.dao.AlunoDAOImplementation;
import com.impacta.dao.EcontraAluno;
import com.impacta.dao.UsuarioDAOImplementation;
import com.impacta.dao.UsuarioDAO;
import com.impacta.model.Usuario;


@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private UsuarioDAO dao;
	private AlunoDAOImplementation alunos;
    private static final long serialVersionUID = 1L;
    public static final String LISTAR_USUARIO = "/listarUsuario.jsp";
    public static final String INSERIR_OU_DELETAR = "/usuario.jsp";
    public static final String LOGIN = "/login.jsp";
    public static final String TESTE = "/teste.jsp";
 
    public UsuarioController() {
        dao = new UsuarioDAOImplementation ();
        alunos = new AlunoDAOImplementation();  
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" ); 
        
        if(action==null ||  action.trim().equalsIgnoreCase( "listarUsuario" )){
        	 forward = LISTAR_USUARIO;
             request.setAttribute("usuario", dao.todosUsuarios());
        }else if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LISTAR_USUARIO;
            int idUsuario = Integer.parseInt( request.getParameter("idUsuario") );
            dao.deletarUsuario(idUsuario);
            request.setAttribute("usuario", dao.todosUsuarios());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERIR_OU_DELETAR;
            int idUsuario = Integer.parseInt( request.getParameter("idUsuario") );
            Usuario usuario = dao.usuarioPorId(idUsuario);
            request.setAttribute("usuario", usuario );
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERIR_OU_DELETAR;
        }
        else if( action.equalsIgnoreCase( "login" ) ) {
            forward = LOGIN;
            request.setAttribute("usuario", dao.todosUsuarios());
        }
        else if(action.equalsIgnoreCase( "logar" )) {
        	EcontraAluno econtraAluno = new EcontraAluno(alunos, null, dao);
            econtraAluno.encontra(request, response);
            forward = LOGIN;
        }
        else if( action.equalsIgnoreCase( "teste" ) ) {
            forward = TESTE;
            request.setAttribute("usuario", dao.todosUsuarios());
        }
        else{
        	
        }
        
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario( request.getParameter( "nomeUsuario" ) );
        usuario.setSenhaUsuario( request.getParameter( "senhaUsuario" ) );
        String idUsuario = request.getParameter("idUsuario");
 
        if( idUsuario == null || idUsuario.isEmpty() )
            dao.addUsuario(usuario);
        else {
        	usuario.setIdUsuario( Integer.parseInt(idUsuario) );
            dao.alterarUsuario(usuario);
        }
        RequestDispatcher view = request.getRequestDispatcher( LISTAR_USUARIO );
        request.setAttribute("usuario", dao.todosUsuarios());
        view.forward(request, response);
 
}
}