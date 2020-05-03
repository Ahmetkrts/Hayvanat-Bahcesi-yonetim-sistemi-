/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Model.Ilac;
import hb.Model.Asi;
import hb.Model.Hucre.Hucre;
import java.util.List;

/**
 *
 * @author Casper
 */
public class memeliOlustur extends Hayvan {

    private int ofkeli;


    public memeliOlustur(String irki, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi, Hucre hucre) {
        super(irki, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi, hucre);
    }


    public int getOfkeli() {
        return ofkeli;
    }

    public void setOfkeli(int ofkeli) {
        this.ofkeli = ofkeli;
    }

    public String ofkeliMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    @Override
    public List<String> huyListesi() {
        List<String> list = super.huyListesi();
        list.add(ofkeliMi(ofkeli));
        return list; 
    }

}
