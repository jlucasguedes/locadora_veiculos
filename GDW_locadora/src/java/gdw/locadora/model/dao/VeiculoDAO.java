/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Veiculo;

/**
 *
 * @author lucas
 */
public interface VeiculoDAO {

    public void inserir(Veiculo veiculo);

    public Veiculo buscar(int id);
}
