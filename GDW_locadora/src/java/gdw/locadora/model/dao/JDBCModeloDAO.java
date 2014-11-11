/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Marca;
import gdw.locadora.model.Modelo;
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
 * @author Lucas
 */
public class JDBCModeloDAO implements ModeloDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCModeloDAO() {
        con = ConnectionFactory.getConnection();
    }

    @Override
    public List listarPorMarcaId(int marcaId) {
        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            SQL = "SELECT * FROM modelo where marca_id = ?";
            
            ps = con.prepareStatement(SQL);
            
            ps.setInt(1, marcaId);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Modelo modelo = new Modelo();
                
                modelo.setId(rs.getInt("id"));
                modelo.setNomeModelo(rs.getString("nome_modelo"));
                modelo.getMarca().setId(rs.getInt("marca_id"));
                
                modelos.add(modelo);
            }
            
            return modelos;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro a listar modelos em JDBCModeloDAO ", ex);
        } finally {
            try {
                if(con!=null && !con.isClosed()) {
                    con.close();
                }
                if(ps!=null && !ps.isClosed()) {
                    ps.close();
                }
                if(rs!=null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar conexões JDBCModeloDAO ", ex);
            }
        }
    }

    @Override
    public Modelo buscar(int id) {
        Modelo m = new Modelo();
        try {
            SQL = "SELECT * FROM modelo where id = ? ORDER BY id ASC";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            rs.next();
            m.setId(rs.getInt("id"));
            m.setNomeModelo(rs.getString("nome_modelo"));

            return m;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao buscar Modelo em JDBCModeloDAO", ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar conexões JDBCModeloDAO", ex);
            }
        }
    }
}
