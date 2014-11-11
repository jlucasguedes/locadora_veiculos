/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.Funcionario;
import gdw.locadora.model.dao.FuncionarioDAO;
import gdw.locadora.util.ConnectionFactory;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class ListarFuncionario implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Connection con = ConnectionFactory.getConnection();

            FuncionarioDAO fd = DAOFactory.getFuncionarioDAO(con);

            List<Funcionario> funcionarios = fd.listar();
            con.close();
            request.setAttribute("funcionarios", funcionarios);

            request.getRequestDispatcher("listar_funcionario").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
