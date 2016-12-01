package com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.impacta.model.Livro;
import com.impacta.util.DBUtil;

public class LivroDAOImplementation implements LivroDAO {

	private Connection conn;
	
	public LivroDAOImplementation(){
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addLivro(Livro livro) {
		try {
			String query = "insert into livro (nomeLivro, anoLivro, autorLivro) values (?,?,?)";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setString(1, livro.getNomeLivro());
			prepared.setString(2, livro.getAnoLivro());
			prepared.setString(3, livro.getAutorLivro());
			prepared.executeUpdate();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletarLivro(int idLivro) {
		try {
			String query = "delete from livro where idLivro=?";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setInt(1, idLivro);
			prepared.executeUpdate();
			prepared.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarLivro(Livro livro) {
		   try {
	            String query = "update livro set nomeLivro=?, anoLivro=?, autorLivro=? where idLivro=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, livro.getNomeLivro());
	            preparedStatement.setString( 2, livro.getAnoLivro());
	            preparedStatement.setString( 3, livro.getAutorLivro());
	            preparedStatement.setInt( 4, livro.getIdLivro());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Livro> todosLivros() {
		 List<Livro> livros = new ArrayList<Livro>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from livro" );
	            while( resultSet.next() ) {
	            	Livro livro = new Livro();
	            	livro.setIdLivro( resultSet.getInt( "idLivro" ) );
	            	livro.setNomeLivro( resultSet.getString( "nomeLivro" ) );
	            	livro.setAnoLivro( resultSet.getString( "anoLivro" ) );
	            	livro.setAutorLivro( resultSet.getString( "autorLivro" ) );
	            	livros.add(livro);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return livros;
	}

	@Override
	public Livro livroPorId(int idLivro) {
		Livro livro = new Livro();
	        try {
	            String query = "select * from livro where idLivro=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setInt(1, idLivro);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() ) {
	            	livro.setIdLivro( resultSet.getInt( "idLivro" ) );
	            	livro.setNomeLivro( resultSet.getString( "nomeLivro" ) );
	            	livro.setAnoLivro( resultSet.getString( "anoLivro" ) );
	            	livro.setAutorLivro( resultSet.getString( "autorLivro" ) );
	            	
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return livro;
	}



	
}
