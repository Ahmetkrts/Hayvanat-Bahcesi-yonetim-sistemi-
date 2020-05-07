/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.HayvanOzelliklerii;

import java.io.Serializable;

/**
 *
 * @author techn
 */
public class baglanti implements Serializable{

    private beslenmeBicimi beslenmeBicimi;
    private guvenlik guvenlik;
    private hayvanHuylari hayvanhuy;
    private ozellikler ozellikler;

    public beslenmeBicimi getBeslenmeBicimi() {
        if (this.beslenmeBicimi == null) {
            this.beslenmeBicimi = new beslenmeBicimi();
        }
        return beslenmeBicimi;
    }

    public void setBeslenmeBicimi(beslenmeBicimi beslenmeBicimi) {
        this.beslenmeBicimi = beslenmeBicimi;
    }

    public guvenlik getGuvenlik() {
        if (this.guvenlik == null) {
            this.guvenlik = new guvenlik();
        }

        return guvenlik;
    }

    public void setGuvenlik(guvenlik guvenlik) {
        this.guvenlik = guvenlik;
    }

    public hayvanHuylari getHayvanhuy() {
        if (this.hayvanhuy == null) {
            this.hayvanhuy = new hayvanHuylari();
        }
        return hayvanhuy;
    }

    public void setHayvanhuy(hayvanHuylari hayvanhuy) {
        this.hayvanhuy = hayvanhuy;
    }

    public ozellikler getOzellikler() {
        if (this.ozellikler == null) {
            this.ozellikler = new ozellikler();
        }
        return ozellikler;
    }

    public void setOzellikler(ozellikler ozellikler) {
        this.ozellikler = ozellikler;
    }
}
