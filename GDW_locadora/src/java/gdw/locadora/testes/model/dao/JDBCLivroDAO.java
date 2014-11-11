/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes.model.dao;

import gdw.locadora.testes.model.Autor;
import gdw.locadora.testes.model.Livro;
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
public class JDBCLivroDAO implements LivroDAO {

    private Connection con = null;
    private String SQL = null;

    public JDBCLivroDAO() {
    }

    @Override
    public void inserirLivro(Livro livro) {
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();

            SQL = "INSERT INTO livro (titulo_livro) VALUES(?)";

            ps = con.prepareStatement(SQL);

            ps.setString(1, livro.getTitulo());

            ps.executeUpdate();

            ps.close();

            this.gravarAutores(livro);

        } catch (SQLException ex) {
            Logger.getLogger(JDBCLivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir livro em JDBCLivroDAO", ex);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCLivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao fechar conexao em JDBCLivroDAO.inserirLivro()", ex);
            }
        }
    }

    @Override
    public Livro consultarLivro(int id) {
        con = ConnectionFactory.getConnection();
        SQL = "SELECT * FROM livro WHERE id_livro = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Livro livroLido = null;
        try {
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            livroLido = new Livro();
            livroLido.setId(rs.getInt("id_livro"));
            livroLido.setTitulo(rs.getString("titulo_livro"));
            List<Autor> autores = this.lerAutores(id);
            livroLido.setAutores(autores);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return livroLido;
    }

    private int lerIdLivro() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        SQL = "SELECT MAX(id_livro) FROM livro";
        int idLivro = 0;
        try {
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            rs.next();
            idLivro = rs.getInt(1);
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idLivro;
    }

    public void gravarAutores(Livro livro) {
        PreparedStatement ps = null;
        SQL = "INSERT INTO livro_autor (id_livro, id_autor) VALUES (?, ?)";
        try {
            ps = con.prepareStatement(SQL);
            ps.setInt(1, this.lerIdLivro());
            for (Autor autor : livro.getAutores()) {
                ps.setInt(2, autor.getId());
                ps.executeUpdate();
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Autor> lerAutores(int idLivro) {
        String sql = "SELECT autor.id_autor, autor.nome_autor FROM livro_autor INNER JOIN autor ON autor.id_autor = livro_autor.id_autor INNER JOIN livro ON livro_autor.id_livro = ?";
        PreparedStatement stmt = null;
        List<Autor> autores = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idLivro);
            ResultSet resultado = stmt.executeQuery();
            autores = new ArrayList<Autor>();
            while (resultado.next()) {
                Autor autorLido = new Autor();
                autorLido.setId(resultado.getInt("id_autor"));
                autorLido.setNome(resultado.getString("nome_autor"));

                autores.add(autorLido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }

}
