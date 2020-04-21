/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import hb.Model.Ilac;
import hb.Model.Asi;
import java.util.List;

/**
 *
 * @author Casper
 */
public class kanatliOlustur extends Hayvan {

    private int ucaBilir;
    private int besleyicisiVar;

    public kanatliOlustur(String irki, String hucre, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(irki, hucre, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);
    }

    public int getUcaBilir() {
        return ucaBilir;
    }

    public void setUcaBilir(int ucaBilir) {
        this.ucaBilir = ucaBilir;
    }

    public int getBesleyicisiVar() {
        return besleyicisiVar;
    }

    public void setBesleyicisiVar(int besleyicisiVar) {
        this.besleyicisiVar = besleyicisiVar;
    }

    public String ucaBilirMi(int a) {
        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }
     public String besleyicisiVarMi(int a) {
        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    @Override
    public List<String> huyListesi() {
        List<String> list = super.huyListesi();
        list.add(ucaBilirMi(ucaBilir));
        list.add(besleyicisiVarMi(besleyicisiVar));
        return list;
    }

}
