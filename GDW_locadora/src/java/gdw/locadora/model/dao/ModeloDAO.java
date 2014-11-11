/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Modelo;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface ModeloDAO {
    public List listarPorMarcaId(int marcaId);   
    
    public Modelo buscar(int id);
}
