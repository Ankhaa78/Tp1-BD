/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 * Gère les les teintes de gris d'un pixel de type P2
 * gray Valeur du pixel Gris
 * @author razan
 */
public class P2 implements Pixel {
     private int gray;

    /**
     * Constructeur sans paramètre
     */
    public P2() {
    }

    /**
     * Constructeur avec paramètre
     * @param gray Valeur du pixel Gris
     */
    public P2(int gray) {
        this.gray = gray;
    }

    /**
     * Set la valeur Gris
     * @param gray Valeur pour le Gris
     */
    public void setGray(int gray) {
        this.gray = gray;
    }

    /**
     * Obtenir la valeur Gris
     * @return Retourne la teinte de Gris
     */
    public int getGray() {
        return gray;
    }

    @Override
    public Pixel eclaircir_noircir_pixel(int valeur, int resol) {
        int g = Pixel.verifyPixel(gray, valeur, resol);
        return new P2(g);
    }
    
    @Override
    public Pixel fusion(Pixel p1){
        P2 pix = (P2)p1;
        return new P2((this.getGray() + pix.getGray())/2);
    }
    
    @Override
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3){
        P2 pix1 = (P2)p1; 
        P2 pix2 = (P2)p2; 
        P2 pix3 = (P2)p3; 
        
        return new P2((this.getGray() + pix1.getGray() + pix2.getGray() + pix3.getGray())/4);
    }
    
    /**
     * Gère l'affichage du pixel (Valeur de Gris)
     * @return Retourne une string contenant les valeurs du pixel
     */
    @Override
     public String toString(){
        return this.getGray() + " ";
    }
}
