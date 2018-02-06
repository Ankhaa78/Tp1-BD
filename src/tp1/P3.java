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
public class P3 implements Pixel {
    int red;
    int green;
    int blue;
    
    @Override
    public void eclaircir(int valeur) {
        red = VerifyPixel.verifyEclaircir(red, valeur);
        green = VerifyPixel.verifyEclaircir(green, valeur);
        blue = VerifyPixel.verifyEclaircir(blue, valeur);
    }

    @Override
    public void noircir(int valeur) {
        red = VerifyPixel.verifyNoircir(red, valeur);
        green = VerifyPixel.verifyNoircir(green, valeur);
        blue = VerifyPixel.verifyNoircir(blue, valeur);
    }
}
