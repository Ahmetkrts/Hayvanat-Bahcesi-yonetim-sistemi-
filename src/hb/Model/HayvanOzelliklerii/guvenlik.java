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
public interface guvenlik {

    default String guvenlik(int a) {
        return a == 1 ? "Yüksek Güvenlik Gerektirir" : "Normal Güvenlik Gerektirir";
    }
}
