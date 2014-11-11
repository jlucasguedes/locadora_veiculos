/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes.model.dao;

import gdw.locadora.testes.model.Autor;
import gdw.locadora.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class JDBCAutorDAO implements AutorDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String SQL = null;

    public JDBCAutorDAO() {
        con = ConnectionFactory.getConnection();
    }

    @Override
    public void inserirAutor(Autor autor) {
        try {

            SQL = "INSERT INTO autor (nome_autor) VALUES(?)";
            ps = con.prepareStatement(SQL);
            ps.setString(1, autor.getNome());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Autor consultarAutor(int id) {
        Autor autorLido = new Autor();
        try {
            SQL = "SELECT * FROM autor WHERE id_autor =  ?";

            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();

            autorLido.setId(rs.getInt("id_autor"));

            autorLido.setNome(rs.getString("nome_autor"));

        } catch (SQLException ex) {
            Logger.getLogger(JDBCAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autorLido;
    }
}
