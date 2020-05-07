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
public class surungenDenizCanlisiOlustur extends Hayvan  implements Serializable {

    private int zehirli;
    private int aquaDisindaYasar;
    private int guvenlik;
    private int yemek;
    private int yirtici;
    private int boy;
    private baglanti baglanti;

    public surungenDenizCanlisiOlustur(String sinif,String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif,irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getOzellikler().aquaDisindaYasarMi(aquaDisindaYasar));
        list.add(getBaglanti().getOzellikler().zehirliMi(zehirli));
        list.add(getBaglanti().getGuvenlik().guvenlik(guvenlik));
        list.add(getBaglanti().getBeslenmeBicimi().et_yem_yemekBicimi(yemek));
        list.add(getBaglanti().getHayvanhuy().yirticiMi(yirtici));
        list.add(getBaglanti().getOzellikler().boyuBesMetredenBuyukMu(boy));
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
                + "Aqua Dışında Yaşar: " + getBaglanti().getOzellikler().aquaDisindaYasarMi(aquaDisindaYasar)+"\n"
                + "Zehirli: "+getBaglanti().getOzellikler().zehirliMi(zehirli)+"\n"
                + "Güvenlik: "+getBaglanti().getGuvenlik().guvenlik(guvenlik)+"\n"
                + "Yemek: "+getBaglanti().getBeslenmeBicimi().et_yem_yemekBicimi(yemek)+"\n"
                + "Yırtıcı: "+getBaglanti().getHayvanhuy().yirticiMi(yirtici)+"\n"
                + "Boyu 5 Metre: "+getBaglanti().getOzellikler().boyuBesMetredenBuyukMu(boy)+"\n";
                
                

    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("aquaDisindaYasar");
        isim.add("zehirli");
        isim.add("guvenlik");
        isim.add("yemek");
        isim.add("yirtici");
        isim.add("boy");
        return isim;
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

    public int getGuvenlik() {
        return guvenlik;
    }

    public void setGuvenlik(int guvenlik) {
        this.guvenlik = guvenlik;
    }

    public int getZehirli() {
        return zehirli;
    }

    public void setZehirli(int zehirli) {
        this.zehirli = zehirli;
    }

    public int getAquaDisindaYasar() {
        return aquaDisindaYasar;
    }

    public void setAquaDisindaYasar(int aquaDisindaYasar) {
        this.aquaDisindaYasar = aquaDisindaYasar;
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
