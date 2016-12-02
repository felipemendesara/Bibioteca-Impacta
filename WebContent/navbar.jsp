<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.impacta.model.Aluno" %>
<%@ page import="com.impacta.model.Usuario" %>
<%@ page import="com.impacta.model.Professor" %>

    
    <% Aluno aluno = (Aluno) request.getSession().getAttribute("alunoLogado"); %>
    <% Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado"); %>
    <% Professor professor = (Professor) request.getSession().getAttribute("professorLogado"); %>

    		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
		
		<c:if test="${not empty aluno }"></c:if>
		<li role="presentation" class="divider"></li>
		
			<li><a href="AlunoController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Aluno</a></li>
			<li><a href="AlunoController?action=listarAluno"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Alunos Cadastrados</a></li>
				
			<li role="presentation" class="divider"></li>


	<li role="presentation" class="divider"></li>
			<li><a href="ProfessorController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Professor</a></li>
			<li><a href="ProfessorController?action=listarProfessor"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Professores</a></li>
				
			<li role="presentation" class="divider"></li>
			
				<li role="presentation" class="divider"></li>
			<li><a href="LivroController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Livro</a></li>
			<li><a href="LivroController?action=listarLivro"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Livros</a></li>
				
			<li role="presentation" class="divider"></li>
				<li><a href="UsuarioController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Usuário</a></li>
			<li><a href="UsuarioController?action=listarUsuario"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Usuário</a></li>
			
		</ul>

	</div><!--/.sidebar-->