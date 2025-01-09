/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.daos;

import gerenciamentodebiblioteca.connection.Conexao;
import gerenciamentodebiblioteca.entities.Emprestimo;
import gerenciamentodebiblioteca.entities.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class LivroDao {

    public void insert(Livro livro) throws SQLException {
        String comandoSql = "INSERT INTO Livro (id, titulo, autor, genero, isbn) VALUES (?, ?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, livro.getId());
        estadoPreparado.setString(2, livro.getTitulo());
        estadoPreparado.setString(3, livro.getAutor());
        estadoPreparado.setString(4, livro.getGenero());
        estadoPreparado.setString(5, livro.getIsbn());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public ArrayList<Livro> selectAll() throws SQLException {
        String comandoSql = "SELECT * FROM Livro";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet rs = estadoPreparado.executeQuery();
        ArrayList<Livro> livros = new ArrayList();
        
        while (rs.next()) {            
           Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("genero"), rs.getString("isbn"));
           livros.add(livro);
        }
        return livros;
    }

    public void update(Livro livro) throws SQLException {
        String comendoSql = "UPDATE Livro SET titulo = ?, autor = ?, genero = ?, isbn = ? WHERE id = ?  ";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comendoSql);
        estadoPreparado.setString(1, livro.getTitulo());
        estadoPreparado.setString(2, livro.getAutor());
        estadoPreparado.setString(3, livro.getGenero());
        estadoPreparado.setString(4, livro.getIsbn());
        estadoPreparado.setInt(5, livro.getId());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public void delete(int id) throws SQLException {
        String comandoSql = "DELETE FROM Livro WHERE id = ? ";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, id);
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
                
    }
   
}
