/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.ItemConfortoSeguranca;
import gdw.locadora.model.Veiculo;
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

            this.inserirItensConfortoSeguranca(veiculo);

        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir veiculo", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
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
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return v;
    }

    private int lerIdVeiculo() {
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            SQL = "SELECT MAX(id) as id FROM veiculo";

            pstmt = con.prepareStatement(SQL);

            res = pstmt.executeQuery();
            res.next();
            return res.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao pegar o ultimo Veiculo inserido", ex);
        } finally {
            try {
                if (pstmt != null && pstmt.isClosed()) {
                    pstmt.close();
                }
                if (res != null && res.isClosed()) {
                    res.close();
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
                if (pstmt != null && pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void excluirItensConfortoSegurança(int id) {

        PreparedStatement pstmt = null;

        try {

            SQL = "DELETE FROM veiculos_ics WHERE veiculo_id = ?";

            pstmt = con.prepareStatement(SQL);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
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
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (resultado != null && !resultado.isClosed()) {
                    resultado.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return itemConfortoSegurancas;
    }

    @Override
    public void excluir(int id) {
        try {
            SQL = "DELETE FROM veiculo WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            ps.executeUpdate();

            this.excluirItensConfortoSegurança(id);

        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir Veiculo e Itens de Conforto e Segurança", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public List<Veiculo> listar() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();

        try {
            SQL = "SELECT v.id, v.placa, v.renavam, v.chassi, ma.id as marca_id, ma.nome_marca, mo.id as modelo_id, mo.nome_modelo, mt.id AS motorizacao_id, mt.motorizacao FROM veiculo v INNER JOIN marca ma ON ma.id = v.marca_id INNER JOIN modelo mo ON mo.id = v.modelo_id INNER JOIN motorizacao mt ON mt.id = v.motorizacao_id";

            ps = con.prepareStatement(SQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("id"));
                v.setPlaca(rs.getString("placa"));
                v.setRenavam(rs.getString("renavam"));
                v.setChassi(rs.getString("chassi"));
                v.getMarca().setId(rs.getInt("marca_id"));
                v.getMarca().setNomeMarca(rs.getString("nome_marca"));
                v.getModelo().setId(rs.getInt("modelo_id"));
                v.getModelo().setNomeModelo(rs.getString("nome_modelo"));
                v.getMotorizacao().setId(rs.getInt("motorizacao_id"));
                v.getMotorizacao().setMotorizacao(rs.getString("motorizacao"));

                v.setIcs(this.listarItemConfortoSegurancaPorVeiculo(v.getId()));
                
                veiculos.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar Veiculos e Itens de Conforto e Segurança", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCVeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return veiculos;
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo buscar(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
