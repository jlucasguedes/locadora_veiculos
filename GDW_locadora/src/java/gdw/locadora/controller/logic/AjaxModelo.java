/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.Modelo;
import gdw.locadora.model.dao.ModeloDAO;
import gdw.locadora.util.DAOFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Lucas
 */
public class AjaxModelo implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        JSONArray array = new JSONArray();
        
        ModeloDAO md = DAOFactory.getModeloDAO();

        List<Modelo> modelos = md.listarPorMarcaId(Integer.parseInt(request.getParameter("marca_id")));

        for (Modelo modelo : modelos) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", modelo.getId());
            jsonObject.put("nome_modelo", modelo.getNomeModelo());
            jsonObject.put("marcaID", modelo.getMarca().getId());
            
            array.put(jsonObject);
        }
        
        String jsonResult = array.toString();

        response.setContentType("application/json");
        response.getWriter().write(jsonResult);

    }

}
