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
public class Caballo extends Pieza{

    public Caballo(String color) {
        super(color,"C");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido =false;
        
        if((Math.abs(mov.saltoHorizontal())==2 && Math.abs(mov.saltoVertical())==1)||(Math.abs(mov.saltoVertical())==2 && Math.abs(mov.saltoHorizontal())==1)){
        
        valido=true;
        }
        return valido;
    }
    
}
