/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.HayvanOzelliklerii;

/**
 *
 * @author techn
 */
public interface ozellikler {

    default String ucaBilirMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String aquaDisindaYasarMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String killiMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String zehirliMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String boyuBesMetredenBuyukMu(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

}
