package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mao_a
 */
public class Empleado {
    Conexion conexion = new Conexion();
        java.sql.Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
    
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

    public Empleado(String cedula, String nombre, String apellido, String categoria, String contrato, int horasEquivalentes, double salarioNeto, String codigoSalario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.contrato = contrato;
        this.horasEquivalentes = horasEquivalentes;
        this.salarioNeto = salarioNeto;
        this.codigoSalario = codigoSalario;
        
        
        
        //SEPARAR EN FUNCION
        try {
            con = conexion.conector();
            String cadena = "INSERT INTO empleado (emp_cedula, emp_nombre, emp_apellido, emp_categoria, emp_contrato, emp_horasEquivalentes, emp_salarioNeto, emp_sal_codigo) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(cadena);

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
        } catch (IOException ex) {
            //Logger.getLogger(pantallaInsertar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(pantallaInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //SOBRECARGA DE EMPLEADO POR CEDULA con funcion que devuelva empleado
    /*
    public ArrayList<String> listadoCI(){
        ArrayList<String> Ci =null;
        Conexion conexion = new Conexion();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            // TODO add your handling code here:

            con = conexion.conector();
            String query =("SELECT emp_cedula FROM Empleado");
           
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String ci=rs.getString("emp_cedula");
                Ci.add(ci);
            }


            
            JOptionPane.showMessageDialog(null, "Usuario Ingresado Correctamente" );
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        }
        return Ci;
    }*/
    
}
