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
public interface Pixel {
    Pixel eclaircir_noircir_pixel(int valeur, int resol);
    public Pixel fusion(Pixel p1);
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3);
    
   
    
    public static int verifyPixel (int base, int valeur, int resol) {
        if ((base + valeur) <= 0) {
            return 0;
        }
        else if ((base + valeur) >= resol) {
            return resol;
        } 
        else {
            return base += valeur;
        }
    }
}
