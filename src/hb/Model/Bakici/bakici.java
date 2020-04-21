/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Bakici;

import hb.Model.Hayvan.Hayvan;
import java.util.List;

/**
 *
 * @author Casper
 */
public class bakici {

    private static int id;
    private final int bakiciNo;
    private String isim;
    private String dogumTarihi;
    private int maxHayvanSayisi;
    private int maxTurSayisi;
    private String cinsiyeti;
    private List<Hayvan> hayvanList;

    public bakici() {
        this.bakiciNo = id;
        id++;

    }

    public bakici(String isim, String dogumTarihi, int maxHayvanSayisi, int maxTurSayisi, int cinsiyeti, List<Hayvan> hayvanList) {
        this.bakiciNo = id;
        id++;
        this.isim = isim;
        this.dogumTarihi = dogumTarihi;
        this.maxHayvanSayisi = maxHayvanSayisi;
        this.maxTurSayisi = maxTurSayisi;
        if (cinsiyeti == 1) {
            this.cinsiyeti = "Bay";
        } else {
            this.cinsiyeti = "Bayan";
        }
        this.hayvanList = hayvanList;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        bakici.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public int getMaxHayvanSayisi() {
        return maxHayvanSayisi;
    }

    public void setMaxHayvanSayisi(int maxHayvanSayisi) {
        this.maxHayvanSayisi = maxHayvanSayisi;
    }

    public int getMaxTurSayisi() {
        return maxTurSayisi;
    }

    public void setMaxTurSayisi(int maxTurSayisi) {
        this.maxTurSayisi = maxTurSayisi;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public List<Hayvan> getHayvanList() {
        return hayvanList;
    }

    public void setHayvanList(List<Hayvan> hayvanList) {
        this.hayvanList = hayvanList;
    }

}
