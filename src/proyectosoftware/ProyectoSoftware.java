/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosoftware;

import java.sql.SQLException;



/**
 *
 * @author micha
 */
public class ProyectoSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        pantallaInicioSesion a= new pantallaInicioSesion();
        a.setVisible(true);
        Descuento c = new Descuento(0,0);
        Comision h = new Comision();
        Salario s = new Salario();
        
        
  
    }
    
}
