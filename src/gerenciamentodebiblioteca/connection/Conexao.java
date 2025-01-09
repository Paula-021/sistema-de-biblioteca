/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anapa
 */
public class Conexao {
    public Connection getConnection()throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciamentodebiblioteca", "root", "24458667ap2");
        return conexao;
        
    }
    
}
