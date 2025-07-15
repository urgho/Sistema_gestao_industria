package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL{
    private static final String HOST = "jdbc:mysql://localhost:3312/industria_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            System.out.println("Conectado ao banco de dados com sucesso.");
            return conn;
        }catch (SQLException e){
            System.out.println("Erro ao se conectar ao Banco. " + e.getMessage());
        }
        return null;
    }
}
