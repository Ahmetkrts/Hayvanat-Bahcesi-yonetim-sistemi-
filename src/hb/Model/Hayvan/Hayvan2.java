/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Controller.Dosya;
import hb.Model.Ilac;
import hb.Model.Asi;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Casper
 */
public class Hayvan2 implements Serializable {
    private Dosya hayvanId = new Dosya();
    private int id = hayvanId.KapasiteDosyaOku("dosya/HayvanId.dat");
    private int hayvanNo;
    private String sinif;
    private String irki;
    private String ismi;
    private String dogumTarihi;
    private String gelisTarihi;
    private String cinsiyeti;
    private Ilac ilac;
    private Asi asi;
    private String Hucre;
    private Long serialVersionUID = 1L;

    public Hayvan2() {
        this.hayvanNo = id;
        id++;
        hayvanId.Ekle(id, "dosya/HayvanId.dat");
    }

    public Hayvan2(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, String Hucre) {

        hayvanNo = id;
        id++;
        hayvanId.Ekle(id, "dosya/HayvanId.dat");
        this.sinif = sinif;
        this.irki = irki;
        this.ismi = ismi;
        this.Hucre = Hucre;
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

    public Hayvan2(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {

        hayvanNo = id;
        id++;
        hayvanId.Ekle(id, "dosya/HayvanId.dat");
        this.sinif = sinif;
        this.irki = irki;
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
    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public void setIrki(String irki) {
        this.irki = irki;
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

    public int getHayvanNo() {
        return hayvanNo;
    }

    public String getIrki() {
        return irki;
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

    public String getHucre() {
        return Hucre;
    }

    public void setHucre(String Hucre) {
        this.Hucre = Hucre;
    }

    public void setHayvanNo(int hayvanNo) {
        this.hayvanNo = hayvanNo;
    }

    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = new ArrayList<>();
        list.add(getSinif());
        list.add(String.valueOf(getHayvanNo()));
        list.add(getIrki());
        list.add(getIsmi());
        list.add(getDogumTarihi());
        list.add(getGelisTarihi());
        list.add(getCinsiyeti());
        list.add(getIlac().getIlacIsmi().get(0));
        list.add(getAsi().getAsiIsmi().get(0));
        return list;
    }

    public ArrayList<String> isim() {
        ArrayList<String> isim = new ArrayList<>();
        isim.add("Sınıfı");
        isim.add("HayvanNo");
        isim.add("Irki");
        isim.add("isim");
        isim.add("DogumTarihi");
        isim.add("GelisTarihi");
        isim.add("Cinsiyeti");
        isim.add("Ilac");
        isim.add("Asi");

        return isim;
    }

    @Override
    public String toString() {
        return "Hayvan{" + "hayvanNo=" + hayvanNo + ", sinif=" + sinif + ", irki=" + irki + ", ismi=" + ismi + ", dogumTarihi=" + dogumTarihi + ", gelisTarihi=" + gelisTarihi + ", cinsiyeti=" + cinsiyeti + ", ilac=" + ilac + ", asi=" + asi + '}';
    }

}
