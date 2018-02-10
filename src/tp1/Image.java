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

    public Image(int dimX, int dimY, int resol, Pixel[][] _matrice) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.resol = resol;
        this._matrice = _matrice;
    }

    public Image() {
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public void setResol(int resol) {
        this.resol = resol;
    }

    public void setMatrice(Pixel[][] _matrice) {
        this._matrice = _matrice;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public int getResol() {
        return resol;
    }

    public Pixel[][] getMatrice() {
        return _matrice;
    }
}
