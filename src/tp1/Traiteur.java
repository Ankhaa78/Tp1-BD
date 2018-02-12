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
        int x,y;
        
        //déterminer la nouvelle dimension en x
        if(i.getDimX() % 2 == 1){
            x = i.getDimX()/2 +1;
        }
        else{
            x = i.getDimX()/2;
        }
        
        //déterminer la nouvelle dimension en y
        if(i.getDimY() % 2 == 1){
            y = i.getDimY()/2 +1;
        }
        else{
            y = i.getDimY()/2;
        }
        
        //creer la nouvelle matrice
        Pixel [][] temp = new Pixel[y][x];
        
        for(int j = 0; j < y; j++){
            for(int k = 0; k < x; k++){
                
                if (2*j == i.getDimY() -1 && 2*k == i.getDimX() -1){
                    if(i.getDimY() % 2 == 1 && i.getDimX() % 2 == 1){
                        temp[j][k] = i.getMatrice()[2*j][2*k];
                    }
                }
                else if (2*j == i.getDimY()-1){
                    if (i.getDimY() % 2 == 1){
                       temp [j][k] =  i.getMatrice()[2*j][2*k].fusion(i.getMatrice()[2*j][2*k +1]);
                    }
                }
                else if (2*k == i.getDimX() -1){
                     if(i.getDimX() % 2 == 1){
                        temp [j][k] =  i.getMatrice()[2*j][2*k].fusion(i.getMatrice()[2*j + 1][2*k]);
                    }
                }
                else{
                     temp [j][k] =  i.getMatrice()[2*j][2*k].fusion(i.getMatrice()[2*j][2*k + 1],
                             i.getMatrice()[2*j+1][2*k], i.getMatrice()[2*j+1][2*k+1]);
                }    
            }
        }
        
        
        return new Image(x,y,i.getResol(),temp);
    }
    
    public void compare(Image i1, Image i2){
        
        
    }
    
    public Image rotate(Image i){
        int max = i.getDimX() - 1;
        Pixel [][] temp = new Pixel[i.getDimX()][i.getDimY()];
        
        for (int j = 0; j < i.getDimX();j++){
            for (int k = 0; k < i.getDimY(); k++){
                temp[j][k] = i.getMatrice()[k][ max - j];
            }
        }
        return new Image(i.getDimX(),i.getDimY(),i.getResol(),temp); 
    }
    
   
}
