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
public class surungenOlustur extends Hayvan {

    private int zehirli;
    private int aquaDisindaYasar;
    private int guvenlikk;
    private int yemek;
    private int yirtici;
    private int boy;
    private baglanti baglanti;

    public surungenOlustur(String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, Hucre hucre) {
        super(irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, hucre);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getOzellikler().aquaDisindaYasarMi(aquaDisindaYasar));
        list.add(getBaglanti().getOzellikler().zehirliMi(zehirli));
        list.add(getBaglanti().getGuvenlik().guvenlik(guvenlikk));
        list.add(getBaglanti().getBeslenmeBicimi().et_yem_yemekBicimi(yemek));
        list.add(getBaglanti().getHayvanhuy().yirticiMi(yirtici));
        list.add(getBaglanti().getOzellikler().boyuBesMetredenBuyukMu(boy));
        return list;
    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("zehirli");
        return isim;
    }

    public int getAquaDisindaYasar() {
        return aquaDisindaYasar;
    }

    public void setAquaDisindaYasar(int aquaDisindaYasar) {
        this.aquaDisindaYasar = aquaDisindaYasar;
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

    public int getYirtici() {
        return yirtici;
    }

    public void setYirtici(int yirtici) {
        this.yirtici = yirtici;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
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

    public int getZehirli() {
        return zehirli;
    }

    public void setZehirli(int zehirli) {
        this.zehirli = zehirli;
    }

}
