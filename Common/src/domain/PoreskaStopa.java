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
public class PoreskaStopa implements Serializable{
    private int id;
    private double vrednost;

    public PoreskaStopa() {
    }

    public PoreskaStopa(int id, double vrednost) {
        this.id = id;
        this.vrednost = vrednost;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    

    @Override
    public String toString() {
        return "PoreskaStopa{" + "id=" + id + ", vrednost=" + vrednost + '}';
    }
    
    
}
