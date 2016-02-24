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
public class Alfil extends Pieza {

    public Alfil(String color) {
        super(color,"A" );
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        
        boolean valido = false;
        if (mov.esDiagonal()==true){
        
            
        valido =true;
        }
        return valido;
    }

   
    
}
