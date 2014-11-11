/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Veiculo;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface VeiculoDAO {

    public void inserir(Veiculo veiculo);

    public void excluir(int id);

    public List<Veiculo> listar();

    public void atualizar(Veiculo veiculo);

    public Veiculo buscar(int id);

    public Veiculo buscar(String placa);

}
