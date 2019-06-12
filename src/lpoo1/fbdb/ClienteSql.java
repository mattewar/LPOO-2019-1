/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.fbdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistema
 */
public class ClienteSql {
    public static void insert(String cpf, String nome, String sobrenome)
    {
        Conexao conn = new Conexao();
        String stm = "INSERT INTO CLIENTE (CPF, NOME, SOBRENOME) ";
        stm += "values('" + cpf;
        stm += "', '" + nome;
        stm += "','" + sobrenome + "');";
        try {
            conn.stm.clearBatch();
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(String cpf, String nome, String sobrenome)
    {
        Conexao conn = new Conexao();
        String stm = "UPDATE CLIENTE set ";
        stm += "CPF = '" + cpf + "'";
        stm += ", NOME = '" + nome + "'";
        stm += ", SOBRENOME = '" + sobrenome + "' ";
        stm += " WHERE CPF = '" + cpf + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(String cpf)
    {
        Conexao conn = new Conexao();
        String stm = "DELETE FROM CLIENTE  ";
        stm += "WHERE cpf = '" + cpf + "';";
        try {
            conn.stm.addBatch(stm);
            conn.stm.executeBatch();
            conn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
