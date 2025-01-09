/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca;

import gerenciamentodebiblioteca.entities.Emprestimo;
import gerenciamentodebiblioteca.entities.Livro;
import gerenciamentodebiblioteca.entities.Usuario;
import gerenciamentodebiblioteca.models.DataModel;
import gerenciamentodebiblioteca.models.EmprestimoModel;
import gerenciamentodebiblioteca.models.LivroModel;
import gerenciamentodebiblioteca.models.UsuarioModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ana
 */
public class GerenciamentoDeBiblioteca {
    
    public static void cadastrarEmprestimo() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")) {            
            System.out.println("Digite o id do livro: "); 
            Scanner scan = new Scanner(System.in);
            int idLivro = scan.nextInt();
            System.out.println("Digite o id do usuário: ");
            int idUsuario = scan.nextInt();
            
            LocalDate dataInicio = LocalDate.now();
            
            DataModel modelDataCadastrarEmprestimo = new DataModel();
            
            LocalDate dataFim = modelDataCadastrarEmprestimo.calcularDataFim(dataInicio);
            
            
                    
            Emprestimo emprestimo = new Emprestimo(idLivro, idUsuario, dataInicio, dataFim);
            EmprestimoModel model = new EmprestimoModel();
            model.insert(emprestimo);
            System.out.println("Emprestimo cadastrado na lista. ");
            System.out.println("Deseja cadastrar mais um emprestimo? ");
            resposta = scan.next();
        }
        menu();
    }
    public static void cadastrarUsuario() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")){
            System.out.println("Digite o id: ");
            Scanner scan = new Scanner(System.in);
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Digite o nome: ");
            String nome = scan.nextLine();
            System.out.println("Digite o endereço: ");
            String endereco = scan.nextLine();
            System.out.println("Digite o e-mail: ");
            String email = scan.nextLine();
            
            Usuario usuario = new Usuario(id, nome, endereco, email);
            UsuarioModel model = new UsuarioModel();
            model.insert(usuario);
            System.out.println("Usuário cadastrado na lista. ");
            System.out.println("Deseja cadastrar mais algum usuário? ");
            resposta = scan.next();
        }
        menu();
    }
    public static void cadastrarLivro() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")){
            System.out.println("Digite o id: ");
            Scanner scan = new Scanner(System.in);
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Digite o título: ");
            String titulo = scan.nextLine();
            System.out.println("Digite o autor: ");
            String autor = scan.nextLine();
            System.out.println("Digite o genero: ");
            String genero = scan.nextLine();
            System.out.println("Digite o inbs");
            String inbs = scan.nextLine();
            
            Livro livro = new Livro(id, titulo, autor, genero, inbs);
            LivroModel model = new LivroModel();
            model.insert(livro);
            System.out.println("Livro cadastrado na lista. ");
            System.out.println("Deseja cadastrar mais um livro? ");
            resposta = scan.next();
            
        }
        menu();
    }
    public static void visualizarEmprestimo() throws SQLException{
        EmprestimoModel model = new EmprestimoModel();
        ArrayList<Emprestimo> emprestimos = model.selectAll();
        if(emprestimos.size() == 0){
            System.out.println("Nenhum empréstimo listado. ");
        }else{
            for(int i = 0; i < emprestimos.size(); i++){
                Emprestimo emprestimo = emprestimos.get(i);
                System.out.println("Id empréstimo: "+emprestimo.getId()+"\nId livro: " + emprestimo.getIdLivro() + " \nId usuário: " + emprestimo.getIdUsuario() + "\nData início: " + emprestimo.getDataInicio() +"\nData fim: " + emprestimo.getDataFim());
                
            }
        }
    }
    public static void visualizarUsuario() throws SQLException{
        UsuarioModel model = new UsuarioModel();
        ArrayList<Usuario> usuarios = model.selectAll();
        if(usuarios.size() == 0){
            System.out.println("Nenhum usuário listado. ");
        }else{
            for(int i = 0; i < usuarios.size(); i++){
               Usuario usuario =  usuarios.get(i);
                System.out.println(usuario.getId() + " - Nome: " + usuario.getNome() + "\nEndereço: " + usuario.getEndereco() + "\nE-mail: " + usuario.getEmail());
            }
        }
        
    }
    public static void visualizarLivro() throws SQLException{
        LivroModel model = new LivroModel();
        ArrayList<Livro> livros = model.selectAll();
        if(livros.size() == 0){
            System.out.println("Nenhum livro listado. ");
        }else{
            for(int i = 0; i < livros.size(); i++){
                Livro livro = livros.get(i);
                System.out.println(livro.getId() + " - Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nGenero: " + livro.getGenero() + "\nISBN: " + livro.getIsbn());
            }
        }
        
    }
    public static void editarEmprestimo() throws SQLException{
        Scanner scan = new Scanner(System.in);
        visualizarEmprestimo();
        System.out.println("Qual é o id do empréstimo que deseja editar? ");
        int idEmprestimo = scan.nextInt();
        
        visualizarLivro();
        System.out.println("Digite o id do livro: ");
        int idLivro = scan.nextInt();
        
        visualizarUsuario();
        System.out.println("Digite o id do usuário: ");
        int idUsuario = scan.nextInt();
        
        Emprestimo emprestimo = new Emprestimo(idEmprestimo, idLivro, idUsuario);
        EmprestimoModel model = new EmprestimoModel();
        model.update(emprestimo);
        System.out.println("Emprestimo editado com sucesso. ");
        menu();
    }
    public static void editarUsuario() throws SQLException{
        Scanner scan = new Scanner(System.in);
        visualizarUsuario();
        System.out.println("Qual é o id que deseja editar? ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o endereço: ");
        String endereco = scan.nextLine();
        System.out.println("Digite o e-mail: ");
        String email = scan.nextLine();
            
        Usuario usuario = new Usuario(id, nome, endereco, email);
        UsuarioModel model = new UsuarioModel();
        model.update(usuario);
        System.out.println("Usuário editado com sucesso. ");
        menu();
    }
   
    public static void editarLivro() throws SQLException{
        Scanner scan = new Scanner(System.in);
        visualizarLivro();
        System.out.println("Qual é o id que deseja editar");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o título: ");
        String titulo = scan.nextLine();
        System.out.println("Digite o autor: ");
        String autor = scan.nextLine();
        System.out.println("Digite o genero: ");
        String genero = scan.nextLine();
        System.out.println("Digite o inbs");
        String inbs = scan.nextLine();
            
        Livro livro = new Livro(id, titulo, autor, genero, inbs);
        LivroModel model = new LivroModel();
        model.update(livro);
        System.out.println("Livro editado com sucesso. ");
        menu(); 
    }
     public static void deletarEmprestimo() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual é o id do emprestimo que deseja deletar? ");
        int id = scan.nextInt();
        EmprestimoModel model = new EmprestimoModel();
        model.delete(id);
        System.out.println("Id empréstimo deletado com sucesso. ");
        menu();
    }
      public static void deletarUsuario() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual é o id do usuário que deseja deletar? ");
        int id = scan.nextInt();
        UsuarioModel model = new UsuarioModel();
        model.delete(id);
        System.out.println("Id do usuário deletado com sucesso. ");
        menu();
    }
       public static void deletarLivro() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual é o id do livro que deseja deletar? ");
        int id = scan.nextInt();
        LivroModel model = new LivroModel();
        model.delete(id);
        System.out.println("Id do livro deletado com sucesso. ");
        menu();
    }
    
    public static void menu() throws SQLException{
        System.out.println("Digite a opção desejada?\n1-cadastrar\n2-visualizar\n3-editar\n4-deletar ");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        System.out.println("Digite E para emprestimo, L para livro ou U para usuário: ");
        String tipoDeResposta = scan.next();
        
        if(opcao == 1 && tipoDeResposta.equalsIgnoreCase("E") ){
            cadastrarEmprestimo();
        }else if(opcao == 1 && tipoDeResposta.equalsIgnoreCase("L")){
            cadastrarLivro();
        }else if (opcao == 1 && tipoDeResposta.equalsIgnoreCase("U")){
            cadastrarUsuario();
        }else if(opcao == 2 && tipoDeResposta.equalsIgnoreCase("E")){
            visualizarEmprestimo();
            menu();
        }else if(opcao == 2 && tipoDeResposta.equalsIgnoreCase("L")){
            visualizarLivro();
            menu();
        }else if(opcao == 2 && tipoDeResposta.equalsIgnoreCase("U")){
            visualizarUsuario();
            menu();
        }else if(opcao == 3 && tipoDeResposta.equalsIgnoreCase("E")){
            editarEmprestimo();
        }else if(opcao == 3 && tipoDeResposta.equalsIgnoreCase("L")){
            editarLivro();
        }else if(opcao == 3 && tipoDeResposta.equalsIgnoreCase("U")){
            editarUsuario();
        }else if(opcao == 4 && tipoDeResposta.equalsIgnoreCase("E")){
            deletarEmprestimo();
        }else if (opcao == 4 && tipoDeResposta.equalsIgnoreCase("L")){
            deletarLivro();
        }else if(opcao == 4 && tipoDeResposta.equalsIgnoreCase("U")){
            deletarUsuario();
        }else{
            System.out.println("Opção inválida. ");
        }
    }

    
    public static void main(String[] args) throws SQLException {
        menu();
    }

  
    }

    

