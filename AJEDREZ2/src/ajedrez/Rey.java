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
public class Rey extends Pieza {

    public Rey(String color) {
        super(color,"R");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if( mov.saltoHorizontal()<=1 && mov.saltoVertical()<=1&& mov.saltoHorizontal()>=-1 && mov.saltoVertical()>=-1){
          
            valido=true;
            
            
        }
        return valido;
    }
    
    
    
}
