/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Veiculo;
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
public class JDBCVeiculoDAO implements VeiculoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCVeiculoDAO(Connection connection) {
        this.con = connection;
    }

    @Override
    public void inserir(Veiculo veiculo) {
        try {
            SQL = "INSERT INTO veiculo(placa, renavam, chassi, marca_id, modelo_id, motorizacao_id) VALUES(?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(SQL);
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getRenavam());
            ps.setString(3, veiculo.getChassi());
            ps.setInt(4, veiculo.getMarca().getId());
            ps.setInt(5, veiculo.getModelo().getId());
            ps.setInt(6, veiculo.getMotorizacao().getId());

            ps.executeUpdate();

            ps.close();

            this.inserirItensConfortoSeguranca(veiculo);

        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir veiculo", ex);
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
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar conexao em JDBCVeiculoDAO", ex);
            }
        }

    }

    @Override
    public Veiculo buscar(int id) {
        Veiculo v = new Veiculo();
        try {

            SQL = "SELECT * FROM veiculo where id = ?";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setPlaca(rs.getString("placa"));
                v.setRenavam(rs.getString("renavam"));
                v.setChassi(rs.getString("chassi"));
                v.getMarca().setId(rs.getInt("marca_id"));
                v.getModelo().setId(rs.getInt("modelo_id"));
                v.getMotorizacao().setId(rs.getInt("motorizacao_id"));
            }
            
            v.setIcs(this.listarItemConfortoSegurancaPorVeiculo(id));
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    private int lerIdVeiculo() {
        try {
            SQL = "SELECT MAX(id) as id FROM veiculo";

            ps = con.prepareStatement(SQL);

            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao pegar o ultimo Veiculo inserido", ex);
        } finally {
            try {
                if(ps != null && ps.isClosed()) {
                    ps.close();
                }
                if(rs != null && rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void inserirItensConfortoSeguranca(Veiculo veiculo) {
        PreparedStatement pstmt = null;
        
        try {
            SQL = "INSERT INTO veiculo_ics(veiculo_id, itens_conforto_seguranca_id) VALUES(?,?)";

            pstmt = con.prepareStatement(SQL);

            pstmt.setInt(1, this.lerIdVeiculo());

            for (ItemConfortoSeguranca ics : veiculo.getIcs()) {
                pstmt.setInt(2, ics.getId());
                pstmt.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir a List<ItemConfortoSeguranca>", ex);
        } finally {
            try {
                if(ps != null && ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private List<ItemConfortoSeguranca> listarItemConfortoSegurancaPorVeiculo(int idVeiculo) {
        List<ItemConfortoSeguranca> itemConfortoSegurancas = new ArrayList<ItemConfortoSeguranca>();
        PreparedStatement pstmt = null;
        ResultSet resultado = null;
        try {
            
            SQL = "SELECT ics.id, ics.descricao FROM itens_conforto_seguranca ics INNER JOIN veiculo_ics vi ON ics.id = vi.itens_conforto_seguranca_id where vi.veiculo_id = ? ORDER BY vi.itens_conforto_seguranca_id ASC;";

            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, idVeiculo);
            resultado = pstmt.executeQuery();

            while (resultado.next()) {
                ItemConfortoSeguranca ics = new ItemConfortoSeguranca();

                ics.setId(resultado.getInt("id"));
                ics.setDescricao(resultado.getString("descricao"));
                itemConfortoSegurancas.add(ics);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
        return itemConfortoSegurancas;
    }

}
