package gdw.locadora.model.dao;

import gdw.locadora.model.Cliente;
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
public class JDBCClienteDAO implements ClienteDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCClienteDAO(Connection connection) {
        this.con = connection;
    }

    @Override
    public void inserir(Cliente cliente) {
        try {

            SQL = "INSERT INTO cliente (nome, data_nascimento, cpf, rg, endereco, telefone, cnh)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(SQL);

            ps.setString(1, cliente.getNome());
            ps.setDate(2, new java.sql.Date(cliente.getDataDeNascimento().getTime()));
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCnh());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir Cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao PreparedStatement", ex);
            }
        }
    }

    @Override
    public void excluir(int id) {
        try {
            SQL = "DELETE FROM cliente WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir Cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PreparedStatement", ex);
            }
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            SQL = "SELECT * FROM cliente ORDER BY id";

            ps = con.prepareStatement(SQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataDeNascimento(rs.getDate("data_nascimento"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCnh(rs.getString("cnh"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir Cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PreparedStatement", ex);
            }
        }
        return clientes;
    }

    @Override
    public void atualizar(Cliente cliente) {
        try {
            SQL = "UPDATE cliente SET nome = ?, data_nascimento = ?, cpf = ?, rg = ?, endereco = ?, telefone = ?, cnh = ? WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setString(1, cliente.getNome());
            ps.setDate(2, new java.sql.Date(cliente.getDataDeNascimento().getTime()));
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCnh());
            ps.setInt(8, cliente.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao atualizar cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement", ex);
            }
        }
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = new Cliente();
        try {
            SQL = "SELECT * FROM cliente WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.next();

            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setDataDeNascimento(rs.getDate("data_nascimento"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCnh(rs.getString("cnh"));
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement ou ResulteSet", ex);
            }
        }
        return cliente;
    }

    @Override
    public Cliente buscar(String cpf) {
        Cliente cliente = new Cliente();
        try {
            SQL = "SELECT * FROM cliente WHERE cpf = ?";

            ps = con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ps.setString(1, cpf);

            rs = ps.executeQuery();
            if (rs.next()) {
                rs.previous();
                rs.next();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataDeNascimento(rs.getDate("data_nascimento"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCnh(rs.getString("cnh"));
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar cliente", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement ou ResulteSet", ex);
            }
        }
        return cliente;
    }

}
