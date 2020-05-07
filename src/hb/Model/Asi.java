/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Casper
 */
public class Asi implements Serializable{

    private int id;
    private final int seri;
    private ArrayList<String> asiIsmi;

    public Asi() {
        seri = id;
        id++;
        this.asiIsmi = new ArrayList<>();

    }

    public Asi(String asiIsmi) {
        seri = id;
        id++;
        this.asiIsmi = new ArrayList<>();
        this.asiIsmi.add(asiIsmi);
    }

    public void AsiEkle(String asiIsmi) {
        this.asiIsmi.add(asiIsmi);
    }

    public void AsiEkle(ArrayList<String> asiIsmi) {
        for (String s : asiIsmi) {
            this.asiIsmi.add(s);
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

   

    public ArrayList<String> getAsiIsmi() {
        return asiIsmi;
    }

    public void setAsiIsmi(ArrayList<String> asiIsmi) {
        this.asiIsmi = asiIsmi;
    }

}
