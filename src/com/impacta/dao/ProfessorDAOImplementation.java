package com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.impacta.model.Professor;

import com.impacta.util.DBUtil;

public class ProfessorDAOImplementation implements ProfessorDAO {

	private Connection conn;
	
	public ProfessorDAOImplementation(){
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addProfessor(Professor professor) {
		try {
			String query = "insert into professor (nomeProfessor, ra, senha) values (?,?,?)";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setString(1, professor.getNomeProfessor());
			prepared.setString(2, professor.getRa());
			prepared.setString(3, professor.getSenha());
			prepared.executeUpdate();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletarProfessor(int professorId) {
		try {
			String query = "delete from professor where idProfessor=?";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setInt(1, professorId);
			prepared.executeUpdate();
			prepared.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarProfessor(Professor professor) {
		   try {
	            String query = "update professor set nomeProfessor=?, ra=?, senha=? where idProfessor=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, professor.getNomeProfessor());
	            preparedStatement.setString( 2, professor.getRa());
	            preparedStatement.setString( 3, professor.getSenha());
	            preparedStatement.setInt( 4, professor.getIdProfessor());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Professor> todosProfessores() {
		 List<Professor> professores = new ArrayList<Professor>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from professor" );
	            while( resultSet.next() ) {
	            	Professor professor = new Professor();
	            	professor.setIdProfessor( resultSet.getInt( "idProfessor" ) );
	            	professor.setNomeProfessor( resultSet.getString( "nomeProfessor" ) );
	            	professor.setRa( resultSet.getString( "ra" ) );
	            	professor.setSenha( resultSet.getString( "senha" ) ); 
	            	professores.add(professor);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return professores;
	}

	@Override
	public Professor professorPorId(int professorId) {
		Professor student = new Professor();
	        try {
	            String query = "select * from professor where idProfessor=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setInt(1, professorId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() ) {
	                student.setIdProfessor( resultSet.getInt( "idProfessor" ) );
	                student.setNomeProfessor( resultSet.getString( "nomeProfessor" ) );
	                student.setRa( resultSet.getString( "ra" ) );
	                student.setSenha( resultSet.getString( "senha" ) );
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	}

	
}
