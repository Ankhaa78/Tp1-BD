package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel_
 */
public class Traiteur {
    
    public void copy(Image i1, Image i2){
        
    }
    
    public Matrice extract(Image i, int p1, int c1, int p2, int c2){
        
        return null;
    }
    
    public Image reduce(Image i){
        
        return null;
    }
    
    public void compare(Image i1, Image i2){
        
        
    }
    
    public void rotate(Image i){
        int max = i.getDimX() - 1;
        Pixel [][] temp = new Pixel[i.getDimY()][i.getDimX()];
        
        for (int j = 0; j < i.getDimX();j++){
            for (int k = 0; k < i.getDimY(); k++){
                temp[j][k] = i.getMatrice()[k][ max - j];
            }
        }
        i.setMatrice(temp);
             
    }
}
