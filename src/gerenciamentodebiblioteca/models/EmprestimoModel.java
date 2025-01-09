/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.models;

import gerenciamentodebiblioteca.daos.EmprestimoDao;
import gerenciamentodebiblioteca.entities.Emprestimo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class EmprestimoModel {

    public ArrayList<Emprestimo> selectAll() throws SQLException {
        EmprestimoDao dao = new EmprestimoDao();
        ArrayList<Emprestimo> emprestimos = dao.selectAll();
        return emprestimos;
    }

    public void delete(int id) throws SQLException {
        EmprestimoDao dao = new EmprestimoDao();
        dao.delete(id);
    }

    public void insert(Emprestimo emprestimo) throws SQLException {
        EmprestimoDao dao = new EmprestimoDao();
        dao.insert(emprestimo);
    }

    public void update(Emprestimo emprestimo) throws SQLException {
        EmprestimoDao dao = new EmprestimoDao();
        dao.update(emprestimo);
    }

   
     
}
