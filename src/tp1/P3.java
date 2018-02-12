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
    private int red;
    private int green;
    private int blue;
    
    public P3(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
    
    @Override
    public void eclaircir(int valeur) {
        red = VerifyPixel.verifyEclaircir(red, valeur);
        green = VerifyPixel.verifyEclaircir(green, valeur);
        blue = VerifyPixel.verifyEclaircir(blue, valeur);
    }

    @Override
    public void noircir(int valeur, int resol) {
        red = VerifyPixel.verifyNoircir(red, valeur, resol);
        green = VerifyPixel.verifyNoircir(green, valeur, resol);
        blue = VerifyPixel.verifyNoircir(blue, valeur, resol);
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
        
        return new P3(r, b, g);
    }

    public String toString(){
        return this.getRed() + " " + this.getGreen() +" "+ this.getBlue();
    }
}
