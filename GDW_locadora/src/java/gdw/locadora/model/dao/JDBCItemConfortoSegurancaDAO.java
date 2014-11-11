/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Marca;
import gdw.locadora.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class JDBCItemConfortoSegurancaDAO implements ItemConfortoSegurancaDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCItemConfortoSegurancaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    @Override
    public List<ItemConfortoSeguranca> listar() {
        List<ItemConfortoSeguranca> ItemConfortoSegurancas = new ArrayList<ItemConfortoSeguranca>();
        
        try {
            SQL = "SELECT * FROM itens_conforto_seguranca ORDER BY id ASC";
            
            ps = con.prepareStatement(SQL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                ItemConfortoSeguranca ics = new ItemConfortoSeguranca();
                
                ics.setId(rs.getInt("id"));
                ics.setDescricao(rs.getString("descricao"));
                
                ItemConfortoSegurancas.add(ics);
            }
            
            return ItemConfortoSegurancas;            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCItemConfortoSegurancaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao listar Marca em JDBCItemConfortoSegurancaDAO", ex);
        }finally {
            try {
                if(con != null && !con.isClosed()) {
                    con.close();
                }
                if(ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCItemConfortoSegurancaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar conexões JDBCItemConfortoSegurancaDAO", ex);
            }
        }
    }
    
}
