/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Scanner;
/**
 * Gère la lecture et l'écriture de fichier en chargant  et sauvegardant
 * les données des images.
 * @author joel_
 */
public class Lecteur {        
    /**
     * Ouvre un fichier spécifié en paramètre puis
     * charge les données dans l'image.
     * @param img Une image
     * @param f Un fichier 
     * (Precondition : Avoir un fichier existant)
     */
    public void read(Image img, File f){               
        try(Scanner sc = new Scanner(f)){           
            String pixelType;           
            
            //Extrait les information sur l'image
            pixelType = sc.nextLine();
            img.setDimX(sc.nextInt());
            img.setDimY(sc.nextInt());
            img.setResol(sc.nextInt()); 
            
            Pixel [][]temp = new Pixel[img.getDimY()][img.getDimX()];

            //Extrait chaque pixel de l'image selon son type
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
        catch(IOException e){
            System.out.println("Fichier introuvable");
        }
    }
    /**
     * Extrait les informations sur les pixels 
     * d'une image, puis les retranscrit dans 
     * le fichier envoyé en paramètre.
     * @param f Un fichier
     * @param img Une image
     * (Precondition : Avoir fichier existant)
     */
    public void write(File f, Image img){     
        String txt = img.toString();    
        String pixelType;
        
        //Trouve le format
        pixelType = img.getMatrice()[0][0].getClass().getName();
        pixelType = pixelType.substring(pixelType.lastIndexOf(".")+1);

        try(FileWriter fw = new FileWriter(f.getAbsolutePath())){         
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
            
            //Écrit les données  de chaque pixel dans l'image
            while (BreakIterator.DONE != end){
                String word;
                word = txt.substring(start,end);
                //Change de ligne si on atteint ou dépasse 
                //le nombre caractère maximum
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
        catch(IOException e){
            System.out.println("Écriture du fichier impossible");
        }        
    }
}
