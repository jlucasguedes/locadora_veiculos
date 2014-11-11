/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.controller.logic;

import gdw.locadora.model.Motorizacao;
import gdw.locadora.model.dao.ModeloDAO;
import gdw.locadora.model.dao.MotorizacaoDAO;
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
 * @author lucas
 */
public class AjaxMotorizacao implements ControllerLogic {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        JSONArray array = new JSONArray();
        
        MotorizacaoDAO md = DAOFactory.getMotorizacaoDAO();

        List<Motorizacao> motorizacoes = md.listarPorMarcaId(Integer.parseInt(request.getParameter("modelo_id")));

        for (Motorizacao motorizacao : motorizacoes) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", motorizacao.getId());
            jsonObject.put("motorizacao", motorizacao.getMotorizacao());
            jsonObject.put("modeloID", motorizacao.getModelo().getId());
            
            array.put(jsonObject);
        }
        
        String jsonResult = array.toString();

        response.setContentType("application/json");
        response.getWriter().write(jsonResult);
    }
    
}
