/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gdw.locadora.util;

import gdw.locadora.model.dao.ClienteDAO;
import gdw.locadora.model.dao.FuncionarioDAO;
import gdw.locadora.model.dao.ItemConfortoSegurancaDAO;
import gdw.locadora.model.dao.JDBCClienteDAO;
import gdw.locadora.model.dao.JDBCFuncionarioDAO;
import gdw.locadora.model.dao.JDBCItemConfortoSegurancaDAO;
import gdw.locadora.model.dao.JDBCMarcaDAO;
import gdw.locadora.model.dao.JDBCModeloDAO;
import gdw.locadora.model.dao.JDBCMotorizacaoDAO;
import gdw.locadora.model.dao.JDBCVeiculoDAO;
import gdw.locadora.model.dao.MarcaDAO;
import gdw.locadora.model.dao.ModeloDAO;
import gdw.locadora.model.dao.MotorizacaoDAO;
import gdw.locadora.model.dao.VeiculoDAO;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class DAOFactory {
    public static ClienteDAO getClienteDAO(Connection connection) {
        return new JDBCClienteDAO(connection);
    }
    
    public static FuncionarioDAO getFuncionarioDAO(Connection connection){
        return new JDBCFuncionarioDAO(connection);
    }
    
    public static MarcaDAO getMarcaDAO() {
        return new JDBCMarcaDAO();
    }
    
    public static ModeloDAO getModeloDAO(){
        return new JDBCModeloDAO();
    }
    
    public static MotorizacaoDAO getMotorizacaoDAO() {
        return new JDBCMotorizacaoDAO();
    }
    
    public static ItemConfortoSegurancaDAO getItemConfortoSegurancaDAO(){
        return new JDBCItemConfortoSegurancaDAO();
    }
    
    public static VeiculoDAO getVeiculoDAO(Connection connection) {
        return new JDBCVeiculoDAO(connection);
    }
}
