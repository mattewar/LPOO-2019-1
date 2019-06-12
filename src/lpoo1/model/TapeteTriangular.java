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
public class TapeteTriangular extends Tapete {
    
    public double getValor()
    {
        double p = (tam1 + tam2 + tam3)/2;
        return super.getMaterial().getPreco() * Math.sqrt(p * (p-tam1) * (p-tam2) * (p-tam3))    ;
    }
    
    public String getFormato()
    {
        return "Triangular";
    }
}
