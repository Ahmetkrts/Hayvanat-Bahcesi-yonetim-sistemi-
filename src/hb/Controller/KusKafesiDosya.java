/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;

import hb.Model.Hayvan.Hayvan2;
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
public class KusKafesiDosya {

    private String hayvanDosyaYolu = "KusKafesi.dat";

    public void hayvanEkle(Hayvan2 hayvan) {
        List<Hayvan2> hayvanList = hayvanDosyaOku();
        hayvanList.add(hayvan);
        hayvanDosyaYaz(hayvanList);

    }

    public void hayvanDosyaYaz(List<Hayvan2> hayvanList) {
        try (ObjectOutputStream hayvanDosyasi = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(hayvanDosyaYolu)))) {
            for (Hayvan2 hayvan : hayvanList) {
                hayvanDosyasi.writeObject(hayvan);
            }

        } catch (Exception e) {
        }

    }

    public List<Hayvan2> hayvanDosyaOku() {

        List<Hayvan2> hayvanList = new ArrayList<>();
        try (ObjectInputStream hayvanDosyasi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(hayvanDosyaYolu)))) {
            boolean eof = false;
            while (!eof) {
                try {

                    Hayvan2 hayvan = (Hayvan2) hayvanDosyasi.readObject();
                    System.out.println("buray gelemedin daha");
                    System.out.println(hayvan.toString());
                    hayvanList.add(hayvan);
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("IOExeption : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KusKafesiDosya.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hayvanList;

    }

}