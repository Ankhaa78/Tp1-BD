/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 * Gère les 3 couleurs d'un pixel de type P3
 * red Valeur du pixel Rouge
 * green Valeur du pixel Vert
 * blue Valeur du pixel Bleu
 * @author razan
 */
public class P3 implements Pixel {
    private int red;
    private int green;
    private int blue;
    
     /**
     * Constructeur sans paramètre
     */
    public P3() {
    }
    
    /**
     * Constructeur avec paramètre
     * @param red Valeur du pixel Rouge
     * @param green Valeur du pixel Vert
     * @param blue Valeur du pixel Bleu
     */
    public P3(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Set la valeur Rouge
     * @param red Valeur pour le Rouge
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * Set la valeur Vert
     * @param green Valeur pour le Vert
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * Set la valeur Bleu
     * @param blue Valeur pour le Bleu
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * Obtenir la valeur rouge
     * @return Retourne la teinte de rouge
     */
    public int getRed() {
        return red;
    }

    /**
     * Obtenir la valeur vert
     * @return Retourne la teinte de vert
     */
    public int getGreen() {
        return green;
    }

    /**
     * Obtenir la valeur bleu
     * @return Retourne la teinte de bleu
     */
    public int getBlue() {
        return blue;
    }

    @Override
    public Pixel eclaircir_noircir_pixel(int valeur, int resol) {
        int r = Pixel.verifyPixel(red, valeur, resol);
        int g = Pixel.verifyPixel(green, valeur, resol);
        int b = Pixel.verifyPixel(blue, valeur, resol);
        return new P3(r, g, b);
    }
    
    @Override
    public Pixel fusion(Pixel p1){
        P3 pix = (P3)p1;
        int r = (this.getRed() + pix.getRed())/2;
        int g = (this.getGreen() + pix.getGreen())/2;
        int b = (this.getBlue() + pix. getBlue())/2;
        return new P3(r, g, b);
    }
    
    @Override
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3){
        P3 pix1 = (P3)p1; 
        P3 pix2 = (P3)p2; 
        P3 pix3 = (P3)p3; 
        
        int r = (this.getRed() + pix1.getRed() + pix2.getRed() + pix3.getRed())/4;
        int g = (this.getGreen() + pix1.getGreen() + pix2.getGreen() + pix3.getGreen())/4;
        int b = (this.getBlue() + pix1. getBlue() + pix2. getBlue() + pix3. getBlue())/4;
        
        return new P3(r, g, b);
    }

    /**
     * Gère l'affichage du pixel (Valeur de Rouge, Vert et Bleu)
     * @return Retourne une string contenant les valeurs du pixel
     */
    @Override
    public String toString(){
        return this.getRed() + " " + this.getGreen() +" "+ this.getBlue() + " ";
    }
}
