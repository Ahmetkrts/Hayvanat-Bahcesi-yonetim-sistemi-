/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model;

/**
 *
 * @author Casper
 */
public class Hucre {

    private String kafesTuru;
    private int hayvanId;

    public Hucre(String kafesTuru, int hayvanId) {
        this.kafesTuru = kafesTuru;
        this.hayvanId = hayvanId;
    }

    public String getKafesTuru() {
        return kafesTuru;
    }

    public void setKafesTuru(String kafesTuru) {
        this.kafesTuru = kafesTuru;
    }

    public int getHayvanId() {
        return hayvanId;
    }

    public void setHayvanId(int hayvanId) {
        this.hayvanId = hayvanId;
    }

}
