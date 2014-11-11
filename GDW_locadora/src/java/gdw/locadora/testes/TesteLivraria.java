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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "TesteLivraria", urlPatterns = {"/TesteLivraria"})
public class TesteLivraria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        //Instanciando objeto AutorDAO
        AutorDAO autorDAO = new JDBCAutorDAO();
        
        //Gravando autores…
        Autor autor01 = new Autor();
        autor01.setNome("ALAN SHALLOWAY");
        autorDAO.inserirAutor(autor01);

        Autor autor02 = new Autor();
        autor02.setNome("JAMES TROTT");
        autorDAO.inserirAutor(autor02);
        
        //Gravando livros…
        Livro livro = new Livro();

        livro.setTitulo("Explicando Padrões de Projeto");

        List<Autor> autores = new ArrayList<Autor>();

        autores.add(autorDAO.consultarAutor(1));
        autores.add(autorDAO.consultarAutor(2));

        
        
        livro.setAutores(autores);
        
        LivroDAO livroDAO = new JDBCLivroDAO();

        livroDAO.inserirLivro(livro);

        //Listando livros…
        Livro livroObtido = livroDAO.consultarLivro(8);
        System.out.println("Título: " + livroObtido.getTitulo());
        List<Autor> autoresDoLivro = livroObtido.getAutores();
        System.out.println("Autores");

        for (Autor autor : autoresDoLivro) {
            System.out.println("ID: " + autor.getId());
            System.out.println("Nome: " + autor.getNome());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
