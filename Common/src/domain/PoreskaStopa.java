/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Saki
 */
public class PoreskaStopa {
    private int id;
    private String vrednost;

    public PoreskaStopa() {
    }

    public PoreskaStopa(int id, String vrednost) {
        this.id = id;
        this.vrednost = vrednost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    @Override
    public String toString() {
        return "PoreskaStopa{" + "id=" + id + ", vrednost=" + vrednost + '}';
    }
    
    
}
