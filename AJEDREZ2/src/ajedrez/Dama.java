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
public class Dama extends Pieza{

    public Dama(String color) {
        super(color, "D");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean valido=false;
        
        if(mov.esHorizontal() == true || mov.esDiagonal() == true || mov.esVertical()==true){
            
            valido=true;
            
            
        }
        return valido;
    }
    
    
    
}
