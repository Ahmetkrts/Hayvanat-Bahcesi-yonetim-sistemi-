/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;

import hb.Model.Bakici.bakici;
import hb.Model.Hayvan.Hayvan2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casper
 */
public class Dosya implements Serializable {

    public void Ekle(int kapasite, String DosyaYolu) {
        KapasiteDosyaYaz(kapasite, DosyaYolu);

    }

    public void Ekle(bakici bakici, String DosyaYolu) {
        List<bakici> bakiciList = BakiciDosyaOku(DosyaYolu);
        bakiciList.add(bakici);
        BakiciDosyaYaz(bakiciList, DosyaYolu);

    }

    public void Ekle(Hayvan2 hayvan, String DosyaYolu) {
        List<Hayvan2> hayvanList = HayvanDosyaOku(DosyaYolu);
        hayvanList.add(hayvan);
        HayvanDosyaYaz(hayvanList, DosyaYolu);

    }

    public void HayvanDosyaYaz(List<Hayvan2> hayvanList, String DosyaYolu) {
        try (ObjectOutputStream hayvanDosyasi = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DosyaYolu)))) {
            for (Hayvan2 hayvan : hayvanList) {
                hayvanDosyasi.writeObject(hayvan);
            }
            System.out.println("Hayvan Basarili Sekilde Eklendi\n");
        } catch (Exception e) {
        }

    }

    public List<Hayvan2> HayvanDosyaOku(String DosyaYolu) {

        List<Hayvan2> hayvanList = new ArrayList<>();
        try (ObjectInputStream hayvanDosyasi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DosyaYolu)))) {
            boolean eof = false;
            while (!eof) {
                try {

                    Hayvan2 hayvan = (Hayvan2) hayvanDosyasi.readObject();
                    //System.out.println("buray gelemedin daha");
                    //System.out.println(hayvan.toString());
                    hayvanList.add(hayvan);
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("IOExeption : " + e.getMessage());
            System.out.println("\nHayvan Okunurken Hata Meydana Geldi");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dosya.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hayvanList;

    }

    public void BakiciDosyaYaz(List<bakici> bakiciList, String DosyaYolu) {
        try (ObjectOutputStream bakiciDosyasi = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DosyaYolu)))) {
            for (bakici bakicii : bakiciList) {
                bakiciDosyasi.writeObject(bakicii);
            }
            System.out.println("\nbasarili bir sekilde bakici eklendi\n");
        } catch (Exception e) {
            System.out.println("bakici ekleme basarisiz oldu\n");
        }

    }

    public List<bakici> BakiciDosyaOku(String DosyaYolu) {

        List<bakici> bakiciList = new ArrayList<>();
        try (ObjectInputStream bakiciDosyasi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DosyaYolu)))) {
            boolean eof = false;
            int d = 0;
            while (!eof) {
                //System.out.println("ilk tryi gecti");
                try {

                    bakici Bakici = (bakici) bakiciDosyasi.readObject();
                    bakiciList.add(Bakici);
                    if (d < 1) {
                        System.out.println("Bakici basarili bir sekilde okundu");
                    }
                    d++;
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            //System.out.println("IOExeption : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dosya.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bakiciList;

    }

    public void KapasiteDosyaYaz(int kapasite, String Kapasite) {
        try (ObjectOutputStream kapasiteDosya = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Kapasite)))) {
            kapasiteDosya.writeObject(kapasite);
            if ("dosya/BakiciId.dat".equals(Kapasite)) {
                System.out.println(kapasite - 1 + " ID Dosyaya yazildi");
            } else {
                System.out.println(kapasite + " kapasite Dosyaya yazildi");
            }
        } catch (Exception e) {
        }

    }

    public int KapasiteDosyaOku(String Kapasite) {
        int x;
        if ("dosya/BakiciId.dat".equals(Kapasite) || "dosya/HayvanId.dat".equals(Kapasite)) {
            x = 1;
        } else {
            x = 0;
        }
        try (ObjectInputStream kapasiteDosya = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Kapasite)))) {
            boolean eof = false;
            while (!eof) {
                try {

                    int kapasite = (int) kapasiteDosya.readObject();
                    x = kapasite;
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            //System.out.println("IOExeption : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("kapasite dosya yazilamadi");
        }

        return x;

    }
}
