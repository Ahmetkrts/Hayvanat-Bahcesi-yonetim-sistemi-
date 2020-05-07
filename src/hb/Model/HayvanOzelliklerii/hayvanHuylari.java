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
public class hayvanHuylari implements Serializable {

    public String yirticiMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayir";
        }
    }

    public String sosyalMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayir";
        }
    }

    public String ofkeliMi(int a) {

        if (a == 1) {
            return "Evet";
        } else {
            return "Hayır";
        }
    }

}
