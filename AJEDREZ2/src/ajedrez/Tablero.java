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
public class Tablero {

    public Pieza tabla[][] = new Pieza[8][8];

    public Pieza[][] getTabla() {
        return tabla;
    }

    public void setTabla(Pieza[][] tabla) {
        this.tabla = tabla;
    }

    public Tablero() {
        tabla[7][0] = new Torre("B");
        tabla[7][1] = new Caballo("B");
        tabla[7][2] = new Alfil("B");
        tabla[7][3] = new Dama("B");
        tabla[7][4] = new Rey("B");
        tabla[7][5] = new Alfil("B");
        tabla[7][6] = new Caballo("B");
        tabla[7][7] = new Torre("B");
        for (int i = 0; i < 8; i++) {

            tabla[6][i] = new Peon("B");

        }

        tabla[0][0] = new Torre("N");
        tabla[0][1] = new Caballo("N");
        tabla[0][2] = new Alfil("N");
        tabla[0][3] = new Rey("N");
        tabla[0][4] = new Dama("N");
        tabla[0][5] = new Alfil("N");
        tabla[0][6] = new Caballo("N");
        tabla[0][7] = new Torre("N");
        for (int i = 0; i < 8; i++) {

            tabla[1][i] = new Peon("N");

        }

    }

    public boolean hayPieza(int fila, int columna) {

        boolean hayp = false;
        if (tabla[fila][columna] != null) {

            hayp = true;
        }
        return hayp;
    }

    public boolean hayPieza(Posicion pos) {

        boolean hayp = false;
        if (tabla[pos.getFila()][pos.getColumna()] != null) {

            hayp = true;
        }
        return hayp;
    }

    public boolean hayPiezasEntre(Movimiento mov) {
        boolean hayp = false;
        if (mov.esVertical() == true && mov.saltoVertical() > 0) {

            for (int i = mov.getPosInicial().getColumna(); i >= mov.getPosFinal().getColumna(); i--) {

                if (tabla[i][mov.getPosInicial().getFila()] != null) {
                    hayp = true;
                }
            }
        }
        if (mov.esVertical() == true && mov.saltoVertical() < 0) {

            for (int i = mov.getPosInicial().getFila(); i <= mov.getPosFinal().getFila(); i++) {
                if (tabla[i][mov.getPosInicial().getColumna()] != null) {
                    hayp = true;
                }
            }
        }
        if (mov.esHorizontal() && mov.saltoHorizontal() > 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i--) {

                if (tabla[mov.getPosInicial().getColumna()][i] != null) {

                    hayp = true;
                }
            }

        }
        if (mov.esHorizontal() && mov.saltoHorizontal() < 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i++) {

                if (tabla[mov.getPosInicial().getColumna()][i] != null) {

                    hayp = true;
                }
            }
        }

        if (mov.esDiagonal() && mov.saltoHorizontal() > 0 && mov.saltoVertical() > 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i--) {
                int u=mov.getPosInicial().getColumna();
                
                if(tabla[i][u]!=null){
                    hayp=true;
                    
                
                
                u--;
                }
                

            }

        }
         if (mov.esDiagonal() && mov.saltoHorizontal() > 0 && mov.saltoVertical() < 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i--) {
                int u=mov.getPosInicial().getColumna();
                
                if(tabla[i][u]!=null){
                    hayp=true;
                    
                
                
                u++;
                }
                

            }

        }
          if (mov.esDiagonal() && mov.saltoHorizontal() < 0 && mov.saltoVertical() < 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i++) {
                int u=mov.getPosInicial().getColumna();
                
                if(tabla[i][u]!=null){
                    hayp=true;
                    
                
                
                u++;
                }
                

            }

        }
         
           if (mov.esDiagonal() && mov.saltoHorizontal() < 0 && mov.saltoVertical() > 0) {

            for (int i = mov.getPosInicial().getFila(); i > mov.getPosFinal().getFila(); i++) {
                int u=mov.getPosInicial().getColumna();
                
                if(tabla[i][u]!=null){
                    hayp=true;
                    
                
                
                u--;
                }
                

            }

        }

        return hayp;
    }

    public void moverPieza(Movimiento mov) {
        tabla[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] = tabla[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()];
        tabla[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()] = null;
    }

    public void pintarTablero() {
        System.out.println("     AA BB CC DD EE FF GG HH");
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print("0" + (i + 1) + "   ");

            for (int u = 0; u < 8; u++) {
                if (tabla[i][u] != null) {

                    System.out.print((tabla[i][u]).pintarPieza());
                    System.out.print(" ");
                } else {
                    System.out.print("00");
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }

    }

    public Movimiento jugada(String jugada, Pieza tabla[][], Tablero juego1) {

        Movimiento mov = null;

        Posicion inicial = new Posicion((jugada.charAt(2) - 49), (jugada.charAt(1) - 65));
        Posicion finale = new Posicion((jugada.charAt(4) - 49), (jugada.charAt(3) - 65));

        if (juego1.hayPieza(inicial) && !(tabla[inicial.getFila()][inicial.getColumna()]).getColor().equals((tabla[finale.getFila()][finale.getColumna()]).getColor())) {
            mov = new Movimiento(inicial, finale);
            if ((tabla[inicial.getFila()][inicial.getColumna()]).validoMovimiento(mov) == false) {
                mov = null;

            }

        }

        return mov;
    }

}
