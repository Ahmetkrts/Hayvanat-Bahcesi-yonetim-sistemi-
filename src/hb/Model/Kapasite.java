/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model;

import hb.Controller.KusKapasiteDosya;
import hb.Controller.NormalAcikAlanKapasiteDosya;
import hb.Controller.NormalAkvaryumKapasiteDosya;
import hb.Controller.SuluAcikKapasiteDosya;
import hb.Controller.TehlikeliAcikAlanKapasiteDosya;
import hb.Controller.TehlikeliAkvaryumKapasiteDosya;

/**
 *
 * @author techn
 */
public class Kapasite {
    private TehlikeliAcikAlanKapasiteDosya TAAdosya = new TehlikeliAcikAlanKapasiteDosya();
    private NormalAcikAlanKapasiteDosya NAAkapasite = new NormalAcikAlanKapasiteDosya();
    private KusKapasiteDosya kusKapasite = new KusKapasiteDosya();
    private NormalAkvaryumKapasiteDosya NAkapasite = new NormalAkvaryumKapasiteDosya();
    private TehlikeliAkvaryumKapasiteDosya TAkapasiteDosya = new TehlikeliAkvaryumKapasiteDosya();
    private SuluAcikKapasiteDosya SAkapasiteDosya = new SuluAcikKapasiteDosya();
    private int SuluAcikkapasite = SAkapasiteDosya.KapasiteDosyaOku();
    private int TehlikeliAkvaryumKapasite = TAkapasiteDosya.KapasiteDosyaOku();
    private int NormalAkvaryumKapasite = NAkapasite.KapasiteDosyaOku();
    private int KusKapasite = kusKapasite.KapasiteDosyaOku();
    private int TehlikeliAcikAlanKapasite = TAAdosya.KapasiteDosyaOku();
    private int NormalAcikAlan = NAAkapasite.KapasiteDosyaOku();
    
    
    public void SuluAcikkapasiteAzalt() {
        if (this.SuluAcikkapasite != 0) {
            SuluAcikkapasite--;
            SAkapasiteDosya.KapasiteEkle(SuluAcikkapasite);
            System.out.println("kapasite azaltildi");
        }
    }

    public void SuluAcikkapasiteArttir() {
        if (this.SuluAcikkapasite <= 50) {
            SuluAcikkapasite++;
            SAkapasiteDosya.KapasiteEkle(SuluAcikkapasite);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getSuluAcikkapasite() {
        return SuluAcikkapasite;
    }

    public void TehlikeliAkvaryumKapasiteAzalt() {
        if (this.TehlikeliAkvaryumKapasite != 0) {
            TehlikeliAkvaryumKapasite--;
            TAkapasiteDosya.KapasiteEkle(TehlikeliAkvaryumKapasite);
            System.out.println("kapasite azaltildi");
        }
    }

    public void TehlikeliAkvaryumKapasiteArttir() {
        if (this.TehlikeliAkvaryumKapasite <= 50) {
            TehlikeliAkvaryumKapasite++;
            TAkapasiteDosya.KapasiteEkle(TehlikeliAkvaryumKapasite);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getTehlikeliAkvaryumKapasite() {
        return TehlikeliAkvaryumKapasite;
    }
    
    public void NormalAkvaryumKapasiteAzalt() {
        if (this.NormalAkvaryumKapasite != 0) {
            NormalAkvaryumKapasite--;
            NAkapasite.KapasiteEkle(NormalAkvaryumKapasite);
            System.out.println("kapasite azaltildi");
        }
    }

    public void NormalAkvaryumKapasiteArttir() {
        if (this.NormalAkvaryumKapasite <= 50) {
            NormalAkvaryumKapasite++;
            NAkapasite.KapasiteEkle(NormalAkvaryumKapasite);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getNormalAkvaryumKapasite() {
        return NormalAkvaryumKapasite;
    }
    
    public void KusKapasiteAzalt() {
        if (this.KusKapasite != 0) {
            KusKapasite--;
            kusKapasite.KapasiteEkle(KusKapasite);
            System.out.println("kapasite azaltildi");
        }
    }

    public void KusKapasiteArttir() {
        if (this.KusKapasite <= 50) {
            KusKapasite++;
            kusKapasite.KapasiteEkle(KusKapasite);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getKusKapasite() {
        return KusKapasite;
    }
    
    public void TehlikeliAcikAlanKapasiteAzalt() {
        if (this.TehlikeliAcikAlanKapasite != 0) {
            TehlikeliAcikAlanKapasite--;
            TAAdosya.KapasiteEkle(TehlikeliAcikAlanKapasite);
            System.out.println("kapasite azaltildi");
        }
    }

    public void TehlikeliAcikAlanKapasiteArttir() {
        if (this.TehlikeliAcikAlanKapasite <= 50) {
            TehlikeliAcikAlanKapasite++;
            TAAdosya.KapasiteEkle(TehlikeliAcikAlanKapasite);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getTehlikeliAcikAlanKapasite() {
        return TehlikeliAcikAlanKapasite;
    }
    
    
    public void NormalAcikAlanAzalt() {
        if (this.NormalAcikAlan != 0) {
            NormalAcikAlan--;
            NAAkapasite.KapasiteEkle(NormalAcikAlan);
            System.out.println("kapasite azaltildi");
        }
    }

    public void NormalAcikAlanArttir() {
        if (this.NormalAcikAlan <= 50) {
            NormalAcikAlan++;
            NAAkapasite.KapasiteEkle(NormalAcikAlan);
            System.out.println("kapasite arttirildi");
        }
    }

    public int getNormalAcikAlan() {
        return NormalAcikAlan;
    }
    
}
