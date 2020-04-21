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
public class denizCanlisiOlustur extends Hayvan {

    private int aquaDisindaYasar;

    public denizCanlisiOlustur(String irki, String hucre, String ismi, String dogumTarihi, String gelisTarihi, int cinsiyeti, Ilac ilac, Asi asi) {
        super(irki, hucre, ismi, dogumTarihi, gelisTarihi, cinsiyeti, ilac, asi);

    }

    public int getAquaDisindaYasar() {
        return aquaDisindaYasar;
    }

    public void setAquaDisindaYasar(int aquaDisindaYasar) {
        this.aquaDisindaYasar = aquaDisindaYasar;
    }

    public String aquaDisindaYasarMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    @Override
    public List<String> huyListesi() {
        List<String> list = super.huyListesi();
        list.add(aquaDisindaYasarMi(aquaDisindaYasar));
        return list; 
    }

}
