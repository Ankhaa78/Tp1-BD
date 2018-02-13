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
public class Traiteur{
    
    /**
     *
     * @param i1
     * @param i2
     */
    public void copy(Image i1, Image i2){
            i2.setMatrice(i1.getMatrice().clone());
            i2.setResol(i1.getResol());
            i2.setDimX(i1.getDimX());
            i2.setDimY(i1.getDimY());
    }
    
    /**
     *
     * @param i 
     * @param p1
     * @param c1
     * @param p2
     * @param c2
     * @return
     * 
     * Precondition = 
     */
    public Image extract(Image i, int p1, int c1, int p2, int c2){
        if(p1 < i.getDimX() && p2 < i.getDimX() && c1 < i.getDimY() && c2 < i.getDimY() && c1 < c2 && p1 < p2)
        {
            //On détermine les nouvelles 
            int newDimX = p2 - p1;
            int newDimY = c2 - c1;
            //On crée un tableau temporaire
            Pixel[][] temp = new Pixel[newDimX][newDimY];
            //On copie la partie d'image dans le tableau temporaire 
            for(int j = 0; j < newDimY; j++ )
                for(int k = 0; k < newDimX; k++)
                {
                    temp[j][k] = i.getMatrice()[j + p1][k + c1];
                }
            return new Image(newDimX, newDimY, i.getResol(), temp);
        }
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
    
    /**
     *
     * @param i1
     * @param i2
     * @return
     */
    public boolean compare(Image i1, Image i2){
        if(i1.getDimX() == i2.getDimX() && i1.getDimY() == i2.getDimY())
        {
            for(int i = 0; i < i1.getDimY(); i++)
                for(int j = 0; j < i1.getDimX(); j++)
                {
                    if(i1.getMatrice()[i][j] != i2.getMatrice()[i][j])
                    {
                        return false;
                    }
                }
            return true;
        }
        return false;
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
    
       public Image eclaircir_noircir(Image i, int valeur)
    {
        Pixel[][] temp = new Pixel[i.getDimY()][i.getDimX()];
        for (int j = 0; j < i.getDimX();j++){
            for (int k = 0; k < i.getDimY(); k++){
                temp[k][j] = i.getMatrice()[k][j].eclaircir_noircir_pixel(valeur, i.getResol());
            }
        }
        return new Image(i.getDimX(), i.getDimY(), i.getResol(), temp); 
    }
}
