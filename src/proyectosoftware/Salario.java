
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

    public float calcularSalario(String salarioCodigo) throws SQLException {
        float salarioFinal = 0;

        Comision a = new Comision();
        Descuento b = new Descuento(0.0945, 0.04);

        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            con = conexion.conector();
            String query = "SELECT e.slr_codigo, s.desc_codigo, s.com_codigo FROM Empleado e, Salario s WHERE e.slr_codigo = s.slr_codigo AND s.slr_codigo=?";
            stmt = con.prepareStatement(query);

            stmt.setString(1, salarioCodigo);
            result = stmt.executeQuery();

            if (result.next()) {
                String com_codigo = result.getString("com_codigo");
                String desc_codigo = result.getString("desc_codigo");
                float salarioNeto = 0;
                float comision = a.calcularComision(com_codigo);
                float descuento = b.calcularDescuento(desc_codigo);
                

                salarioFinal = salarioNeto + comision - descuento;
            }

        } catch (IOException | SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return salarioFinal;
    }


    
    
    //--------------------------------------------
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
            if(rs.next())
            {
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
