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
        
        Salario b= new Salario();
        Comision c = new Comision();
        //b.calcularSalario("COM-000-001","DESC-001-001");
        //System.out.println(c.calcularComision("SLR-1716270849"));
        System.out.println(Empleado.getEmpleado("1716270849").getSalarioNeto());
        
  
    }
    
}
