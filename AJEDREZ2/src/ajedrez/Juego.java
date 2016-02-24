/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Juego {

    private boolean turno = true;

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public Movimiento jugada(String jugada) {

        Posicion inicial = new Posicion((jugada.charAt(1) - 49), (jugada.charAt(0) - 65));
        Posicion finale = new Posicion((jugada.charAt(3) - 49), (jugada.charAt(2) - 65));

        Movimiento mov = new Movimiento(inicial, finale);

        return mov;
    }

    public Movimiento movimientojuego(Movimiento mov, Tablero table) {

        if (!table.hayPieza(mov.getPosInicial())) {

            mov = null;
        } else if ((turno == true && !(table.getTabla()[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()]).getColor().equals("B")) || (turno == false && !(table.getTabla()[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()]).getColor().equals("N"))) {
            mov = null;

        } else if (!(table.getTabla()[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()]).validoMovimiento(mov)) {

            mov = null;

        } else if (table.hayPiezasEntre(mov)) {

            mov = null;
        }

        if (mov != null) {

            if (table.hayPieza(mov.getPosFinal())) {
                if (turno == true && (table.getTabla()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()]).getColor().equals("B")) {
                    mov = null;

                } else if (turno == false && (table.getTabla()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()]).getColor().equals("N")) {
                    mov = null;
                }
            }
        }

        return mov;
    }

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Juego juego1 = new Juego();
        Tablero table = new Tablero();
        table.pintarTablero();
        System.out.println("Introduce jugada");
        String jugada = lector.nextLine();
        if (juego1.movimientojuego(juego1.jugada(jugada), table) == null) {
            System.out.println("Jugada no valida,Introduce jugada");
            jugada = lector.nextLine();
        }
        table.moverPieza(juego1.movimientojuego(juego1.jugada(jugada), table));
        table.pintarTablero();

    }

}
