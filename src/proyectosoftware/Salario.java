
package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class Salario {

    public Salario() {
    }
    
  
    public float calcularSalario(String codigo1, String codigo2) throws SQLException
    {
       
    
        Comision a= new Comision();
        Descuento b = new Descuento(0.0945,0.04);
        float salarioFinal= 500+a.calcularComision(codigo1) - b.calcularDescuento(codigo2);
        System.out.println(a.calcularComision(codigo1));
        System.out.println(b.calcularDescuento(codigo2));
        System.out.println(salarioFinal);
        return salarioFinal;
        
        
    }
    public void ingresarCodigos(String CI,String codDescuento,String codComisiones)
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            // TODO add your handling code here:

            con = conexion.conector();
            String query =("SELECT slr_codigo FROM Empleado WHERE emp_cedula= '"+CI.trim()+"'");
           
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            JOptionPane.showMessageDialog(null, "a");
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "b");
                String ab=rs.getString("slr_codigo");
                PreparedStatement stmtP = null;
                 query =("INSERT INTO Salario (slr_codigo, desc_codigo,com_codigo) VALUES (?, ?, ?)");
            
                stmtP = con.prepareStatement(query);
                stmtP.setString(1, ab);
                stmtP.setString(2, codDescuento);
                stmtP.setString(3, codComisiones);       
               
                 stmtP.executeUpdate();
                 
                 JOptionPane.showMessageDialog(null, "Usuario Ingresado Correctamente" );
     

            }

           
        } catch (IOException | SQLException ex) {
        }
    }
}
