/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model;

import hb.Controller.Dosya;

/**
 *
 * @author techn
 */
public class Kapasite {

    private Dosya dosya = new Dosya();
    private int SuluAcikkapasite = dosya.KapasiteDosyaOku("dosya/SuluAcikKapasite.dat");
    private int TehlikeliAkvaryumKapasite = dosya.KapasiteDosyaOku("dosya/TehlikeliAkvaryumKapasite.dat");
    private int NormalAkvaryumKapasite = dosya.KapasiteDosyaOku("dosya/NormalAkvaryumKapasite.dat");
    private int KusKapasite = dosya.KapasiteDosyaOku("dosya/KusKapasite.dat");
    private int TehlikeliAcikAlanKapasite = dosya.KapasiteDosyaOku("dosya/TehlikeliAcikAlanKapasite.dat");
    private int NormalAcikAlan = dosya.KapasiteDosyaOku("dosya/NormalAcikAlanKapasite.dat");

    public void SuluAcikkapasiteAzalt() {
        if (this.SuluAcikkapasite != 0) {
            SuluAcikkapasite--;
            dosya.Ekle(SuluAcikkapasite, "dosya/SuluAcikKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void SuluAcikkapasiteArttir() {
        if (this.SuluAcikkapasite <= 50) {
            SuluAcikkapasite++;
            dosya.Ekle(SuluAcikkapasite, "dosya/SuluAcikKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getSuluAcikkapasite() {
        return SuluAcikkapasite;
    }

    public void TehlikeliAkvaryumKapasiteAzalt() {
        if (this.TehlikeliAkvaryumKapasite != 0) {
            TehlikeliAkvaryumKapasite--;
            dosya.Ekle(TehlikeliAkvaryumKapasite, "dosya/TehlikeliAkvaryumKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void TehlikeliAkvaryumKapasiteArttir() {
        if (this.TehlikeliAkvaryumKapasite <= 50) {
            TehlikeliAkvaryumKapasite++;
            dosya.Ekle(TehlikeliAkvaryumKapasite, "dosya/TehlikeliAkvaryumKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getTehlikeliAkvaryumKapasite() {
        return TehlikeliAkvaryumKapasite;
    }

    public void NormalAkvaryumKapasiteAzalt() {
        if (this.NormalAkvaryumKapasite != 0) {
            NormalAkvaryumKapasite--;
            dosya.Ekle(NormalAkvaryumKapasite, "dosya/NormalAkvaryumKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void NormalAkvaryumKapasiteArttir() {
        if (this.NormalAkvaryumKapasite <= 50) {
            NormalAkvaryumKapasite++;
            dosya.Ekle(NormalAkvaryumKapasite, "dosya/NormalAkvaryumKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getNormalAkvaryumKapasite() {
        return NormalAkvaryumKapasite;
    }

    public void KusKapasiteAzalt() {
        if (this.KusKapasite != 0) {
            KusKapasite--;
            dosya.Ekle(KusKapasite, "dosya/KusKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void KusKapasiteArttir() {
        if (this.KusKapasite <= 50) {
            KusKapasite++;
            dosya.Ekle(KusKapasite, "dosya/KusKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getKusKapasite() {
        return KusKapasite;
    }

    public void TehlikeliAcikAlanKapasiteAzalt() {
        if (this.TehlikeliAcikAlanKapasite != 0) {
            TehlikeliAcikAlanKapasite--;
            dosya.Ekle(TehlikeliAcikAlanKapasite, "dosya/TehlikeliAcikAlanKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void TehlikeliAcikAlanKapasiteArttir() {
        if (this.TehlikeliAcikAlanKapasite <= 50) {
            TehlikeliAcikAlanKapasite++;
            dosya.Ekle(TehlikeliAcikAlanKapasite, "dosya/TehlikeliAcikAlanKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getTehlikeliAcikAlanKapasite() {
        return TehlikeliAcikAlanKapasite;
    }

    public void NormalAcikAlanAzalt() {
        if (this.NormalAcikAlan != 0) {
            NormalAcikAlan--;
            dosya.Ekle(NormalAcikAlan, "dosya/NormalAcikAlanKapasite.dat");
            System.out.println("kapasite azaltildi");
        }
    }

    public void NormalAcikAlanArttir() {
        if (this.NormalAcikAlan <= 50) {
            NormalAcikAlan++;
            dosya.Ekle(NormalAcikAlan, "dosya/NormalAcikAlanKapasite.dat");
            System.out.println("kapasite arttirildi");
        }
    }

    public int getNormalAcikAlan() {
        return NormalAcikAlan;
    }

}
