/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Saki
 */
public class Mesto implements Serializable{
    private int id;
    private String grad;
    private int postanskiBroj;
    private String ulica;

    public Mesto() {
    }

    public Mesto(int idM, String grad, int postanskiBroj, String ulica) {
        this.id = id;
        this.grad = grad;
        this.postanskiBroj = postanskiBroj;
        this.ulica = ulica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Override
    public String toString() {
        return  grad ;
    }
    
}
