package tp1;





import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
     * @param img - une image
     * @param f - un fichier
     * (Precondition :)
     * (Postcondition :)
     */
    public void read(Image img, File f){        
        
        try{
         Scanner sc = new Scanner(f);
         String pixelType;           

        pixelType = sc.nextLine();
        img.setDimX(sc.nextInt());
        img.setDimY(sc.nextInt());
        img.setResol(sc.nextInt()); 
        
        Pixel [][]temp = new Pixel[img.getDimY()][img.getDimX()];
        
        if ("P3".equals(pixelType)){
            temp = new P3 [img.getDimY()][img.getDimX()];
            for (int x = 0; x < img.getDimY(); x++){
                for (int y = 0; y < img.getDimX(); y++) {
                    temp[x][y] = new P3(sc.nextInt(),sc.nextInt(),sc.nextInt());                    
                }            
            }     
        }      
        else if ("P2".equals(pixelType)){
           temp = new P2 [img.getDimY()][img.getDimX()]; 
           for (int x = 0; x < img.getDimY(); x++){
                for (int y = 0; y < img.getDimX(); y++) {
                    temp[x][y] = new P2(sc.nextInt());                    
                }            
            }
        }
        
        img.setMatrice(temp);
        sc.close();
        }
        catch(IOException e)
        {
            System.out.println("Fichier introuvable");
        }
       
    }

    /**
     *
     * @param f - un fichier
     * @param img - une image
     * (Precondition :)
     * (Postcondition :)
     * 
     */
    public void write(File f, Image img){     
        String txt = null;    
        String pixelType;
        
        pixelType = img.getMatrice()[0][0].getClass().getName();
        pixelType = pixelType.substring(pixelType.lastIndexOf(".")+1);
        
        txt = img.toString(); 
        try{
            FileWriter fw = new FileWriter(f.getAbsolutePath()) ;
            BreakIterator boundary = BreakIterator.getLineInstance(); 

            boundary.setText(txt);             
            int start = boundary.first();
            int end = boundary.next();  
            int lineLenght = 0; //Longueur de la ligne
            int maxLenght = 70; //Longueur maximum  des lignes        

            String x = Integer.toString(img.getDimX());
            String y = Integer.toString(img.getDimY());
            String r = Integer.toString(img.getResol());

            fw.write(pixelType);
            fw.write ("\r\n");        
            fw.write(x);
            fw.write(" ");
            fw.write(y);
            fw.write ("\r\n");
            fw.write(r);    
            fw.write("\r\n");

            while (BreakIterator.DONE != end){
                String word;           
                word = txt.substring(start,end);

                if ((lineLenght + word.length()) > maxLenght){             
                   fw.write("\r\n");        
                   lineLenght = word.length();
                }

                fw.write(word);
                lineLenght+= word.length();
                start = end;
                end = boundary.next();
            }
            fw.close(); 
        }
        catch(IOException e)
        {
            System.out.println("Écriture du fichier impossible");
        }
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
  
        String test = im.toString();
        System.out.printf(test);
        
        System.out.println();
        
        File fichier;
        fichier = new File ("test.pgm");
        w.write(fichier, im);       

        
        Image im2 = new Image();      
        File fichier2 = new File("Sherbrooke_Frontenac_nuit.ppm");
 
        w.read(im2, fichier2);
        
        File fichier3 = new File ("test2.ppm");
        w.write(fichier3, im2);
    }
}
