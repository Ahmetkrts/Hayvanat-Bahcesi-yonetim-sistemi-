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
public class memeliDenizCanlisiOlustur extends Hayvan2  implements beslenmeBicimi,guvenlik,hayvanHuylari,ozellikler  {

    private int ofkeli;
    private int aquaDisindaYasar;

    public memeliDenizCanlisiOlustur(String sinif,String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi,String Hucre) {
        super(sinif,irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi,Hucre);
    }
    public memeliDenizCanlisiOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }
    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(aquaDisindaYasarMi(aquaDisindaYasar));
        list.add(ofkeliMi(ofkeli));
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
                + "Aqua Dışında Yaşar: " + aquaDisindaYasarMi(aquaDisindaYasar)+"\n"
                + "Hücre: "+super.getHucre()+"\n"
                + "Öfekeli: "+ofkeliMi(ofkeli)+"\n";

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

}
