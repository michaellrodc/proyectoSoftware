
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
    private String codigoDescuento;

    public Descuento(double aporteIESS, double aporteSRI) {
        this.aportacionesIESS = (float)aporteIESS;
        this.aportacionesSRI =  (float) aporteSRI;
        
        this.codigoDescuento=null;
        //System.out.println(aportacionesIESS);
        //System.out.println(aportacionesSRI);
    }
    
    public float calcularDescuento(String codigo) throws SQLException {
    Conexion conexion = new Conexion();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet result = null;

    float descuentoTotal = 0;

    try {
        con = conexion.conector();
        String query = "SELECT d.desc_aporteIESS, d.desc_aporteSRI FROM descuento d, salario s WHERE s.slr_codigo = ? AND s.desc_codigo = d.desc_codigo";
        stmt = con.prepareStatement(query);

        stmt.setString(1, codigo);

        result = stmt.executeQuery();

        if (result.next()) {
            float aportacionesIESS = result.getFloat("desc_aporteIESS");
            float aportacionesSRI = result.getFloat("desc_aporteSRI");
            System.out.println(aportacionesIESS);
            System.out.println(aportacionesSRI);

            codigo = codigo.substring(5);

            descuentoTotal = (float) ((Empleado.getEmpleado(codigo).getSalarioNeto() * aportacionesIESS) + (Empleado.getEmpleado(codigo).getSalarioNeto() * aportacionesSRI));
        }
    } catch (IOException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
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
    return descuentoTotal;
    }
    public void registrarDescuento()
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        String codigoSecuencial;
        
        generrarCodigos a= new generrarCodigos();
        codigoSecuencial=a.codigoDescuento();
        codigoDescuento=codigoSecuencial;

        try {
            // TODO add your handling code here:

            con = conexion.conector();
            String query =("INSERT INTO Descuento (desc_codigo, desc_aporteIESS,desc_aporteSRI) VALUES (?, ?, ?)");
            
            stmt = con.prepareStatement(query);
            stmt.setString(1, codigoSecuencial);
            //System.out.println(aportacionesIESS);
            //System.out.println(aportacionesSRI);
            stmt.setFloat(2, aportacionesIESS);
            stmt.setFloat(3, aportacionesSRI);
            

               
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "descuento Ingresado Correctamente" );
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        }
    }
    public String getcodDescuento()
    {
        String resultado =this.codigoDescuento;
        
        return resultado;
    }
}