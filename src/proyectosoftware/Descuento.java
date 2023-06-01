
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
        String query = "SELECT d.desc_aporteIESS, d.desc_aporteSRI FROM descuento d, salario s WHERE d.desc_codigo = ?";
        stmt = con.prepareStatement(query);

        stmt.setString(1, codigo);

        result = stmt.executeQuery();

        if (result.next()) {
            float aportacionesIESS = result.getFloat("desc_aporteIESS");
            float aportacionesSRI = result.getFloat("desc_aporteSRI");
            System.out.println(aportacionesIESS);
            System.out.println(aportacionesSRI);

            descuentoTotal = (float) ((500 * aportacionesIESS) + (500 * aportacionesSRI));
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
    public void registrarDescuento(String ci)
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        String codigoSecuencial;
        ci="DESC-"+ci;
        validarCodigos ab =new validarCodigos();
        codigoDescuento=ci;

        try {
            con = conexion.conector();
            if (!ab.validarDescuento(ci))
            {
                String query =("INSERT INTO Descuento (desc_codigo, desc_aporteIESS,desc_aporteSRI) VALUES (?, ?, ?)");
            
            stmt = con.prepareStatement(query);
            stmt.setString(1, ci);
            stmt.setFloat(2, aportacionesIESS);
            stmt.setFloat(3, aportacionesSRI);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Descuento Ingresado Correctamente" );
            }
            else
            {
                String query =("UPDATE Descuento SET desc_aporteIESS = ?, desc_aporteSRI = ?  WHERE desc_codigo='"+ci+"';");
            
                stmt = con.prepareStatement(query);
                stmt.setFloat(1, aportacionesIESS);
                stmt.setFloat(2, aportacionesSRI);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Descuento Actualizado Correctamente" );
            }

            
            
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