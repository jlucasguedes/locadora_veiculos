/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gdw.locadora.model.dao;

import gdw.locadora.model.Cliente;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface ClienteDAO {
    public void inserir(Cliente cliente);
    public void excluir(int id);
    public List<Cliente> listar();
    public void atualizar(Cliente cliente);
    public Cliente buscar(int id);          
    public Cliente buscar(String cpf);          
}
