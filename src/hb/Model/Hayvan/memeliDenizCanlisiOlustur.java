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
public class memeliDenizCanlisiOlustur extends Hayvan  implements Serializable {

    private int ofkeli;
    private int aquaDisindaYasar;
    private baglanti baglanti;

    public memeliDenizCanlisiOlustur(String sinif,String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif,irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(getBaglanti().getOzellikler().aquaDisindaYasarMi(aquaDisindaYasar));
        list.add(getBaglanti().getHayvanhuy().ofkeliMi(ofkeli));
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
                + "Öfekeli: "+getBaglanti().getHayvanhuy().ofkeliMi(ofkeli)+"\n";

    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("aquaDisindaYasar");
        isim.add("ofkeli");
        return isim;
    }

    public int getOfkeli() {
        return ofkeli;
    }

    public void setOfkeli(int ofkeli) {
        this.ofkeli = ofkeli;
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
