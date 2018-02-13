/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 * Interface pixel permetant la gestion des pixels
 * @author razan
 */
public interface Pixel {

    /**
     * Éclaircis ou noircis un pixel 
     * @param valeur La valeur de modification à appliquer aux teintes ( Négatif = Noircir / Positif = Éclaircir )
     * @param resol La résolution maximale d'un pixel
     * @return Retourne le pixel modifié
     */
    Pixel eclaircir_noircir_pixel(int valeur, int resol);

    /**
     * Fait la moyenne entre 2 pixels pour réduire
     * @param p1 Pixel à fusionné #1
     * @return Retourne le pixel fusionné
     */
    public Pixel fusion(Pixel p1);

    /**
     * Fait la moyenne entre 4 pixels pour réduire
     * @param p1 Pixel à fusionné #1
     * @param p2 Pixel à fusionné #2
     * @param p3 Pixel à fusionné #3
     * @return Retourne le pixel fusionné
     */
    public Pixel fusion(Pixel p1, Pixel p2, Pixel p3);
    

    /**
     * Vérifie si le pixel descend sous 0 au dépasse la résolution et calcule sa nouvelle valeur (Sert à eclaircir_noircir_pixel)
     * @param base La valeur originale a vérifier
     * @param valeur La valeur de modification à appliquer
     * @param resol La résolution maximale du pixel
     * @return Retourne le pixel modifier
     */

    public static int verifyPixel (int base, int valeur, int resol) {
        if ((base + valeur) <= 0) {
            return 0;
        }
        else if ((base + valeur) >= resol) {
            return resol;
        } 
        else {
            return base += valeur;
        }
    }
}
