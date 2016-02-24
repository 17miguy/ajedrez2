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
public class Torre extends Pieza{

    public Torre(String color) {
        super(color,"T");
    }

    
    
    
    
    

    @Override
    public boolean validoMovimiento(Movimiento mov) {
       boolean valido =false;
       if(mov.esHorizontal()==true ||mov.esVertical()==true){
       valido =true;
       
       }
       return valido;
    }

    
  

 
   
    
   
    
    
}
