
package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCtest {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/farmacia";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement  = conexion.createStatement();
            rs = statement.executeQuery(" SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            
            // insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `contraseña`) VALUES (NULL, 'Nury', 'Gutierrez', '');");
            System.out.println("");
            rs = statement.executeQuery(" SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));   
            }
            
            //actualizacion de datos
             statement.execute("UPDATE `usuarios` SET `nombre` = 'AngelaP' WHERE `usuarios`.`id` = 6;");
            System.out.println("");
            rs = statement.executeQuery(" SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));   
            }
            
            //Eliminar datos
             statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 4");
            System.out.println("");
            rs = statement.executeQuery(" SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCtest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
