/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes.model.dao;

import gdw.locadora.testes.model.Autor;

/**
 *
 * @author lucas
 */
public interface AutorDAO {

    public void inserirAutor(Autor autor);

    public Autor consultarAutor(int id);
    
}
