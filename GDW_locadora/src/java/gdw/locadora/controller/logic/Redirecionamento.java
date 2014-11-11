/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Marca;
import gdw.locadora.model.dao.ItemConfortoSegurancaDAO;
import gdw.locadora.model.dao.MarcaDAO;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class Redirecionamento implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        if (page.equals("cadastro_veiculo")) {
            MarcaDAO md = DAOFactory.getMarcaDAO();
            ItemConfortoSegurancaDAO id = DAOFactory.getItemConfortoSegurancaDAO();

            List<ItemConfortoSeguranca> icses = id.listar();
            List<Marca> marcas = md.listar();

            request.setAttribute("icses", icses);
            request.setAttribute("marcas", marcas);
            request.getRequestDispatcher(page).forward(request, response);
        } else if (page.equals("listar_cliente")) {
            request.getRequestDispatcher("Controller?acao=ListarCliente").forward(request, response);
        } else if (page.equals("listar_funcionario")) {
            request.getRequestDispatcher("Controller?acao=ListarFuncionario").forward(request, response);
        } else if (page.equals("listar_veiculo")) {
            request.getRequestDispatcher("Controller?acao=ListarVeiculo").forward(request, response);
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }

    }

}
