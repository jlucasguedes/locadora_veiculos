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
public class EditarCliente implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
                        
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Cliente cliente = new Cliente();

            cliente.setId(Integer.parseInt(request.getParameter("id")));
            cliente.setNome(request.getParameter("nome"));
            cliente.setDataDeNascimento(sdf.parse(request.getParameter("data_nascimento")));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setRg(request.getParameter("rg"));
            cliente.setEndereco(request.getParameter("endereco"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setCnh(request.getParameter("cnh"));
            
            Connection con = ConnectionFactory.getConnection();
            
            ClienteDAO cd = DAOFactory.getClienteDAO(con);
            
            cd.atualizar(cliente);
            
            con.close();
            
            request.getRequestDispatcher("Controller?acao=Redirecionamento&page=editar_cliente").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
