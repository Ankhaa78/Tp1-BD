/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author razan
 */
public class VerifyPixel {
    public static int verifyEclaircir (int base, int valeur) {
        if ((base - valeur) <= 0) {
            return 0;
        } else {
            return base -= valeur;
        }
    }
    
    public static int verifyNoircir (int base, int valeur) {
        if ((base + valeur) >= 255) {
            return 255;
        } else {
            return base += valeur;
        }
    }
}
