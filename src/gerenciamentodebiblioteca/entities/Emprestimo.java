/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.entities;

import java.time.LocalDate;

/**
 *
 * @author anapa
 */
public class Emprestimo {
    private int id;
    private int idLivro;
    private int idUsuario;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Emprestimo() {
    }

    public Emprestimo(int idLivro, int idUsuario, LocalDate dataInicio, LocalDate dataFim) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Emprestimo(int id, int idLivro, int idUsuario, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public Emprestimo(int id, int idLivro, int idUsuario) {
        this.id = id;
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
    
    }

   public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    
}
