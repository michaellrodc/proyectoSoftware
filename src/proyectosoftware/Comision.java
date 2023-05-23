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
    public float calcularComision(String codigo) throws SQLException
    {
        Conexion conexion = new Conexion();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        float comisionTotal=0;
        try {
            con = conexion.conector();
            String query = "SELECT c.horasExtraAntes, c.horasExtraDespues, c.valorComision, e.emp_salario FROM empleado e, comision c, salario s WHERE c.com_codigo = ? AND c.com_codigo = s.slr_cms_codigo AND e.emp_sal_codigo = s.slr_codigo";
            stmt = con.prepareStatement(query);

            stmt.setString(1, codigo);
            
            horasExtraAntes = result.getInt("horasExtraAntes");
            horasExtraDespues = result.getInt("horasExtraDespues");
            valorComision = result.getFloat("valorComision");
            float salario = result.getFloat("emp_salario");
            result = stmt.executeQuery();
            
            
            comisionTotal = (float) (((horasExtraAntes * 1.5)*salario/160)+((horasExtraDespues * 2)*salario/160));
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
            }
        return comisionTotal;
              
        }
          
        
    }