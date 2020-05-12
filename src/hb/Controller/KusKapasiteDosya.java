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

/**
 *
 * @author Casper
 */
public class KusKapasiteDosya {

    private Kapasite kapasite;
    
    private String KapasiteDosyaYolu = "KusKapasite.dat";

    public void KapasiteEkle(int kapasite) {
        KapasiteDosyaYaz(kapasite);

    }

    public void KapasiteDosyaYaz(int kapasite) {
        try (ObjectOutputStream kapasiteDosya = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(KapasiteDosyaYolu)))) {
            kapasiteDosya.writeObject(kapasite);
            System.out.println(kapasite+"kapasiteDosyaya yazildi");
        } catch (Exception e) {
        }

    }

    public int KapasiteDosyaOku() {
        int x = 0;
        try (ObjectInputStream kapasiteDosya = new ObjectInputStream(new BufferedInputStream(new FileInputStream(KapasiteDosyaYolu)))) {
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
            System.out.println("IOExeption : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("kapasite dosya yazilamadi");
        }

        return x;

    }

}
