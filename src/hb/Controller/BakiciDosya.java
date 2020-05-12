/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;

import hb.Model.Bakici.bakici;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casper
 */
public class BakiciDosya {

    private String bakiciDosyaYolu = "BakiciDosya.dat";

    public void bakiciEkle(bakici bakici) {
        List<bakici> bakiciList = bakiciDosyaOku();
        bakiciList.add(bakici);
        bakiciDosyaYaz(bakiciList);

    }

    public void bakiciDosyaYaz(List<bakici> bakiciList) {
        try (ObjectOutputStream bakiciDosyasi = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(bakiciDosyaYolu)))) {
            for (bakici bakicii : bakiciList) {
                bakiciDosyasi.writeObject(bakicii);
            }
            System.out.println("\nbasarili bir sekilde bakici eklendi");
        } catch (Exception e) {
            System.out.println("bakici ekleme basarisiz oldu");
        }

    }

    public List<bakici> bakiciDosyaOku() {

        List<bakici> bakiciList = new ArrayList<>();
        try (ObjectInputStream bakiciDosyasi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(bakiciDosyaYolu)))) {
            boolean eof = false;
            while (!eof) {
                System.out.println("ilk tryi gecti");
                try {
                    bakici Bakici = (bakici) bakiciDosyasi.readObject();
                    bakiciList.add(Bakici);
                    System.out.println("Bakici basarili bir sekilde eklendi");
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("IOExeption : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BakiciDosya.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bakiciList;

    }

}
