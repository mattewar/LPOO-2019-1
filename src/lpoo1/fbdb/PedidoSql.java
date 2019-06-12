/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.fbdb;

import com.sun.jndi.ldap.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lpoo1.model.Tapete;

/**
 *
 * @author Sistema
 */
public class PedidoSql {
    public static void insert(String cpf_cliente, double valor, Tapete[] tapetes)
    {
        int key;
        Conexao conn = new Conexao();
                
        String stm = "INSERT INTO pedido (numero, cpf, valor) ";
        stm += "values(?, ? , ?)";
        
        try {
            PreparedStatement statement = conn.con.prepareStatement(stm, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, 0);
            statement.setString(2, cpf_cliente);
            statement.setDouble(3, valor);
            
            statement.execute();
            
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
                PedidoItemSql.insert(key, tapetes);
            }
            
            statement.close();

        } catch (Exception ex) {
            //
        }
    }
    
    public static void update(int numero_pedido, int valor, Tapete[] tapetes)
    {
        Conexao conn = new Conexao();
        String stm = "UPDATE pedido set ";
        stm += " valor = '" + valor + "' ";
        stm += " WHERE numero = '" + numero_pedido + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (Exception ex) {
            //
        }
        PedidoItemSql.update(tapetes);
    }
    
    public static void delete(int numero_pedido, Tapete[] tapetes)
    {
        Conexao conn = new Conexao();
        String stm = "DELETE FROM pedido  ";
        stm += "WHERE numero = '" + numero_pedido + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (Exception ex) {
            //
        }
        PedidoItemSql.delete(tapetes);
    }

}
