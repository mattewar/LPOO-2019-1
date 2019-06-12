/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.model;

/**
 *
 * @author Sistema
 */
public class TapeteCircular extends Tapete{
        
    public double getValor()
    {
        return super.getMaterial().getPreco() * tam1 * tam1 * Math.PI ;
    }
    
    public String getFormato()
    {
        return "Circular";
    }
    
}
