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
public class beslenmeBicimi {
    
    public String et_yem_yemekBicimi(int a) {

        if (a == 1) {
            return "Et Ile Beslenir";
        } else {
            return "Yem Ile Beslenir";
        }
    }
    
    public String et_ot_yemekBicimi(int a) {

        if (a == 1) {
            return "Et Ile Beslenir";
        } else {
            return "Ot Ile Beslenir";
        }
    }
}
