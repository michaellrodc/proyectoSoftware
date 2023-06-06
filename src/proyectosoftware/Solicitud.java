
package proyectosoftware;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class Solicitud {
    
    private static Conexion conexion = new Conexion();
    private static java.sql.Connection con = null;
    private static PreparedStatement stmt = null;
    private static ResultSet result = null;
    
    
    private String codigoSolicitud;
    private boolean estadoSolicitud;
    private String estadoProceso; //Activo Completado Rechazado
    private Empleado emp;

    public Solicitud( String cedula) {
        
        this.codigoSolicitud = "SLC-"+cedula;  
        this.estadoSolicitud = true;
        this.estadoProceso = "Activo";
        this.emp = Empleado.getEmpleado(cedula);
    }
    
    public boolean validarExtranjero(String cedula){
        return emp.getExtranjero();
    }
    
    public void actualizarEstado(String estado){
        this.estadoProceso = estado;
        
        try {
            con = conexion.conector();
            String cadena = "INSERT INTO Solicitud (slc_codigo,slc_estadoProceso,slc_estadoSolicitud) VALUES (?,?,?)";
            stmt = con.prepareStatement(cadena);

            stmt.setString(1, this.codigoSolicitud);
            stmt.setString(2, this.estadoProceso);
            stmt.setBoolean(3, this.estadoSolicitud);

            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null, "Solicitud ingresada correctamente");

        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        }
        
    }
    
    public void registroSolicitud(){
        
        try {
            con = conexion.conector();
            String cadena = "INSERT INTO Solicitud (slc_codigo,slc_estadoProceso,slc_estadoSolicitud) VALUES (?,?,?)";
            stmt = con.prepareStatement(cadena);

            stmt.setString(1, this.codigoSolicitud);
            stmt.setString(2, this.estadoProceso);
            stmt.setBoolean(3, this.estadoSolicitud);

            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null, "Solicitud ingresada correctamente");

        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex.getMessage());
        }
    }
    //patron estado
    private void eliminarRegistroAnterior(){
        /*try {
            con = conexion.conector();
            
            String cadena = "DELETE * FROM Empleado WHERE emp_cedula = ?";
            stmt = con.prepareStatement(cadena);
            stmt.setString(1, cedula);
            result = stmt.executeQuery();
            
            if (result.next()) {
                empleado = new Empleado(
                    result.getString("emp_cedula"),
                    result.getString("emp_nombre"),
                    result.getString("emp_apellido"),
                    result.getBoolean("emp_extranjero"),
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
        }*/
    }
    
}
