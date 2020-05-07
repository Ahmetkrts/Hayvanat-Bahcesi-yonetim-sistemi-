/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.HayvanOzelliklerii;

import java.io.Serializable;

/**
 *
 * @author techn
 */
public class ozellikler implements Serializable {

    public String ucaBilirMi(int a) {
        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    public String aquaDisindaYasarMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    public String killiMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    public String zehirliMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

    public String boyuBesMetredenBuyukMu(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

}
