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
public interface hayvanHuylari {

    default String yirticiMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String sosyalMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

    default String ofkeliMi(int a) {
        return a == 1 ? "Evet" : "Hayir";
    }

}
