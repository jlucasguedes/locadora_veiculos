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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class CadastrarFuncionario implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            Connection con = ConnectionFactory.getConnection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Funcionario f = new Funcionario();
            
            f.setNome(request.getParameter("nome"));
            f.setDataDeNascimento(sdf.parse(request.getParameter("data_nascimento")));
            f.setCpf(request.getParameter("cpf"));
            f.setRg(request.getParameter("rg"));
            f.setEndereco(request.getParameter("endereco"));
            f.setTelefone(request.getParameter("telefone"));
            f.setDataDeAdmissao(sdf.parse(request.getParameter("data_admissao")));
            f.setSalario(Double.parseDouble(request.getParameter("salario")));
            
            FuncionarioDAO fd = DAOFactory.getFuncionarioDAO(con);

            fd.inserir(f);
            con.close();
            
            request.getRequestDispatcher("cadastro_funcionario").forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
    
}
