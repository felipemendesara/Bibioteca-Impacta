package com.impacta.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBUtil {
 
    private static Connection conn;
 
    public static Connection getConnection() {
        if( conn != null )
            return conn;
//Conexão com o banco
        try {
            //properties.load( inputStream );
            String driver ="com.mysql.jdbc.Driver";//meu driver
            String user = "root" ;//usuario
            String url =  "jdbc:mysql://127.0.0.1:3306/teste" ;//url se liga ta muito rapido?nao
            String password =  "admin" ;//senha
            Class.forName( driver );//objeto do meu driver
            conn = DriverManager.getConnection( url, user, password ); // Dados recebido em cima

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return conn;
    }
 
    public static void closeConnection( Connection toBeClosed ) { // Encerrando conexão
        if( toBeClosed == null ) // Se for finalisada retorna nula
            return;
        try {
            toBeClosed.close();//se tudo ok fecha conexão
        } catch (SQLException e) {
            e.printStackTrace();// se nao deu ruim
        }
    }
}