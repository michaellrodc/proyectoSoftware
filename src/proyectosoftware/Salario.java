
package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class Salario {

    public Salario() {
    }
    
    
    public float calcularSalario(String codigo1, String codigo2) throws SQLException
    {
       
    
        Comision a= new Comision();
        Descuento b = new Descuento(0.0945,0.04);
        float salarioFinal= 500+a.calcularComision(codigo1) - b.calcularDescuento(codigo2);
        System.out.println(a.calcularComision(codigo1));
        System.out.println(b.calcularDescuento(codigo2));
        System.out.println(salarioFinal);
        return salarioFinal;
        
        
    }
}
