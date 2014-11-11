/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.Cliente;
import gdw.locadora.model.dao.ClienteDAO;
import gdw.locadora.util.ConnectionFactory;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class CadastrarCliente implements ControllerLogic{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {            
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            Connection con = ConnectionFactory.getConnection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Cliente c = new Cliente();

            c.setNome(request.getParameter("nome"));
            c.setDataDeNascimento(sdf.parse(request.getParameter("data_nascimento")));
            c.setCpf(request.getParameter("cpf"));
            c.setRg(request.getParameter("rg"));
            c.setEndereco(request.getParameter("endereco"));
            c.setTelefone(request.getParameter("telefone"));
            c.setCnh(request.getParameter("cnh"));

            ClienteDAO cd = DAOFactory.getClienteDAO(con);

            cd.inserir(c);
            
            con.close();
            
            request.getRequestDispatcher("cadastro_cliente").forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
