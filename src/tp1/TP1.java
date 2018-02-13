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
        
        //Tests P2
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
        Image im4 = t.eclaircir_noircir(im, -5);
        Image im5 = t.eclaircir_noircir(im, 12);
        Image im6 = new Image();
        t.copy(im, im6);
        Image im7 = t.extract(im, 0, 0, 3, 3);
        
        System.out.println("Matrice originale");
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                System.out.printf("%-3s", im.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Pivoter
        System.out.println("Matrice pivotée");
        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                System.out.printf("%-3s", im2.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Réduire
        System.out.println("Matrice reduite");
        for(int i=0;i< im3.getDimY();i++){
            for(int j=0;j<im3.getDimX();j++){
                System.out.printf("%-3s", im3.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Éclaircir
        System.out.println("Matrice Éclaircie");
        for(int i=0;i<im4.getDimY();i++){
            for(int j=0;j<im4.getDimX();j++){
                System.out.printf("%-3s", im4.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Noircir
        System.out.println("Matrice Noircie");
        for(int i=0;i<im5.getDimY();i++){
            for(int j=0;j<im5.getDimX();j++){
                System.out.printf("%-3s", im5.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Comparer
        System.out.println("Matrice Comparées");
        if(!(t.compare(im, im2)))
            System.out.println("Matrices im et im2 Pas Pareilles");
        
        //Copier et Comparer
        if(t.compare(im, im6))
            System.out.println("Matrices im et im6 Pareilles");
        
        //Extraire
        System.out.println("Matrice Extraite");
        for(int i=0;i<im7.getDimY();i++){
            for(int j=0;j<im7.getDimX();j++){
                System.out.printf("%-3s", im7.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
       
        System.out.println();
        //Tests P3
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
        im4 = t.eclaircir_noircir(im, -5);
        im5 = t.eclaircir_noircir(im, 12);
        t.copy(im, im6);
        im7 = t.extract(im, 0, 0, 3, 3);
        
        System.out.println("Matrice originale");
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                System.out.printf("%-12s", im.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Pivoter
        System.out.println("Matrice pivotée");
        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                System.out.printf("%-12s", im2.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Réduire
        System.out.println("Matrice reduite");
        for(int i=0;i<im3.getDimY();i++){
            for(int j=0;j<im3.getDimX();j++){
                System.out.printf("%-12s", im3.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Éclaircir
        System.out.println("Matrice Éclaircie");
        for(int i=0;i<im4.getDimY();i++){
            for(int j=0;j<im4.getDimX();j++){
                System.out.printf("%-12s", im4.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Noircir
        System.out.println("Matrice Noircie");
        for(int i=0;i<im5.getDimY();i++){
            for(int j=0;j<im5.getDimX();j++){
                System.out.printf("%-12s", im5.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        
        //Comparer
        System.out.println("Matrice Comparées");
        if(!(t.compare(im, im2)))
            System.out.println("Matrices im et im2 Pas Pareilles");
        
        //Copier et Comparer
        if(t.compare(im, im6))
            System.out.println("Matrices im et im6 Pareilles");
        
        //Extraire
        System.out.println("Matrice Extraite");
        for(int i=0;i<im7.getDimY();i++){
            for(int j=0;j<im7.getDimX();j++){
                System.out.printf("%-12s", im7.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
    }
    
}
