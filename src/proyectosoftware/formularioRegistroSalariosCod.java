/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosoftware;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */
public class formularioRegistroSalariosCod {
    
    public void registrarCods(String cbxCI,String codDesc,String codComision)
    {
        Salario x= new Salario();
        x.ingresarCodigos(cbxCI, codDesc, codComision);
    }
    
}
