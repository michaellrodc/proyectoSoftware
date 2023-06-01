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
        pantallaInicioSesion a = new pantallaInicioSesion();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        
        Salario b= new Salario();
        //b.calcularSalario("COM-000-001","DESC-001-001");
        Descuento h = new Descuento(0.0,0.0);
        Comision j = new Comision();
        System.out.println(h.calcularDescuento("SLR-1716270849"));
        System.out.println(j.calcularComision("SLR-1716270849"));
        
    }
    
}
