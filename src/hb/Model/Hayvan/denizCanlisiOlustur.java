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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class denizCanlisiOlustur extends Hayvan {

    private int yemek;
    private int yirtici;
    private int sosyal;
    private int guvenlikk;
    private baglanti baglanti;

    public denizCanlisiOlustur(String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, Hucre hucre) {
        super(irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, hucre);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getBeslenmeBicimi().et_yem_yemekBicimi(yemek));
        list.add(getBaglanti().getGuvenlik().guvenlik(guvenlikk));
        list.add(getBaglanti().getHayvanhuy().yirticiMi(yirtici));
        list.add(getBaglanti().getHayvanhuy().sosyalMi(sosyal));
        return list;
    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("guvenlik");
        isim.add("yemek");
        isim.add("yirtici");
        isim.add("sosyal");
        return isim;
    }

    public int getSosyal() {
        return sosyal;
    }

    public void setSosyal(int sosyal) {
        this.sosyal = sosyal;
    }

    public int getYirtici() {
        return yirtici;
    }

    public void setYirtici(int yirtici) {
        this.yirtici = yirtici;
    }

    public int getGuvenlikk() {
        return guvenlikk;
    }

    public void setGuvenlikk(int guvenlikk) {
        this.guvenlikk = guvenlikk;
    }

    public int getYemek() {
        return yemek;
    }

    public void setYemek(int yemek) {
        this.yemek = yemek;
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
