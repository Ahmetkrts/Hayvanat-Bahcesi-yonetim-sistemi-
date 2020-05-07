/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;

import hb.Model.Hayvan.Hayvan;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casper
 */
public class Dosya {

    private String hayvanDosyaYolu = "HayvanListesi.dat";

    public void hayvanEkle(Hayvan hayvan) {
        List<Hayvan> hayvanList = hayvanDosyaOku();
        hayvanList.add(hayvan);
        hayvanDosyaYaz(hayvanList);

    }

    public void hayvanDosyaYaz(List<Hayvan> hayvanList) {
        try (ObjectOutputStream hayvanDosyasi = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(hayvanDosyaYolu)))) {
            for (Hayvan hayvan : hayvanList) {
                hayvanDosyasi.writeObject(hayvan);
            }

        } catch (Exception e) {
        }

    }

    public List<Hayvan> hayvanDosyaOku() {

        List<Hayvan> hayvanList = new ArrayList<>();
        try (ObjectInputStream hayvanDosyasi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(hayvanDosyaYolu)))) {
            boolean eof = false;
            while (!eof) {
                try {

                    Hayvan hayvan = (Hayvan) hayvanDosyasi.readObject();
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
            Logger.getLogger(Dosya.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hayvanList;

    }

}
