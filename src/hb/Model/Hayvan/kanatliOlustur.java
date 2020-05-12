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
public class kanatliOlustur extends Hayvan2 implements beslenmeBicimi,guvenlik,hayvanHuylari,ozellikler  {

    private int ucaBilir;
    private int yirtici;
    private int beslenme;
    private int guvenlik;

    public kanatliOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, String Hucre) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, Hucre);
    }

    public kanatliOlustur(String sinif, String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(sinif, irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    @Override
    public ArrayList<String> hayvanListesi() {
        ArrayList<String> list = super.hayvanListesi();
        list.add(yirticiMi(yirtici));
        list.add(et_yem_yemekBicimi(beslenme));
        list.add(ucaBilirMi(ucaBilir));
        list.add(guvenlik(guvenlik));
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
                + "Yırtıcı: " + yirticiMi(yirtici) + "\n"
                + "Beslenme: " + et_yem_yemekBicimi(beslenme) + "\n"
                + "Uça Bilir: " + ucaBilirMi(ucaBilir) + "\n"
                + "Hücre: "+super.getHucre()+"\n"
                + "Güvenlik: " + guvenlik(guvenlik) + "\n";

    }

    @Override
    public ArrayList<String> isim() {
        ArrayList<String> isim = super.isim();
        isim.add("yirtici");
        isim.add("beslenme");
        isim.add("ucabilir");
        isim.add("güvenlik");
        return isim;
    }

    public int getGuvenlik() {
        return guvenlik;
    }

    public void setGuvenlik(int guvenlik) {
        this.guvenlik = guvenlik;
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
