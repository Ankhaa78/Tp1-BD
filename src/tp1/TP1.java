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
        // TODO code application logic here
        int maxX = 2;
        int maxY = 3;
        int [][] matrice1 = new int[maxY][maxX];
        int [][] matrice2 = new int [maxX][maxY];
        int max = maxX -1;
        int k = 1;
        
        for(int i =0; i < maxY; i++ ){
            for(int j = 0; j < maxX; j++){
                matrice1[i][j] = k;
                k++;
            }
        }
        System.out.println("Voici la premiere matrice: ");
        for(int i =0; i < maxY; i++ ){
            for(int j = 0; j < maxX; j++){
                System.out.print(matrice1[i][j] + " ");
            }
            System.out.println();
        }
            
        
        for(int i =0; i < maxX; i++ ){
            for(int j = 0; j < maxY; j++){
                matrice2[i][j] = matrice1[j][max - i];
            }
        }
        System.out.println("Apres rotation : ");
        for(int i =0; i < maxX; i++ ){
            for(int j = 0; j < maxY; j++){
                System.out.print(matrice2[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
