/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.daos;

import gerenciamentodebiblioteca.connection.Conexao;
import gerenciamentodebiblioteca.entities.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class EmprestimoDao {

    public ArrayList<Emprestimo> selectAll() throws SQLException {
        String comandoSql = "SELECT * FROM Emprestimo";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet rs = estadoPreparado.executeQuery();
        ArrayList<Emprestimo> emprestimos = new ArrayList();
        
        while(rs.next()){
            Date dataInicio = rs.getDate("dataInicio");
            LocalDate dataInicioConvertida = dataInicio.toLocalDate();
            Date dataFim = rs.getDate("dataFim");
            LocalDate dataFimConvertida = dataFim.toLocalDate();
            Emprestimo emprestimo = new Emprestimo(rs.getInt("id"),rs.getInt("idLivro"),rs.getInt("idUsuario"),dataInicioConvertida, dataFimConvertida);
            emprestimos.add(emprestimo);
        }
        return emprestimos;
    }

    public void delete(int id) throws SQLException {
        String comandoSqlIdEmprestimo = "DELETE FROM Emprestimo WHERE id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparadoIdEmprestimo = con.prepareStatement(comandoSqlIdEmprestimo);
        estadoPreparadoIdEmprestimo.setInt(1, id);
        estadoPreparadoIdEmprestimo.execute();
        estadoPreparadoIdEmprestimo.close();
        con.close();
    }

    public void insert(Emprestimo emprestimo) throws SQLException {
        String comandoSql = "INSERT INTO Emprestimo (idLivro, idUsuario,dataInicio, dataFim) VALUES (?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, emprestimo.getIdLivro());
        estadoPreparado.setInt(2, emprestimo.getIdUsuario());
        LocalDate dataInicio = emprestimo.getDataInicio();
        Date dataInicioConvertida = Date.valueOf(dataInicio);
        estadoPreparado.setDate(3, dataInicioConvertida);
        LocalDate dataFim = emprestimo.getDataFim();
        Date dataFimConvertida = Date.valueOf(dataFim);
        estadoPreparado.setDate(4, dataFimConvertida);
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public void update(Emprestimo emprestimo) throws SQLException {
        String comandoSql = "UPDATE Emprestimo SET idLivro = ?, idUsuario = ? WHERE id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, emprestimo.getIdLivro());
        estadoPreparado.setInt(2, emprestimo.getIdUsuario());
        
       estadoPreparado.setInt(3, emprestimo.getId());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
        
    }
    
}
