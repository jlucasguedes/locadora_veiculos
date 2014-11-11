/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model.dao;

import gdw.locadora.model.Funcionario;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface FuncionarioDAO {
    public void inserir(Funcionario funcionario);
    public void excluir(int id);
    public List<Funcionario> listar();
    public void atualizar(Funcionario funcionario);
    public Funcionario buscar(int id);          
    public Funcionario buscar(String cpf);     
}
