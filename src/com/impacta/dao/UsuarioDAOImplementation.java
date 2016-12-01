package com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.impacta.model.Aluno;
import com.impacta.model.Usuario;
import com.impacta.util.DBUtil;

public class UsuarioDAOImplementation implements UsuarioDAO {

	private Connection conn;
	
	public UsuarioDAOImplementation(){
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addUsuario(Usuario usuario) {
		try {
			String query = "insert into usuarios(nomeUsuario, senhaUsuario) values (?,?)";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setString(1, usuario.getNomeUsuario());
			prepared.setString(2, usuario.getSenhaUsuario());
			prepared.executeUpdate();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletarUsuario(int idUsuario) {
		try {
			String query = "delete from usuarios where idUsuario=?";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setInt(1, idUsuario);
			prepared.executeUpdate();
			prepared.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		   try {
	            String query = "update usuarios set nomeUsuario=?,senhaUsuario=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, usuario.getNomeUsuario() );
	            preparedStatement.setString( 2, usuario.getSenhaUsuario());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Usuario> todosUsuarios() {
		 List<Usuario> usuario = new ArrayList<Usuario>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from usuarios" );
	            while( resultSet.next() ) {
	            	Usuario usuarios = new Usuario();
	            	usuarios.setIdUsuario( resultSet.getInt( "idUsuario" ) );
	            	usuarios.setNomeUsuario( resultSet.getString( "nomeUsuario" ) );
	            	usuarios.setSenhaUsuario( resultSet.getString( "senhaUsuario" ) );
	            	usuario.add(usuarios);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usuario;
	}

	@Override
	public Usuario usuarioPorId(int idUsuario) {
		Usuario usuario = new Usuario();
	        try {
	            String query = "select * from usuarios where idUsuario=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setInt(1, idUsuario);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() ) {
	            	usuario.setIdUsuario( resultSet.getInt( "idUsuario" ) );
	            	usuario.setNomeUsuario( resultSet.getString( "nomeUsuario" ) );
	            	usuario.setSenhaUsuario( resultSet.getString( "senhaUsuario" ) );
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usuario;
	}

	
}
