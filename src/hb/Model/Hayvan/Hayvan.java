/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Model.Ilac;
import hb.Model.Asi;
import hb.Model.Hucre.Hucre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class Hayvan {

    private static int id;
    private final int hayvanNo;
    private String irki;
    private String ismi;
    private String dogumTarihi;
    private String gelisTarihi;
    private String cinsiyeti;
    private Ilac ilac;
    private Asi asi;
    private Hucre hucre;

    public Hayvan() {
        hayvanNo = id;
        id++;
    }

    public Hayvan(String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, Hucre hucre) {

        hayvanNo = id;
        id++;
        this.irki = irki;
        this.hucre = hucre;
        this.ismi = ismi;
        this.dogumTarihi = dogumTarihi;
        this.gelisTarihi = gelisTarihi;
        if (cinsiyeti == 1) {
            this.cinsiyeti = "Erkek";
        } else if (cinsiyeti == 0) {
            this.cinsiyeti = "Dişi";
        }
        this.ilac = ilac;
        this.asi = asi;
    }

    public static void setId(int id) {
        Hayvan.id = id;
    }

    public List<String> huyListesi() {
        List<String> list = new ArrayList<>();
        return list;
    }

    public void setIrki(String irki) {
        this.irki = irki;
    }

    public void setHucre(Hucre hucre) {
        this.hucre = hucre;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public void setGelisTarihi(String gelisTarihi) {
        this.gelisTarihi = gelisTarihi;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public void setIlac(Ilac ilac) {
        this.ilac = ilac;
    }

    public void setAsi(Asi asi) {
        this.asi = asi;
    }

    public static int getId() {
        return id;
    }

    public int getHayvanNo() {
        return hayvanNo;
    }

    public String getIrki() {
        return irki;
    }

    public Hucre getHucre() {
        return hucre;
    }

    public String getIsmi() {
        return ismi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public String getGelisTarihi() {
        return gelisTarihi;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public Ilac getIlac() {
        return ilac;
    }

    public Asi getAsi() {
        return asi;
    }

}
