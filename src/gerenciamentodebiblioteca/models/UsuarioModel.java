/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.models;

import gerenciamentodebiblioteca.daos.UsuarioDao;
import gerenciamentodebiblioteca.entities.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class UsuarioModel {

    public void insert(Usuario usuario) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.insert(usuario);
    }

    public ArrayList<Usuario> selectAll() throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        ArrayList<Usuario> usuarios = dao.selectAll();
        return usuarios;
    }

    public void update(Usuario usuario) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.update(usuario);
    }

    public void delete(int id) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.delete(id);
    }
    
}
