/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Controller;

import hb.Model.Hayvan.Hayvan;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Casper
 */
public class Dosya1 {

    private String hayvanDosyaYolu = "HayvanListesi.txt";

    public void hayvanEkle(Hayvan hayvan) {
        List<Hayvan> hayvanList = hayvanDosyaOku();
        hayvanList.add(hayvan);
        hayvanDosyaYaz(hayvanList);

    }

    
    
    public void hayvanDosyaYaz(List<Hayvan> hayvanList) {
        FileWriter hayvanlarDosyasi = null;
        
        try {
            hayvanlarDosyasi = new FileWriter(hayvanDosyaYolu);

            for (Hayvan hayvan : hayvanList) {
                ArrayList<String> hayvanListesi = hayvan.hayvanListesi();
                for (String string : hayvanListesi) {
                    hayvanlarDosyasi.write(string + "-/-");

                }
                System.out.print("\n");

                //hayvanlarDosyasi.write(hayvan.getHayvanNo() + "-/-" + hayvan.getIrki() + "-/-" + hayvan.getIsmi() + "-/-" + hayvan.getDogumTarihi() + "-/-" + hayvan.getGelisTarihi() + "-/-" + hayvan.getCinsiyeti() + "\n");
            }
            hayvanlarDosyasi.close();
            System.out.println("Dosya yazılıyor....");
            System.out.println("Yeni Hayvan Eklendi ");
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public List<Hayvan> hayvanDosyaOku() {
        List<Hayvan> hayvanList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(hayvanDosyaYolu));
            scanner.useDelimiter("-/-");
            while (scanner.hasNextLine()) {
                Hayvan tmp = new Hayvan();
                scanner.skip(scanner.delimiter());
                tmp.setId(scanner.nextInt());

                scanner.skip(scanner.delimiter());
                tmp.setIrki(scanner.next());

                scanner.skip(scanner.delimiter());
                tmp.setIsmi(scanner.next());

                scanner.skip(scanner.delimiter());
                tmp.setDogumTarihi(scanner.next());

                scanner.skip(scanner.delimiter());
                tmp.setGelisTarihi(scanner.next());

                scanner.skip(scanner.delimiter());
                tmp.setCinsiyeti(scanner.nextLine());
                hayvanList.add(tmp);
                System.out.println("dosya okunuyor....");

            }
        } catch (Exception e) {
        }

        return hayvanList;

    }

}
