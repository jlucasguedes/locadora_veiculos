/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Marca;
import gdw.locadora.model.Modelo;
import gdw.locadora.model.Motorizacao;
import gdw.locadora.model.Veiculo;
import gdw.locadora.model.dao.MarcaDAO;
import gdw.locadora.model.dao.ModeloDAO;
import gdw.locadora.model.dao.MotorizacaoDAO;
import gdw.locadora.model.dao.VeiculoDAO;
import gdw.locadora.util.ConnectionFactory;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "TesteBuscarVeiculo", urlPatterns = {"/TesteBuscarVeiculo"})
public class TesteBuscarVeiculo extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            VeiculoDAO vd = DAOFactory.getVeiculoDAO(con);
            MarcaDAO marcaDAO = DAOFactory.getMarcaDAO();
            ModeloDAO modeloDAO = DAOFactory.getModeloDAO();
            MotorizacaoDAO motorizacaoDAO = DAOFactory.getMotorizacaoDAO();
            
            Veiculo v = vd.buscar(7);
            Marca marca = marcaDAO.buscar(v.getMarca().getId());
            Modelo modelo = modeloDAO.buscar(v.getModelo().getId());
            Motorizacao motorizacao = motorizacaoDAO.buscar(v.getMotorizacao().getId());
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TesteBuscarVeiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>VEICULO ENCONTRADO!</h1>");
            out.println("<span style=\"font-weight: bold;\">ID: </span>" + v.getId() + "<br />");
            out.println("<span style=\"font-weight: bold;\">Placa: </span>" + v.getPlaca() + "<br />");
            out.println("<span style=\"font-weight: bold;\">Renavam: </span>" + v.getRenavam() + "<br />");
            out.println("<span style=\"font-weight: bold;\">Chassi: </span>" + v.getChassi() + "<br />");
            out.println("<span style=\"font-weight: bold;\">marca: </span>" + marca.getNomeMarca() + "<br />");
            out.println("<span style=\"font-weight: bold;\">modelo: </span>" + modelo.getNomeModelo() + "<br />");
            out.println("<span style=\"font-weight: bold;\">motorizacao: </span>" + motorizacao.getMotorizacao() + "<br />");
            out.println("<span style=\"font-weight: bold;\">Itens Conforto e Segurança: </span><br />");
            for(ItemConfortoSeguranca ics: v.getIcs()){
                out.println(ics.getDescricao() + "<br />");
            }            
            out.println("</body>");
            out.println("</html>");
        } finally {
            try {
                out.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TesteBuscarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
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
