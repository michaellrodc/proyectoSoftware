package proyectosoftware;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
            
            String cadena = "SELECT * FROM Empleado WHERE emp_cedula = ?";
            stmt = con.prepareStatement(cadena);
            stmt.setString(1, cedula);
            result = stmt.executeQuery();
            
            if (result.next()) {
                empleado = new Empleado(
                    result.getString("emp_cedula"),
                    result.getString("emp_nombre"),
                    result.getString("emp_apellido"),
                    result.getString("emp_categoria"),
                    result.getString("emp_contrato"),
                    result.getInt("emp_horasEquivalentes"),
                    result.getDouble("emp_salarioNeto")
                );
            } else {
                System.out.println("No se encontro ningun empleado con la cedula "+ cedula);
            }
            
            
            
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
            
            JOptionPane.showMessageDialog(null, "Empleado ingresado correctamente");
            
            return true;
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
            return false;
        }
    }
    
    static public void calcularSueldoNet(int horas, String categoria, JTextField sueldo){
        double sueldoAux = 0;
        
        switch(categoria) {
            case "1" -> {sueldoAux = 527;}
            case "2" -> {sueldoAux = 553;}
            case "3" -> {sueldoAux = 585;}
            case "4" -> {sueldoAux = 622;}
            case "5" -> {sueldoAux = 675;}
            case "6" -> {sueldoAux = 733;}
            case "7" -> {sueldoAux = 817;}
            case "8" -> {sueldoAux = 901;}
            case "9" -> {sueldoAux = 986;}
            case "10" -> {sueldoAux = 1086;}
            case "11" -> {sueldoAux = 1212;}
            case "12" -> {sueldoAux = 1412;}
            case "13" -> {sueldoAux = 1676;}
            case "14" -> {sueldoAux = 1760;}
            case "15" -> {sueldoAux = 2034;}
        }
        
        double sueldoxHora = sueldoAux / 160;
        
        sueldoAux = sueldoxHora * horas * 20;
        
        DecimalFormat df = new DecimalFormat("####.##");
        df.format(sueldoAux);
        sueldo.setText(df.format(sueldoAux));
    }
}
