package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Comision {

    private int horasExtraAntes;
    private int horasExtraDespues;
    private float valorComision;

    public Comision() {
    this.horasExtraAntes = 0;
    this.horasExtraDespues = 0;
    this.valorComision = 0;
    }
    public float calcularComision(String codigo) throws SQLException {
    Conexion conexion = new Conexion();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet result = null;
    float comisionTotal = 0;
    try {
        con = conexion.conector();
        String query = "SELECT c.com_horasExtraAntes, c.com_horasExtraDespues, c.com_valorComision FROM comision c, salario s WHERE c.com_codigo = ? ";
        stmt = con.prepareStatement(query);

        stmt.setString(1, codigo);

        result = stmt.executeQuery();

        if (result.next()) {
            int horasExtraAntes = result.getInt("com_horasExtraAntes");
            int horasExtraDespues = result.getInt("com_horasExtraDespues");
            float valorComision = result.getFloat("com_valorComision");
           

            comisionTotal = (float) (((horasExtraAntes * 1.5) * 500 / 160) + ((horasExtraDespues * 2) * 500 / 160));
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
    return comisionTotal;
}
}
