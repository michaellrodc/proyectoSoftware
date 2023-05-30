package proyectosoftware;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mao_a
 */
public class Empleado {
    Conexion conexion = new Conexion();
    java.sql.Connection con = null;
    PreparedStatement stmt = null;
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String categoria;
    private String contrato;
    private int horasEquivalentes;
    private double salarioNeto;
    private String codigoSalario;

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public Empleado(String cedula, String nombre, String apellido, String categoria, String contrato, int horasEquivalentes, double salarioNeto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.contrato = contrato;
        this.horasEquivalentes = horasEquivalentes;
        this.salarioNeto = salarioNeto;
        this.codigoSalario = "SLR_"+cedula;

    }
    
    public boolean registroEmpleado(){
        try {
            con = conexion.conector();
            String cadena = "INSERT INTO Empleado (emp_cedula,emp_nombre,emp_apellido,emp_categoria,emp_contrato,emp_horasEquivalentes,emp_salarioNeto,slr_codigo) VALUES (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cadena);

            stmt.setString(1, this.cedula);
            stmt.setString(2, this.nombre);
            stmt.setString(3, this.apellido);
            stmt.setString(4, this.categoria);
            stmt.setString(5, this.contrato);
            stmt.setInt(6, this.horasEquivalentes);
            stmt.setDouble(7, this.salarioNeto);
            stmt.setString(8, this.codigoSalario);

            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
            return false;
        }
    }
}
