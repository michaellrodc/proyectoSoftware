package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consulta {
    private JTable table;
    private DefaultTableModel model;

    public Consulta(JTable table) {
    this.table = table;
    this.model = (DefaultTableModel) table.getModel();
}


    public void mostrarTabla(String cedula) throws SQLException {
    Conexion conexion = new Conexion();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet result = null;

    try {
        con = conexion.conector();
        String query = "SELECT e.emp_cedula, e.emp_nombre, e.emp_apellido, e.emp_categoria, e.emp_contrato, e.emp_salarioNeto FROM Empleado e WHERE e.emp_cedula = ?";
        stmt = con.prepareStatement(query);

        stmt.setString(1, cedula);

        result = stmt.executeQuery();
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
            System.out.println("Si");

        // Utilizar el modelo existente
        while (result.next()) {
            System.out.println("Si2");
            Object[] fila = new Object[6];
            fila[0] = result.getString("emp_cedula");
            fila[1] = result.getString("emp_nombre");
            fila[2] = result.getString("emp_apellido");
            fila[3] = result.getString("emp_categoria");
            fila[4] = result.getString("emp_contrato");
            fila[5] = result.getString("emp_salarioNeto");
            model.addRow(fila);
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
}
}
