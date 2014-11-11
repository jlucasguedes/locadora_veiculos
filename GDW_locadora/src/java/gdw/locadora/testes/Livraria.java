/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes;

import gdw.locadora.testes.model.Autor;
import gdw.locadora.testes.model.Livro;
import gdw.locadora.testes.model.dao.AutorDAO;
import gdw.locadora.testes.model.dao.JDBCAutorDAO;
import gdw.locadora.testes.model.dao.JDBCLivroDAO;
import gdw.locadora.testes.model.dao.LivroDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Livraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        AutorDAO autorDAO = new JDBCAutorDAO();
        
        //Gravando autores…
        Autor autor01 = new Autor();
        autor01.setNome("CARLOS DRUMOND");
        autorDAO.inserirAutor(autor01);

        Autor autor02 = new Autor();
        autor02.setNome("MACHADO DE ASSIS");
        autorDAO.inserirAutor(autor02);

        //Gravando livros…
        Livro livro = new Livro();
        livro.setTitulo("Literatura Brasileira");
        List<Autor> autores = new ArrayList<Autor>();
        autores.add(autorDAO.consultarAutor(1));
        autores.add(autorDAO.consultarAutor(2));
        livro.setAutores(autores);
        LivroDAO livroDAO = new JDBCLivroDAO();
        livroDAO.inserirLivro(livro);
        } catch(Exception ex) {
            System.out.println("" + ex.getMessage());
        }

//        //Listando livros…
//        Livro livroObtido = livroDAO.consultarLivro(1);
//        System.out.println("Título: " + livroObtido.getTitulo());
//        List<Autor> autoresDoLivro = livroObtido.getAutores();
//        Iterator iterator = autoresDoLivro.iterator();
//        System.out.println("Autores");
//
//        for (Autor autor : autoresDoLivro) {
//            System.out.println("Nome: " + autor.getNome());
//        }
    }

}
