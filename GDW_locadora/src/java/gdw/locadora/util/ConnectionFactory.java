/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gdw.locadora.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author lucas
 */
public class ConnectionFactory {
    public static Connection getConnection() {
        
        try {
            InitialContext initialContext = new InitialContext();
            
            DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/gdw_locadora");
            
            return ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("SQLException: Erro ao obter conexão em ConnectionFactory ", ex);
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("SQLException: Erro ao obter conexão em ConnectionFactory ", ex);
        }
    }
}
