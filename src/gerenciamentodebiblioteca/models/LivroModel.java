/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.models;

import gerenciamentodebiblioteca.daos.LivroDao;
import gerenciamentodebiblioteca.entities.Livro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class LivroModel {

    public void insert(Livro livro) throws SQLException {
        LivroDao dao = new LivroDao();
        dao.insert(livro);
    }

    public ArrayList<Livro> selectAll() throws SQLException {
        LivroDao dao = new LivroDao();
        ArrayList<Livro> livros = dao.selectAll();
        return livros;
    }

    public void update(Livro livro) throws SQLException {
        LivroDao dao = new LivroDao();
        dao.update(livro);
    }

    public void delete(int id) throws SQLException {
        LivroDao dao = new LivroDao();
        dao.delete(id);
    }
    
}
