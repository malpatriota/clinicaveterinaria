/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author INTECAP
 */
public class Conexion {
    
    protected static Connection cnn; // es el objeto que conecta, = la conexión
    protected static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(
                    "jdbc:mysql://169.254.43.21:3306/veterninaria",
                    "root",
                    ""); // contraseña en usuario root siempre es vacia
        } catch (Exception e) {
            e.printStackTrace(System.err); // imprime error en caso que no suceda, o falla
        }
        
    }
    protected static void desconectar(){
        try { //trycatch+ TAB
             cnn.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
       
        
    }
}
