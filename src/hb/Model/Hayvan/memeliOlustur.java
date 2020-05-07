/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Model.Ilac;
import hb.Model.Asi;
import hb.Model.HayvanOzelliklerii.baglanti;
import hb.Model.Hucre.Hucre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class memeliOlustur extends Hayvan implements Serializable {

    private int ofkeli;
    private int yirtici;
    private int guvenlik;
    private int killi;
    private int sosyal;
    private baglanti baglanti;

    public memeliOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getHayvanhuy().ofkeliMi(ofkeli));
        list.add(getBaglanti().getHayvanhuy().yirticiMi(yirtici));
        list.add(getBaglanti().getGuvenlik().guvenlik(guvenlik));
        list.add(getBaglanti().getOzellikler().killiMi(killi));
        list.add(getBaglanti().getHayvanhuy().sosyalMi(sosyal));
        return list;
    }

    @Override
    public String toString() {
        return "Hayvan Numarası: " + super.getHayvanNo() + "\n"
                + "İsim: " + super.getIsmi() + "\n"
                + "Sınıfı: " + super.getSinif() + "\n"
                + "Tür: " + super.getIrki() + "\n"
                + "Doğum Tarihi: " + super.getDogumTarihi() + "\n"
                + "Geliş Tarihi: " + super.getGelisTarihi() + "\n"
                + "Cinsiyeti: " + super.getCinsiyeti() + "\n"
                + "Aşıları: " + super.getAsi().getAsiIsmi().get(0) + "\n"
                + "Ilacları: " + super.getIlac().getIlacIsmi().get(0) + "\n"
                + "Extra Özellikleri: \n"
                + "Öfkeli: " + getBaglanti().getHayvanhuy().ofkeliMi(ofkeli)+"\n"
                + "Yırtıcı: "+getBaglanti().getHayvanhuy().yirticiMi(yirtici)+"\n"
                + "Güvenlik: "+getBaglanti().getGuvenlik().guvenlik(guvenlik)+"\n"
                + "Kıllı: "+getBaglanti().getOzellikler().killiMi(killi)+"\n"
                + "Sosyal: "+getBaglanti().getHayvanhuy().sosyalMi(sosyal)+"\n";

    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("ofkeli");
        isim.add("yirtici");
        isim.add("guvenlik");
        isim.add("kıl");
        isim.add("sosyal");
        return isim;
    }

    public int getSosyal() {
        return sosyal;
    }

    public void setSosyal(int sosyal) {
        this.sosyal = sosyal;
    }

    public int getKilli() {
        return killi;
    }

    public void setKilli(int killi) {
        this.killi = killi;
    }

    public int getGuvenlik() {
        return guvenlik;
    }

    public void setGuvenlik(int guvenlik) {
        this.guvenlik = guvenlik;
    }

    public int getYirtici() {
        return yirtici;
    }

    public void setYirtici(int yirtici) {
        this.yirtici = yirtici;
    }

    public int getOfkeli() {
        return ofkeli;
    }

    public void setOfkeli(int ofkeli) {
        this.ofkeli = ofkeli;
    }

    public baglanti getBaglanti() {
        if (this.baglanti == null) {
            this.baglanti = new baglanti();
        }
        return baglanti;
    }

    public void setBaglanti(baglanti baglanti) {
        this.baglanti = baglanti;
    }

}
