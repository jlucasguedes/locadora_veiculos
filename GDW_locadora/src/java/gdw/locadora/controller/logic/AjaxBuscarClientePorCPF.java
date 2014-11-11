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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author lucas
 */
public class AjaxBuscarClientePorCPF implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Connection con = ConnectionFactory.getConnection();

            ClienteDAO cd = DAOFactory.getClienteDAO(con);
            Cliente cliente = cd.buscar(request.getParameter("cpf"));

            con.close();

            JSONObject jsonObject = new JSONObject();
            if (cliente == null) {
                jsonObject.put("erro", "Cliente não encontrado.");
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                jsonObject.put("id", cliente.getId());
                jsonObject.put("nome", cliente.getNome());
                jsonObject.put("data_nascimento", sdf.format(cliente.getDataDeNascimento()));
                jsonObject.put("cpf", cliente.getCpf());
                jsonObject.put("rg", cliente.getRg());
                jsonObject.put("endereco", cliente.getEndereco());
                jsonObject.put("telefone", cliente.getTelefone());
                jsonObject.put("cnh", cliente.getCnh());
            }

            String jsonResult = jsonObject.toString();

            response.setContentType("application/json");
            response.getWriter().write(jsonResult);

        } catch (SQLException ex) {
            Logger.getLogger(AjaxBuscarClientePorCPF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
