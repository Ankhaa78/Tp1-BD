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
     private int gray;

    /**
     *  constructeur sans parametres
     */
    public P2() {
    }

    /**
     *
     * @param gray valeur de la teinte de gris
     */
    public P2(int gray) {
        this.gray = gray;
    }

    /**
     *
     * @param gray valeur de la teinte de gris
     */
    public void setGray(int gray) {
        this.gray = gray;
    }

    /**
     *
     * @return valeur de la teinte de gris
     */
    public int getGray() {
        return gray;
    }

    /**
     *
     * @param valeur de la modification a la couleur 
     */
    @Override
    public void eclaircir(int valeur) {
        gray = VerifyPixel.verifyEclaircir(gray, valeur);
    }

    /**
     *
     * @param 
     */
    @Override
    public void noircir(int valeur) {
        gray = VerifyPixel.verifyNoircir(gray, valeur);
    }

    /**
     *
     * @param p1
     * @return
     */
    @Override
    public Pixel fusion(Pixel p1){
        P2 pix = (P2)p1;
        return new P2((this.getGray() + pix.getGray())/2);
    }
    
    /**
     *
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    @Override
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3){
        P2 pix1 = (P2)p1; 
        P2 pix2 = (P2)p2; 
        P2 pix3 = (P2)p3; 
        
        return new P2((this.getGray() + pix1.getGray() + pix2.getGray() + pix3.getGray())/4);
    }
    
     public String toString(){
        return this.getGray() + " ";
    }
}
