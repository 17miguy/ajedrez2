/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 *
 * @author dam1
 */
public class Movimiento {

    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento(Posicion posInicial, Posicion posFinal) {
         this.posInicial = posInicial;
        this.posFinal = posFinal;
        
    }

    public Posicion getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    public boolean esVertical() {
        boolean vertical = false;

        if (posInicial.getColumna() == posFinal.getColumna()) {

            vertical = true;

        }
        return vertical;

    }

    public boolean esHorizontal() {
        boolean horizontal = false;

        if (posInicial.getFila() == posFinal.getFila()) {

            horizontal = true;

        }
        return horizontal;

    }

    public boolean esDiagonal() {
        boolean diagonal = false;

        if (saltoHorizontal() == saltoVertical()) {

            diagonal = true;
        }
        return diagonal;

    }

    public int saltoHorizontal() {

        return posInicial.getColumna() - posFinal.getColumna();
    }

    public int saltoVertical() {
        return posInicial.getFila() - posFinal.getFila();

    }

}
