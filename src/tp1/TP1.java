/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author mndus
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimX = 4;
        int dimY = 7;
        Pixel [][] m = new P2[dimY][dimX];
        Traiteur t = new Traiteur();
        int k =1;
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                m[i][j] = new P2(k);
                k++;
            }
        }
        
        Image im = new Image(dimX, dimY, 255, m);
        Image im2 = t.rotate(im);
        Image im3 = t.reduce(im);
        
        System.out.println("Matrice originale");
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                System.out.printf("%-3s", im.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        System.out.println("Matrice pivotée");
        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                System.out.printf("%-3s", im2.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        System.out.println("Matrice reduite");
        for(int i=0;i< im3.getDimY();i++){
            for(int j=0;j<im3.getDimX();j++){
                System.out.printf("%-3s", im3.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
       
        m = new P3[dimY][dimX];
        k=1;
         for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                m[i][j] = new P3(k,2*k,3*k);
                k++;
            }
        }
         
        im = new Image(dimX, dimY, 255, m);
        im2 = t.rotate(im);
        im3 = t.reduce(im); 
        
        System.out.println("Matrice originale");
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                System.out.printf("%-12s", im.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        System.out.println("Matrice pivotée");
        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                System.out.printf("%-12s", im2.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        System.out.println("Matrice reduite");
        for(int i=0;i<im3.getDimY();i++){
            for(int j=0;j<im3.getDimX();j++){
                System.out.printf("%-12s", im3.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
    }
    
}
