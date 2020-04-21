/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hucre;

/**
 *
 * @author Casper
 */
public class Hucre {

    private static int id;
    private final int hucreNo;
    private int bakiciId;
    private int hayvanId;
    private String hucreAdi;
    private String hucreTuru;
    private int maxHayvanBoyutu;
    private int hayvanSayisi;

    public Hucre() {
        hucreNo = id;
        id++;
    }

    public Hucre(int bakiciId, int hayvanId, String hucreAdi, String hucreTuru, int maxHayvanBoyutu, int hayvanSayisi) {
        hucreNo = id;
        id++;
        this.bakiciId = bakiciId;
        this.hayvanId = hayvanId;
        this.hucreAdi = hucreAdi;
        this.hucreTuru = hucreTuru;
        this.maxHayvanBoyutu = maxHayvanBoyutu;
        this.hayvanSayisi = hayvanSayisi;
    }

    public int getBakiciId() {
        return bakiciId;
    }

    public void setBakiciId(int bakiciId) {
        this.bakiciId = bakiciId;
    }

    public int getHayvanId() {
        return hayvanId;
    }

    public void setHayvanId(int hayvanId) {
        this.hayvanId = hayvanId;
    }

    public String getHucreAdi() {
        return hucreAdi;
    }

    public void setHucreAdi(String hucreAdi) {
        this.hucreAdi = hucreAdi;
    }

    public String getHucreTuru() {
        return hucreTuru;
    }

    public void setHucreTuru(String hucreTuru) {
        this.hucreTuru = hucreTuru;
    }

    public int getMaxHayvanBoyutu() {
        return maxHayvanBoyutu;
    }

    public void setMaxHayvanBoyutu(int maxHayvanBoyutu) {
        this.maxHayvanBoyutu = maxHayvanBoyutu;
    }

    public int getHayvanSayisi() {
        return hayvanSayisi;
    }

    public void setHayvanSayisi(int hayvanSayisi) {
        this.hayvanSayisi = hayvanSayisi;
    }

}
