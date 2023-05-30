/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosoftware;

import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */
public class formularioRegistroDescuento {
    String cbxOpcion;
    String codDescuento;
    String codComision;
    
    formularioRegistroDescuento(String cbx){
        this.cbxOpcion=cbx;
        codDescuento=null;
        codComision=null;
    }

    public void registroDescuento(javax.swing.JPanel d, javax.swing.JPanel c, float SRI, float Iees)
    {

             d.setVisible(true);
             c.setVisible(false);           
             Descuento x= new Descuento(SRI,Iees);
             x.registrarDescuento();
             codDescuento=x.getcodDescuento();

    }
    public void registroComision(javax.swing.JPanel d, javax.swing.JPanel c, int horasAntes, int horasDespues, float comisiones)
    {
        d.setVisible(false);
        c.setVisible(true);
        Comision x = new Comision(horasAntes,horasDespues,comisiones);       
        x.IngresarComision();
        codComision=x.getcodcomision();
             

    }
    
}
