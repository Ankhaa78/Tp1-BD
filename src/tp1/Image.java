/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 * Gère une matrice de Pixel
 * dimX Dimensions de la matrice en X
 * dimY Dimensions de la matrice en Y
 * resol Résolution des pixels de la matrice
 * _matrice Matrice de Pixel
 * @author mndus
 */
public class Image {
    private int dimX;
    private int dimY;
    private int resol;
    private Pixel [][] _matrice;

    /**
     * Constructeur sans paramètres
    */
    public Image() {
    }
    
    /**
     * Constructeur avec paramètres
     * @param dimX Dimension en X
     * @param dimY Dimension en Y
     * @param resol Résolution de l'image
     * @param _matrice Matrice de pixel
     */
    public Image(int dimX, int dimY, int resol, Pixel[][] _matrice) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.resol = resol;
        this._matrice = _matrice;
    }

    /**
     * Set la valeur de la dimension en X
     * @param dimX Valeur de la dimension en X
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    /**
     * Set la valeur de la dimension en Y
     * @param dimY Valeur de la dimension en Y
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    /**
     * Set la valeur de la résolution de l'image
     * @param resol Valeur de la résolution de l'image
     */
    public void setResol(int resol) {
        this.resol = resol;
    }

    /**
     * Set la matrice de pixel
     * @param _matrice Une Matrice de Pixel
     */
    public void setMatrice(Pixel[][] _matrice) {
        this._matrice = _matrice;
    }

    /**
     * Obtenir la dimension en X
     * @return Retourne la dimension  en X
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * Obtenir la dimension en Y
     * @return Retourne la dimension  en Y
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * Obtenir la résolution de l'image
     * @return Retourne la résolution de l'image
     */
    public int getResol() {
        return resol;
    }

    /**
     * Obtenir la matrice de pixels
     * @return Retourne la matrice de pixels
     */
    public Pixel[][] getMatrice() {
        return _matrice;
    }
}
