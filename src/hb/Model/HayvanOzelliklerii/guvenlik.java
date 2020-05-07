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
public class guvenlik implements Serializable{
    public String guvenlik(int a){
        if(a == 1){
            return "yuksek guvenlik gerektirir";
        }
        else {
            return "normal guvenlik gerektirir";
        }
    }
}
