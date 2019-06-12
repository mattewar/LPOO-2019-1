/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.fbdb;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Sistema
 */
public class MaterialSql {

    public static void update(int id, double preco)
    {
        Conexao conn = new Conexao();
        String stm = "UPDATE material set ";
        stm += " preco = '" + preco + "'";
        stm += " WHERE id = '" + id + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
