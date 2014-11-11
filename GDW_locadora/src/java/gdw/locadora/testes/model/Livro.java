/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Livro {

    private int id;
    private String titulo;
    private List<Autor> autores;

    public Livro() {
        this.autores = new ArrayList<Autor>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    
}
