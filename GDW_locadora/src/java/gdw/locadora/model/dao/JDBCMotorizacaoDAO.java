/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Modelo;
import gdw.locadora.model.Motorizacao;
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
public class JDBCMotorizacaoDAO implements MotorizacaoDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCMotorizacaoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    @Override
    public List listarPorMarcaId(int modeloID) {
        List<Motorizacao> modelos = new ArrayList<Motorizacao>();
        try {
            SQL = "SELECT * FROM motorizacao where modelo_id = ?";
            
            ps = con.prepareStatement(SQL);
            
            ps.setInt(1, modeloID);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Motorizacao motorizacao = new Motorizacao();
                
                motorizacao.setId(rs.getInt("id"));
                motorizacao.setMotorizacao(rs.getString("motorizacao"));
                motorizacao.getModelo().setId(rs.getInt("modelo_id"));
                
                modelos.add(motorizacao);
            }
            
            return modelos;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMotorizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro a listar modelos em JDBCMotorizacaoDAO ", ex);
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
                Logger.getLogger(JDBCMotorizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar conexões JDBCMotorizacaoDAO ", ex);
            }
        }
    }

    @Override
    public Motorizacao buscar(int id) {
        Motorizacao m = new Motorizacao();
        try {
            SQL = "SELECT * FROM motorizacao where id = ? ORDER BY id ASC";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            rs.next();
            m.setId(rs.getInt("id"));
            m.setMotorizacao(rs.getString("motorizacao"));
            m.getModelo().setId(rs.getInt("modelo_id"));

            return m;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMotorizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao buscar Motorizacao em JDBCMotorizacaoDAO", ex);
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
                Logger.getLogger(JDBCMotorizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar conexões JDBCMotorizacaoDAO", ex);
            }
        }
    }
    
}
