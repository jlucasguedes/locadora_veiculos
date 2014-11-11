/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

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
 * @author Lucas
 */
public class JDBCMarcaDAO implements MarcaDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCMarcaDAO() {
        con = ConnectionFactory.getConnection();
    }

    @Override
    public List<Marca> listar() {
        List<Marca> marcas = new ArrayList();

        try {
            SQL = "SELECT * FROM marca ORDER BY id ASC";

            ps = con.prepareStatement(SQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Marca m = new Marca();

                m.setId(rs.getInt("id"));
                m.setNomeMarca(rs.getString("nome_marca"));

                marcas.add(m);
            }

            return marcas;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao listar Marca em JDBCMarcaDAO", ex);
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
                Logger.getLogger(JDBCMarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar conexões JDBCMarcaDAO", ex);
            }
        }
    }

    @Override
    public Marca buscar(int id) {
        Marca m = new Marca();
        try {
            SQL = "SELECT * FROM marca where id = ? ORDER BY id ASC";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            rs.next();
            m.setId(rs.getInt("id"));
            m.setNomeMarca(rs.getString("nome_marca"));

            return m;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao listar Marca em JDBCMarcaDAO", ex);
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
                Logger.getLogger(JDBCMarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar conexões JDBCMarcaDAO", ex);
            }
        }
    }
}
