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
public class KafesOlustur extends Hucre {

    private List<String> hayvanTuruList;
    private int ucabilir;
    private int ofkeli;
    private int zehirli;

    public KafesOlustur(int bakiciId, int hayvanId, String hucreAdi, String hucreTuru, int maxHayvanBoyutu, int hayvanSayisi) {
        super(bakiciId, hayvanId, hucreAdi, hucreTuru, maxHayvanBoyutu, hayvanSayisi);
    }

    

    public List<String> getHayvanTuruList() {
        return hayvanTuruList;
    }

    public void setHayvanTuruList(List<String> hayvanTuruList) {
        this.hayvanTuruList = hayvanTuruList;
    }

    public int getUcabilir() {
        return ucabilir;
    }

    public void setUcabilir(int ucabilir) {
        this.ucabilir = ucabilir;
    }

    public int getOfkeli() {
        return ofkeli;
    }

    public void setOfkeli(int ofkeli) {
        this.ofkeli = ofkeli;
    }

    public int getZehirli() {
        return zehirli;
    }

    public void setZehirli(int zehirli) {
        this.zehirli = zehirli;
    }

}
