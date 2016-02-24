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
public class Peon extends Pieza {

    public Peon(String color) {
        super(color, "P");
       
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido=false;
        if(mov.esVertical()==true && Math.abs(mov.saltoVertical())==1){
        
            valido=true;
        
        }
        return valido;
    }
    
}
