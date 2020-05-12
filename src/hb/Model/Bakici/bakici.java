/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Bakici;

import hb.Controller.BakiciId;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Casper
 */
public class bakici implements bakiciNitelikleri,Serializable {
    private BakiciId Bakiciid = new BakiciId();
    private int id = Bakiciid.IdDosyaOku();
    private final int bakiciNo;
    private String isim;
    private String dogumTarihi;
    private String memeliNitelik;
    private String balikNitelik;
    private String surungenNitelik;
    private String kusNitelik;

    public bakici() {
        this.bakiciNo = id;
        id++;
        Bakiciid.IdEkle(id);
    }

    public ArrayList<String> bakiciListesi() {
        ArrayList<String> list = new ArrayList<>();
        list.add(String.valueOf(getBakiciNo()));
        list.add(getDogumTarihi());
        list.add(getIsim());
        return list;
    }

    public String toString() {
        if (getBalikNitelik() == null && getKusNitelik() == null && getMemeliNitelik() == null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \nYok\n";
        } else if (getBalikNitelik() != null && getKusNitelik() == null && getMemeliNitelik() == null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getBalikNitelik() + "\n";
        } else if (getBalikNitelik() == null && getKusNitelik() != null && getMemeliNitelik() == null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getKusNitelik() + "\n";
        } else if (getBalikNitelik() == null && getKusNitelik() == null && getMemeliNitelik() != null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getMemeliNitelik() + "\n";
        } else if (getBalikNitelik() == null && getKusNitelik() == null && getMemeliNitelik() == null && getSurungenNitelik() != null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getSurungenNitelik() + "\n";
        } else if (getBalikNitelik() != null && getKusNitelik() != null && getMemeliNitelik() == null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getBalikNitelik() + "\n"
                    + getKusNitelik() + "\n";
        } else if (getBalikNitelik() != null && getKusNitelik() == null && getMemeliNitelik() != null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getBalikNitelik() + "\n"
                    + getMemeliNitelik() + "\n";
        } else if (getBalikNitelik() != null && getKusNitelik() == null && getMemeliNitelik() == null && getSurungenNitelik() != null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getBalikNitelik() + "\n"
                    + getSurungenNitelik() + "\n";
        } else if (getBalikNitelik() == null && getKusNitelik() != null && getMemeliNitelik() != null && getSurungenNitelik() == null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getMemeliNitelik() + "\n"
                    + getKusNitelik() + "\n";
        } else if (getBalikNitelik() == null && getKusNitelik() != null && getMemeliNitelik() == null && getSurungenNitelik() != null) {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getKusNitelik() + "\n"
                    + getSurungenNitelik() + "\n";
        } else {
            return "Bakici Numarasi: " + this.getBakiciNo() + "\n"
                    + "İsim: " + getIsim() + "\n"
                    + "Doğum Tarihi: " + getDogumTarihi() + "\n"
                    + "--------->Nitelikleri<---------: \n"
                    + getMemeliNitelik() + "\n"
                    + getSurungenNitelik() + "\n";
        }
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

    public int getBakiciNo() {
        return bakiciNo;
    }

    public String getMemeliNitelik() {
        return memeliNitelik;
    }

    public void setMemeliNitelik(String memeliNitelik) {
        this.memeliNitelik = memeliNitelik;
    }

    public String getBalikNitelik() {
        return balikNitelik;
    }

    public void setBalikNitelik(String balikNitelik) {
        this.balikNitelik = balikNitelik;
    }

    public String getSurungenNitelik() {
        return surungenNitelik;
    }

    public void setSurungenNitelik(String surungenNitelik) {
        this.surungenNitelik = surungenNitelik;
    }

    public String getKusNitelik() {
        return kusNitelik;
    }

    public void setKusNitelik(String kusNitelik) {
        this.kusNitelik = kusNitelik;
    }

}
