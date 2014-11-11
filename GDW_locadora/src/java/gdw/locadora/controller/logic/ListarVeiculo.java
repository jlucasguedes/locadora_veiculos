/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.Veiculo;
import gdw.locadora.model.dao.VeiculoDAO;
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
public class ListarVeiculo implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Connection con = ConnectionFactory.getConnection();

            VeiculoDAO vd = DAOFactory.getVeiculoDAO(con);
            List<Veiculo> veiculos = vd.listar();

            con.close();

            request.setAttribute("veiculos", veiculos);

            request.getRequestDispatcher("listar_veiculo").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
