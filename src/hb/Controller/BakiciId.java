/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;
import hb.Model.Kapasite;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Casper
 */
public class BakiciId implements Serializable{
    
    private String idDosyaYolu = "BakiciId.dat";

    public void IdEkle(int id) {
        idDosyaYaz(id);

    }

    public void idDosyaYaz(int id) {
        try (ObjectOutputStream idDosya = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(idDosyaYolu)))) {
            idDosya.writeObject(id);
            System.out.println("Bakici Id Ekleme Basarili\n");
        } catch (Exception e) {
        }

    }

    public int IdDosyaOku() {
        int x = 1;
        try (ObjectInputStream idDosya = new ObjectInputStream(new BufferedInputStream(new FileInputStream(idDosyaYolu)))) {
            boolean eof = false;
            while (!eof) {
                try {

                   int id = (int) idDosya.readObject();
                   x = id;
                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("IOExeption : " + e.getMessage());
            System.out.println("id dosya yazilamadi");
        } catch (ClassNotFoundException ex) {
            System.out.println("id dosya yazilamadi");
        }

        return x;

    }

}
