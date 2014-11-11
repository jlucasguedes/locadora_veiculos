/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Veiculo;
import gdw.locadora.model.dao.VeiculoDAO;
import gdw.locadora.util.ConnectionFactory;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class CadastrarVeiculo implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Connection con = ConnectionFactory.getConnection();
            VeiculoDAO vd = DAOFactory.getVeiculoDAO(con);
            Veiculo veiculo = new Veiculo();
            
            veiculo.setPlaca(request.getParameter("placa"));
            veiculo.setRenavam(request.getParameter("renavam"));
            veiculo.setChassi(request.getParameter("chassi"));
            veiculo.getMarca().setId(Integer.parseInt(request.getParameter("marca")));
            veiculo.getModelo().setId(Integer.parseInt(request.getParameter("modelo")));
            veiculo.getMotorizacao().setId(Integer.parseInt(request.getParameter("motorizacao")));
            
            List<ItemConfortoSeguranca> ics = new ArrayList<ItemConfortoSeguranca>();
            
            for(String idIcs : request.getParameterValues("ics")) {
                ItemConfortoSeguranca itemConfortoSeguranca = new ItemConfortoSeguranca();
                itemConfortoSeguranca.setId(Integer.parseInt(idIcs));            
                ics.add(itemConfortoSeguranca);
            }
            
            veiculo.setIcs(ics);
            
            vd.inserir(veiculo);
            
            con.close();
            request.getRequestDispatcher("Controller?acao=Redirecionamento&page=cadastro_veiculo").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
