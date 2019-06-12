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
public class TapeteRetangular  extends Tapete{
    
    public double getValor()
    {
        return super.getMaterial().getPreco() * tam1 * tam2 ;
    }
    
    public String getFormato()
    {
        return "Retangular";
    }
}
