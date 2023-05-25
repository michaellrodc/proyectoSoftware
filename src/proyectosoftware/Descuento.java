
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

    public Descuento(double aporteIESS, double aporteSRI) {
        this.aportacionesIESS = (float) aportacionesIESS;
        this.aportacionesSRI =  (float) aportacionesSRI;
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
}