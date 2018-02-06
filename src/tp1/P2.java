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
public class P2 implements Pixel {
    int gray;

    @Override
    public void eclaircir(int valeur) {
        gray = VerifyPixel.verifyEclaircir(gray, valeur);
    }

    @Override
    public void noircir(int valeur) {
       gray = VerifyPixel.verifyNoircir(gray, valeur);
    }
}
