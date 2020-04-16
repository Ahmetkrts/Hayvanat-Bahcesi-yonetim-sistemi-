/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Hayvan;

import java.util.ArrayList;

/**
 *
 * @author Casper
 */
public class Ilac {

    private int id;
    private final int seri;
    private ArrayList<String> ilacIsmi;

    public Ilac() {
        seri = id;
        id++;
        this.ilacIsmi = new ArrayList<>();

    }

    public Ilac(String ilacIsmi) {
        seri = id;
        id++;
        this.ilacIsmi = new ArrayList<>();
        this.ilacIsmi.add(ilacIsmi);
    }

    public void AsiEkle(String ilacIsmi) {
        this.ilacIsmi.add(ilacIsmi);
    }

    public void AsiEkle(ArrayList<String> ilacIsmi) {
        for (String s : ilacIsmi) {
            this.ilacIsmi.add(s);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeri() {
        return seri;
    }

   

    public ArrayList<String> getIlacIsmi() {
        return ilacIsmi;
    }

    public void setIlacIsmi(ArrayList<String> ilacIsmi) {
        this.ilacIsmi = ilacIsmi;
    }

}
