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
public class Image {
    private int dimX;
    private int dimY;
    private int resol;
    private Pixel [][] _matrice;

    /**
     *
     * @param dimX la dimension en X (nombre de ligne)
     * @param dimY la dimension en Y (nombre de colonnes)
     * @param resol la résolution de l'image
     * @param _matrice tableau de pixel représentant l'image
     */
    public Image(int dimX, int dimY, int resol, Pixel[][] _matrice) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.resol = resol;
        this._matrice = _matrice;
    }

    /**
     *  constructeur sans parametres
     */
    public Image() {
    }

    /**
     *
     * @param dimX la dimension en X (nombre de ligne)
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    /**
     *
     * @param dimY la dimension en Y (nombre de colonnes)
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    /**
     *
     * @param resol la résolution de l'image
     */
    public void setResol(int resol) {
        this.resol = resol;
    }

    /**
     *
     * @param _matrice tableau de pixel représentant l'image
     */
    public void setMatrice(Pixel[][] _matrice) {
        this._matrice = _matrice;
    }

    /**
     *
     * @return la dimension en X (nombre de ligne)
     */
    public int getDimX() {
        return dimX;
    }

    /**
     *
     * @return la dimension en Y (nombre de colonnes)
     */
    public int getDimY() {
        return dimY;
    }

    /**
     *
     * @return la résolution de l'image
     */
    public int getResol() {
        return resol;
    }

    /**
     *
     * @return tableau de pixel représentant l'image
     */
    public Pixel[][] getMatrice() {
        return _matrice;
    }
}
