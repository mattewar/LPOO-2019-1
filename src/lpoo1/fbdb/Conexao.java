/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo1.fbdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conexao {
   public Connection con = null;
   public Statement stm = null;

   public Conexao() {

      try {

         Class.forName("org.firebirdsql.jdbc.FBDriver");
         con =
            DriverManager.getConnection(
               "jdbc:firebirdsql:localhost:C:\\Users\\La Fruteria\\Documents\\NetBeansProjects\\Lpoo1-2\\db\\LPOO1DB.fdb ",
               "sysdba",
               "masterkey");
         stm = con.createStatement();

      } catch (Exception e) {
         System.out.println("Não foi possível conectar ao banco: " + e.getMessage());
      }
   }
}
