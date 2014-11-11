/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Funcionario;
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
public class JDBCFuncionarioDAO implements FuncionarioDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCFuncionarioDAO(Connection connection) {
        this.con = connection;
    }

    @Override
    public void inserir(Funcionario funcionario) {
        try {

            SQL = "INSERT INTO funcionario (nome, data_nascimento, cpf, rg, endereco, telefone, data_admissao, salario)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(SQL);

            ps.setString(1, funcionario.getNome());
            ps.setDate(2, new java.sql.Date(funcionario.getDataDeNascimento().getTime()));
            ps.setString(3, funcionario.getCpf());
            ps.setString(4, funcionario.getRg());
            ps.setString(5, funcionario.getEndereco());
            ps.setString(6, funcionario.getTelefone());
            ps.setDate(7, new java.sql.Date(funcionario.getDataDeAdmissao().getTime()));
            ps.setDouble(8, funcionario.getSalario());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro: ao inserir Funcionario em JDBCFuncionarioDAO ", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro: ao fechar PreparedStatement em JDBCFuncionarioDAO ", ex);
            }
        }
    }

    @Override
    public void excluir(int id) {
        try {
            SQL = "DELETE FROM funcionario WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir Funcionario", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PreparedStatement", ex);
            }
        }
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            SQL = "SELECT * FROM funcionario ORDER BY id";

            ps = con.prepareStatement(SQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataDeNascimento(rs.getDate("data_nascimento"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setEndereco(rs.getString("Endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setDataDeAdmissao(rs.getDate("data_admissao"));
                funcionario.setSalario(rs.getDouble("salario"));

                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar Funcionario", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PreparedStatement", ex);
            }
        }
        return funcionarios;
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        try {
            SQL = "UPDATE funcionario SET nome = ?, data_nascimento = ?, cpf = ?, rg = ?, endereco = ?, telefone = ?, data_admissao = ?, salario = ? WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setString(1, funcionario.getNome());
            ps.setDate(2, new java.sql.Date(funcionario.getDataDeNascimento().getTime()));
            ps.setString(3, funcionario.getCpf());
            ps.setString(4, funcionario.getRg());
            ps.setString(5, funcionario.getEndereco());
            ps.setString(6, funcionario.getTelefone());
            ps.setDate(7, new java.sql.Date(funcionario.getDataDeAdmissao().getTime()));
            ps.setDouble(8, funcionario.getSalario());
            ps.setInt(9, funcionario.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao atualizar funcionario", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement", ex);
            }
        }
    }

    @Override
    public Funcionario buscar(int id) {
        Funcionario funcionario = new Funcionario();
        try {
            SQL = "SELECT * FROM funcionario WHERE id = ?";

            ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.next();

            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setDataDeNascimento(rs.getDate("data_nascimento"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setRg(rs.getString("rg"));
            funcionario.setEndereco(rs.getString("endereco"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setDataDeAdmissao(rs.getDate("data_admissao"));
            funcionario.setSalario(rs.getDouble("salario"));

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar funcionario", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement ou ResulteSet", ex);
            }
        }
        return funcionario;
    }

    @Override
    public Funcionario buscar(String cpf) {
        Funcionario funcionario = new Funcionario();
        try {
            SQL = "SELECT * FROM funcionario WHERE cpf = ?";

            ps = con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ps.setString(1, cpf);

            rs = ps.executeQuery();
            if (rs.next()) {
                rs.previous();
                rs.next();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataDeNascimento(rs.getDate("data_nascimento"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setDataDeAdmissao(rs.getDate("data_admissao"));
                funcionario.setSalario(rs.getDouble("salario"));
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar funcionario", ex);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar PrepareStatement ou ResulteSet", ex);
            }
        }
        return funcionario;
    }
}
