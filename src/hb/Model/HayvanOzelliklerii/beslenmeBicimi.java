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
public interface beslenmeBicimi {

    default String et_yem_yemekBicimi(int a) {
        return a == 1 ? "Et Ile Beslenir" : "Yem Ile Beslenir";
    }

    default String et_ot_yemekBicimi(int a) {
        return a == 1 ? "Et Ile Beslenir" : "Ot Ile Beslenir";
    }
}
