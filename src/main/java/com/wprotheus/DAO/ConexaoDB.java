package com.wprotheus.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static Connection fazerConexao() throws ErroDAO {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pf_web1?useSSL=false", "root", "root4321");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ErroDAO (e);
        }
    }
}