/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.model;

public abstract class Tapete {

    public int id;
    
    private Material material;
    
    public double tam1, tam2, tam3;
    
    public abstract double getValor();
    public abstract String getFormato();
    
    public Material getMaterial() {
        return material;
    }


    public void setMaterial(Material material) {
        this.material = material;
    }
     
    
}
