/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danny
 */
public class Usuario {
    String ususario;
    String Ci_Usuario;
    String contraseña;
    String Lgn_Codigo;
    
    public Usuario(String Usuario,String Contraseña,String CI, String LGN_codigo)
    {
        this.ususario=Usuario;
        this.contraseña=Contraseña;
        this.Ci_Usuario=CI;
        this.Lgn_Codigo=LGN_codigo;
    }
    public void ingresarUsuario()
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // TODO add your handling code here:

            con = conexion.conector();
            String query =("INSERT INTO usuario (usuario, Ci_Usuario, contraseña, Lgn_Codigo) VALUES (?, ?, ?, ?)");
            
            stmt = con.prepareStatement(query);
            stmt.setString(1, ususario);
            stmt.setString(2, Ci_Usuario);
            stmt.setString(3, contraseña);
            stmt.setString(4, Lgn_Codigo);
               
            stmt.executeUpdate();
            query=("INSERT INTO Loggin (lgn_Cod) VALUES ?");
            stmt = con.prepareStatement(query);
            stmt.setString(1, Lgn_Codigo);
            
            JOptionPane.showMessageDialog(null, "Usuario Ingresado Correctamente" );
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        }
    }
}
