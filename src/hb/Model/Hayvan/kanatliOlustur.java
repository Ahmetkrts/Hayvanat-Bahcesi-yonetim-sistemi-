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
public class kanatliOlustur extends Hayvan {

    private int ucaBilir;
    private int yirtici;
    private int beslenme;
    private int guvenlikk;
    private baglanti baglanti;

    public kanatliOlustur(String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, Hucre hucre) {
        super(irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, hucre);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getHayvanhuy().yirticiMi(yirtici));
        list.add(getBaglanti().getBeslenmeBicimi().et_yem_yemekBicimi(beslenme));
        list.add(getBaglanti().getOzellikler().ucaBilirMi(ucaBilir));
        return list;
    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("yirtici");
        isim.add("beslenme");
        isim.add("ucabilir");
        return isim;
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

    public int getGuvenlikk() {
        return guvenlikk;
    }

    public void setGuvenlikk(int guvenlikk) {
        this.guvenlikk = guvenlikk;
    }

    public int getBeslenme() {
        return beslenme;
    }

    public void setBeslenme(int beslenme) {
        this.beslenme = beslenme;
    }

    public int getYirtici() {
        return yirtici;
    }

    public void setYirtici(int yirtici) {
        this.yirtici = yirtici;
    }

    public int getUcaBilir() {
        return ucaBilir;
    }

    public void setUcaBilir(int ucaBilir) {
        this.ucaBilir = ucaBilir;
    }

}