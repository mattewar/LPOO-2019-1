/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.fbdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lpoo1.model.Tapete;
import lpoo1.model.TapeteCircular;

/**
 *
 * @author La Fruteria
 */
public class PedidoItemSql {
    
    public static void insert(int numero_pedido, Tapete tapete)
    {
        int key;
        Conexao conn = new Conexao();
        String stm="";
        
        try {
            switch (tapete.getFormato()){
            case "Circular":
                stm = "insert into pedido_item (id, numero_pedido, idMaterial, valor, tam1) ";
                stm += "values (?, ?, ?, ?, ?)";
                break;
            case "Retangular":
                stm = "insert into pedido_item (id, numero_pedido, idMaterial, valor, tam1, tam2) ";
                stm += "values (?, ?, ?, ?, ?, ?)";
                break;
            case "Triangular":
                stm = "insert into pedido_item (id, numero_pedido, idMaterial, valor, tam1, tam2, tam3) ";
                stm += "values (?, ?, ?, ?, ?, ?, ?)";
                break;
            }
            PreparedStatement statement = conn.con.prepareStatement(stm, PreparedStatement.RETURN_GENERATED_KEYS);
            
            switch (tapete.getFormato()){
            case "Circular":
                statement.setInt(1, 0);
                statement.setInt(2, numero_pedido);
                statement.setInt(3, tapete.getMaterial().getId());
                statement.setDouble(4, tapete.getValor());
                statement.setDouble(5,tapete.tam1);
                
                break;
            case "Retangular":
                statement.setInt(1, 0);
                statement.setInt(2, numero_pedido);
                statement.setInt(3, tapete.getMaterial().getId());
                statement.setDouble(4, tapete.getValor());
                statement.setDouble(5,tapete.tam1);
                statement.setDouble(6,tapete.tam2);
                break;
            case "Triangular":
                statement.setInt(1, 0);
                statement.setInt(2, numero_pedido);
                statement.setInt(3, tapete.getMaterial().getId());
                statement.setDouble(4, tapete.getValor());
                statement.setDouble(5,tapete.tam1);
                statement.setDouble(6,tapete.tam2);
                statement.setDouble(7,tapete.tam3);
                break;
            }

            
            statement.execute();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            statement.close();

        } catch (Exception ex) {
            //
        }
    }
    
    public static void insert(int numero_pedido, Tapete[] tapetes)
    {
        for (Tapete t : tapetes)
        {
            insert(numero_pedido, t);
        }
    }
    
    public static void update(Tapete tapete)
    {
        Conexao conn = new Conexao();

        String stm = "UPDATE pedido_item set ";
        stm += " IDMATERIAL = '" + tapete.getMaterial().getId() + "'";
        stm += ", VALOR = '" + tapete.getValor() + "'";
 
        switch (tapete.getFormato()){
            case "Circular":
                stm += ", TAM1 = " + tapete.tam1;
                break;
            case "Retangular":
                stm += ", TAM1 = " + tapete.tam1;
                stm += ", TAM2 = " + tapete.tam2;
                break;
            case "Triangular":
                stm += ", TAM1 = " + tapete.tam1;
                stm += ", TAM2 = " + tapete.tam2;
                stm += ", TAM3 = " + tapete.tam3;
                break;
            default:
                stm += " WHERE id = '" + tapete.id + "';";
            }
   
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (Exception ex) {
            //
        }
    }
    
    public static void update(Tapete[] tapetes){
        for (Tapete t : tapetes)
        {
            update(t);
        }
    }
    
    public static void delete(Tapete tapete)
    {
        Conexao conn = new Conexao();
        String stm = "DELETE FROM CLIENTE  ";
        stm += "WHERE id = '" + tapete.id + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (Exception ex) {
            //
        }
    }
    
    public static void delete(Tapete[] tapetes){
        for (Tapete t : tapetes)
        {
            delete( t);
        }
    }

}
