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
public class AjaxBuscarFuncionarioPorCPF implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Connection con = ConnectionFactory.getConnection();

            FuncionarioDAO fd = DAOFactory.getFuncionarioDAO(con);
            Funcionario funcionario = fd.buscar(request.getParameter("cpf"));

            con.close();
            JSONObject jsonObject = new JSONObject();
            if (funcionario == null) {
                jsonObject.put("erro", "Funcionário não encontrado.") ;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                jsonObject.put("id", funcionario.getId());
                jsonObject.put("nome", funcionario.getNome());
                jsonObject.put("data_nascimento", sdf.format(funcionario.getDataDeNascimento()));
                jsonObject.put("cpf", funcionario.getCpf());
                jsonObject.put("rg", funcionario.getRg());
                jsonObject.put("endereco", funcionario.getEndereco());
                jsonObject.put("telefone", funcionario.getTelefone());
                jsonObject.put("data_admissao", funcionario.getDataDeAdmissao());
                jsonObject.put("salario", funcionario.getSalario());
            }

            String jsonResult = jsonObject.toString();

            response.setContentType("application/json");
            response.getWriter().write(jsonResult);

        } catch (SQLException ex) {
            Logger.getLogger(AjaxBuscarFuncionarioPorCPF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
