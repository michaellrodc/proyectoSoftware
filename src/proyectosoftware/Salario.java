
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
        
        /*System.out.println(a.calcularComision(codigo1));
        System.out.println(b.calcularDescuento(codigo2));
        System.out.println(salarioFinal);*/
        return salarioFinal;
        
        
    }
    public void ingresarCodigos(String CI)
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        String codSalario="SLR-"+CI;
        String codDescuento="DESC-"+CI;
        String codComision="COM-"+CI;
        try {
            con = conexion.conector();
            String query =("SELECT * from Salario WHERE slr_codigo='"+codSalario+"' AND desc_codigo='"+codDescuento+"' AND com_codigo ='"+codComision+"';");
           
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            if(!rs.next())
            {
                PreparedStatement stmtP = null;
                 query =("INSERT INTO Salario (slr_codigo, desc_codigo,com_codigo) VALUES (?, ?, ?)");
            
                stmtP = con.prepareStatement(query);
                stmtP.setString(1, codSalario);
                stmtP.setString(2, codDescuento);
                stmtP.setString(3, codComision);       
               
                 stmtP.executeUpdate();
                 
            }
            stmt.close();
            con.close();
           

           
        } catch (IOException | SQLException ex) {
        }
    }
}
