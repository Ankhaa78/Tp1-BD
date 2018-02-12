package tp1;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel_
 */
public class Lecteur {
     
    /**
     *
     * @param i - une image
     * @param f - un fichier
     */
    public void read(Image i, File f){
        
        //Doit connaitre le type de pixel
        Pixel [][] temp;
        Scanner sc = new Scanner (f.getPath());
        String pixelType;

        pixelType = sc.nextLine();
        i.setDimX(sc.nextInt());
        i.setDimY(sc.nextInt());
        i.setResol(sc.nextInt());
        
        if (pixelType == "P3"){
            temp = new P3 [i.getDimX()][i.getDimY()];
            for (int x = 0; x < i.getDimX(); x++){
                for (int y = 0; y < i.getDimY(); y++) {
                    temp[x][y] = new P3(sc.nextInt(),sc.nextInt(),sc.nextInt());                    
                }            
            }     
        }      
        else if (pixelType == "P2"){
            temp = new P2 [i.getDimX()][i.getDimY()]; 
            for (int x = 0; x < i.getDimX(); x++){
                for (int y = 0; y < i.getDimY(); y++) {
                    temp[x][y] = new P2(sc.nextInt());                    
                }            
            }
        }
        sc.close();
    }
    
    /**
     *
     * @param f - un fichier
     * @param i - une image
     * @throws IOException
     */
    public void write(File f, Image i) throws IOException{
        
        String txt; 
        //Doit verifier quel type de pixel 
        //Si P2
            txt = P2toString(i);
        //Si P3
            // txt = P2toString(i);       
        FileWriter fw = new FileWriter(f.getAbsolutePath()) ;
        
        BreakIterator boundary = BreakIterator.getLineInstance();        
        boundary.setText(txt);             
        int start = boundary.first();
        int end = boundary.next();  
        int lineLenght = 0; //Longueur de la ligne
        int maxLenght = 70; //Longueur maximum  des lignes        
        
        String x = Integer.toString(i.getDimX());
        String y = Integer.toString(i.getDimY());
        String r = Integer.toString(i.getResol());
       // fw.write(i.getPixelType);
        //fw.write("\r\n");
        fw.write(x);
        fw.write(" ");
        fw.write(y);
        fw.write ("\r\n");
        fw.write(r);    
        fw.write("\r\n");
        System.out.printf("%-3s",i.getDimX(),toString());
        System.out.println();
        System.out.printf("%-3s",i.getDimY(),toString());
        System.out.println();
        System.out.printf("%-3s",i.getResol(),toString());           
        System.out.println();


        while (BreakIterator.DONE != end){
            String word = txt.substring(start,end);           
            if ((lineLenght + word.length()) > maxLenght){
                
               fw.write("\r\n");
               System.out.println();
               
               lineLenght = word.length();
            }    
            System.out.printf(word);
           fw.write(word);
           
            lineLenght+= word.length();
            start = end;
            end = boundary.next();
        }
        fw.close(); 
    }
    
    /**
     *
     * @param i - une image
     * @return
     */
    public String P2toString(Image i){
        
        String str = "";
        Pixel matrix [][] = i.getMatrice();
        
        for (int k = 0; k<i.getDimX();k++){
            for (int j = 0; j<i.getDimY();j++){
                str += String.valueOf(matrix[k][j]);
            }
        }
        return str;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public String P3toString(Image i){        
        String str = "";
        Pixel matrix [][] = i.getMatrice();
        
        for (int k = 0; k<i.getDimX()*3;k++){
            for (int j = 0; j<i.getDimY();j++){
                str += String.valueOf(matrix[k][j]);
            }
        }
        return str;
    }
    
    /**
     *
     * @param arg
     * @throws IOException
     */
    public static void main (String arg[]) throws IOException{
        int dimX = 20;
        int dimY = 20;
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
        
        System.out.println("Matrice originale");
        for(int i=0;i<dimY;i++){
            for(int j=0;j<dimX;j++){
                System.out.printf("%-3s", im.getMatrice()[i][j].toString());               
            }
            System.out.println();
        }
        Lecteur w = new Lecteur();
        String test = w.P2toString(im);
        System.out.printf(test);
        System.out.println();
        
        File fichier;
        fichier = new File ("test.txt");
        w.write(fichier, im);      
        
    }
}
