/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Veiculo {
    private int id;
    private String placa;
    private String renavam;
    private String chassi;
    private Marca marca;
    private Modelo modelo;
    private Motorizacao motorizacao;
    private List<ItemConfortoSeguranca> ics;

    public Veiculo() {
        this.marca = new Marca();
        this.modelo = new Modelo();
        this.motorizacao = new Motorizacao();
        this.ics = new ArrayList<ItemConfortoSeguranca>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
 
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Motorizacao getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(Motorizacao motorizacao) {
        this.motorizacao = motorizacao;
    }
    
    public List<ItemConfortoSeguranca> getIcs() {
        return ics;
    }

    public void setIcs(List<ItemConfortoSeguranca> ics) {
        this.ics = ics;
    }

    
}
