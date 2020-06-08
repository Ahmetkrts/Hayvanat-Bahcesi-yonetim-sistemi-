/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Model.Ilac;
import hb.Model.Asi;
import hb.Model.HayvanOzelliklerii.beslenmeBicimi;
import hb.Model.HayvanOzelliklerii.guvenlik;
import hb.Model.HayvanOzelliklerii.hayvanHuylari;
import hb.Model.HayvanOzelliklerii.ozellikler;
import java.util.ArrayList;

/**
 *
 * @author Casper
 */
public class denizCanlisiOlustur extends Hayvan2 implements beslenmeBicimi, guvenlik, hayvanHuylari, ozellikler {

    private int aquaDisindaYasar;
    private int yemek;
    private int yirtici;
    private int sosyal;
    private int guvenlik;

    public denizCanlisiOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, String Hucre) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, Hucre);
    }

    public denizCanlisiOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(aquaDisindaYasarMi(aquaDisindaYasar));
        list.add(et_yem_yemekBicimi(yemek));
        list.add(guvenlik(guvenlik));
        list.add(yirticiMi(yirtici));
        list.add(sosyalMi(sosyal));
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
                + "Aqua Dışında Yaşar: " + aquaDisindaYasarMi(aquaDisindaYasar) + "\n"
                + "Yemek: " + et_yem_yemekBicimi(yemek) + "\n"
                + "Güvenlik: " + guvenlik(guvenlik) + "\n"
                + "Yırtıcı: " + yirticiMi(yirtici) + "\n"
                + "Hücre: " + super.getHucre() + "\n"
                + "Sosyal: " + sosyalMi(sosyal) + "\n";

    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("Aqua Dışında Yaşar");
        isim.add("yemek");
        isim.add("guvenlik");
        isim.add("yirtici");
        isim.add("sosyal");
        return isim;
    }

    public int getAquaDisindaYasar() {
        return aquaDisindaYasar;
    }

    public void setAquaDisindaYasar(int aquaDisindaYasar) {
        this.aquaDisindaYasar = aquaDisindaYasar;
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

    public int getGuvenlik() {
        return guvenlik;
    }

    public void setGuvenlik(int guvenlik) {
        this.guvenlik = guvenlik;
    }

    public int getYemek() {
        return yemek;
    }

    public void setYemek(int yemek) {
        this.yemek = yemek;
    }
}
