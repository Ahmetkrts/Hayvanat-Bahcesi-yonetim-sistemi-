/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hucre;

import java.util.List;

/**
 *
 * @author Casper
 */
public class acikAlanOlustur extends Hucre {

    private List<String> hayvanTuruList;

    public acikAlanOlustur(int bakiciId, int hayvanId, String hucreAdi, String hucreTuru, int maxHayvanBoyutu, int hayvanSayisi) {
        super(bakiciId, hayvanId, hucreAdi, hucreTuru, maxHayvanBoyutu, hayvanSayisi);
    }

    public List<String> getHayvanTuruList() {
        return hayvanTuruList;
    }

    public void setHayvanTuruList(List<String> hayvanTuruList) {
        this.hayvanTuruList = hayvanTuruList;
    }
    

}
