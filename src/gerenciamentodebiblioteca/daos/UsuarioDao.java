/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.daos;

import gerenciamentodebiblioteca.connection.Conexao;
import gerenciamentodebiblioteca.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class UsuarioDao {

    public void insert(Usuario usuario) throws SQLException {
        String comandoSql = " INSERT INTO Usuario (id, nome, endereco, email) VALUES (?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, usuario.getId());
        estadoPreparado.setString(2, usuario.getNome());
        estadoPreparado.setString(3, usuario.getEndereco());
        estadoPreparado.setString(4, usuario.getEmail());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public ArrayList<Usuario> selectAll() throws SQLException {
        String comandoSql = " SELECT * FROM Usuario";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet rs = estadoPreparado.executeQuery();
        ArrayList<Usuario> usuarios = new ArrayList();
        
        while (rs.next()) {            
            Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("email"));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void update(Usuario usuario) throws SQLException {
        String comandoSql = "UPDATE Usuario SET nome = ?, endereco = ?, email = ? WHERE id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setString(1, usuario.getNome());
        estadoPreparado.setString(2, usuario.getEndereco());
        estadoPreparado.setString(3, usuario.getEmail());
        estadoPreparado.setInt(4, usuario.getId());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public void delete(int id) throws SQLException {
        String comandoSql = "DELETE FROM Usuario WHERE id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, id);
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }
    
}
