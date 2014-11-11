/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Motorizacao;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface MotorizacaoDAO {
    public List listarPorMarcaId(int modeloID);
    
    public Motorizacao buscar(int id);
    
}
