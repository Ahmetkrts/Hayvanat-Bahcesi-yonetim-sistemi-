/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hb.Model.Bakici;

/**
 *
 * @author techn
 */
public interface bakiciNitelikleri {

    default String Memeli(int a) {
        return a == 1 ? "Memeli" : null;
    }

    default String Surungen(int a) {
        return a == 1 ? "Surungen" : null;
    }

    default String Kus(int a) {
        return a == 1 ? "Kus" : null;
    }

    default String Balik(int a) {
        return a == 1 ? "Balik" : null;
    }

}
