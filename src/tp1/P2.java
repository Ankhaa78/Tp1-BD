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

    public P2() {
    }

    public P2(int gray) {
        this.gray = gray;
    }

    public void setGray(int gray) {
        this.gray = gray;
    }

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
    
     @Override
     public String toString(){
        return this.getGray() + " ";
    }
}
