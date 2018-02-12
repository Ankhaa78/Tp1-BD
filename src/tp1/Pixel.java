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
    void eclaircir(int valeur);
    void noircir(int valeur, int resol);
    public Pixel fusion(Pixel p1);
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3);
    

}
