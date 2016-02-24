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
public abstract class Pieza {

    protected String color;
    protected String nombre;

    public Pieza(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    public Pieza(String color) {
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean validoMovimiento(Movimiento mov);

    
    
    
    public  String pintarPieza(){
        
        return nombre+color;
    
    
    
    }
}
  
    
    


