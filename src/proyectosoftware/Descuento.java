
package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Descuento {
    private float aportacionesIESS;
    private float aportacionesSRI;

    public Descuento(float aportacionesIESS, float aportacionesSRI) {
        this.aportacionesIESS = aportacionesIESS;
        this.aportacionesSRI = aportacionesSRI;
    }
    
    public float calcularDescuento(String codigoEmpleado) throws SQLException
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        float descuentoTotal=0;
        
       
        try {
            con = conexion.conector();
            String query = "SELECT d.aportacionesIEES, d.aportacionesSRI, e.emp_salario FROM empleado e, descuento d, salario s WHERE d.desc_codigo = ? AND d.desc_codigo = s.slr_cms_codigo AND e.emp_sal_codigo = s.slr_codigo";
            stmt = con.prepareStatement(query);

            stmt.setString(1, codigoEmpleado);
            
            
            aportacionesIESS = result.getFloat("aportacionesIEES");
            aportacionesSRI = result.getFloat("aportacionesSRI");
            float salario = result.getFloat("emp_salario");
            result = stmt.executeQuery();
            
            
            descuentoTotal = (float) ((salario * aportacionesIESS) + (salario * aportacionesSRI));
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
            }
        return descuentoTotal;
              
    }
}