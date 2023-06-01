package proyectosoftware;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mao_a
 */
public class Empleado {
    private static Conexion conexion = new Conexion();
    private static java.sql.Connection con = null;
    private static PreparedStatement stmt = null;
    private static ResultSet result = null;
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String categoria;
    private String contrato;
    private int horasEquivalentes;
    private double salarioNeto;
    private String codigoSalario;
    
    
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getContrato() {
        return contrato;
    }

    public int getHorasEquivalentes() {
        return horasEquivalentes;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public String getCodigoSalario() {
        return codigoSalario;
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
    
    
    static public Empleado getEmpleado(String cedula) {
        Empleado empleado = null;
        
        try {
            con = conexion.conector();
            
            String cadena = "SELECT * FROM Empleado WHERE Empleado.emp_cedula = ?";
            stmt = con.prepareStatement(cadena);
            stmt.setString(1, cedula);
            result = stmt.executeQuery();
            
            empleado = new Empleado(
                    result.getString("emp_cedula"),
                    result.getString("emp_nombre"),
                    result.getString("emp_apellido"),
                    result.getString("emp_categoria"),
                    result.getString("emp_contrato"),
                    result.getInt("emp_horasEquivalentes"),
                    result.getDouble("emp_salarioNeto")
            );
            
            stmt.close();
            con.close();
            
        } catch (IOException | SQLException ex) {
            System.out.println("Error en " + ex.getMessage());
        }
        
        return empleado;
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
