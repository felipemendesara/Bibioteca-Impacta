package com.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.impacta.model.Aluno;

import com.impacta.util.DBUtil;

public class AlunoDAOImplementation implements AlunoDAO {

	private Connection conn;
	
	public AlunoDAOImplementation(){
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addAluno(Aluno aluno) {
		try {
			String query = "insert into aluno (nomeAluno, ra, senha, idade) values (?,?,?,?)";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setString(1, aluno.getNomeAluno());
			prepared.setString(2, aluno.getRA());
			prepared.setString(3, aluno.getSenha());
			prepared.setInt(4, aluno.getIdade());
			prepared.executeUpdate();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletarAluno(int alunoId) {
		try {
			String query = "delete from aluno where alunoId=?";
			PreparedStatement prepared = conn.prepareStatement(query);
			prepared.setInt(1, alunoId);
			prepared.executeUpdate();
			prepared.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarAluno(Aluno aluno) {
		   try {
	            String query = "update aluno set nomeAluno=?, ra=?, senha=?, idade=? where alunoId=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, aluno.getNomeAluno() );
	            preparedStatement.setString( 2, aluno.getRA());
	            preparedStatement.setString( 3, aluno.getSenha() );
	            preparedStatement.setInt( 4, aluno.getIdade());
	            preparedStatement.setInt(5, aluno.getAlunoId());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Aluno> todosAlunos() {
		 List<Aluno> students = new ArrayList<Aluno>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from aluno" );
	            while( resultSet.next() ) {
	            	Aluno student = new Aluno();
	                student.setAlunoId( resultSet.getInt( "alunoId" ) );
	                student.setNomeAluno( resultSet.getString( "nomeAluno" ) );
	                student.setRA( resultSet.getString( "ra" ) );
	                student.setSenha( resultSet.getString( "senha" ) );
	                student.setIdade( resultSet.getInt( "idade" ) );
	                students.add(student);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return students;
	}

	@Override
	public Aluno alunoPorId(int alunoId) {
		Aluno student = new Aluno();
	        try {
	            String query = "select * from aluno where alunoId=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setInt(1, alunoId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() ) {
	                student.setAlunoId( resultSet.getInt( "alunoId" ) );
	                student.setNomeAluno( resultSet.getString( "nomeAluno" ) );
	                student.setRA( resultSet.getString( "ra" ) );
	                student.setSenha( resultSet.getString( "senha" ) );
	                student.setIdade( resultSet.getInt( "idade" ) );
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	}
	
	@Override
	public Aluno login(String ra, String senha) {
		Aluno student = new Aluno();
	        try {
	            String query = "select * from aluno where ra=? and senha=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString(1, ra);
	            preparedStatement.setString(2, senha);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while( resultSet.next() ) {
	                student.setAlunoId( resultSet.getInt( "alunoId" ) );
	                student.setNomeAluno( resultSet.getString( "nomeAluno" ) );
	                student.setRA( resultSet.getString( "ra" ) );
	                student.setSenha( resultSet.getString( "senha" ) );
	                student.setIdade( resultSet.getInt( "idade" ) );
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	}

	
}
