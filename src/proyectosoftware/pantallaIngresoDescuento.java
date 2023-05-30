/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosoftware;

import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */
public class pantallaIngresoDescuento extends javax.swing.JFrame {

    /**
     * Creates new form pantallaIngresoDescuento
     */
    public pantallaIngresoDescuento() {
        initComponents();
    }
     static boolean banderac=false;
      static   boolean banderad=false;
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelDescuentos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelComisiones = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        labelValorSliderm = new javax.swing.JLabel();
        sliderMinimo = new javax.swing.JSlider();
        sliderMinimo1 = new javax.swing.JSlider();
        labelValorSliderm1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descuentos", "Comisiones" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 16, -1, -1));

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 80, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDescuentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Apotaciones al IEES");
        panelDescuentos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));
        panelDescuentos.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 80, -1));
        panelDescuentos.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 90, -1));

        jLabel2.setText("Aportaciones SRI");
        panelDescuentos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jPanel2.add(panelDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 140));

        panelComisiones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Horas Extras antes de las 24 horas");
        panelComisiones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setText("Horas Extras después de las 24 horas");
        panelComisiones.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel5.setText("Valor de Comisión");
        panelComisiones.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        panelComisiones.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 90, -1));

        labelValorSliderm.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelValorSliderm.setText("0.0");
        panelComisiones.add(labelValorSliderm, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 20));

        sliderMinimo.setMaximum(48);
        sliderMinimo.setPaintTicks(true);
        sliderMinimo.setToolTipText("Selecione el valor mínimo de el cílindraje del vehículo");
        sliderMinimo.setValue(0);
        sliderMinimo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMinimoStateChanged(evt);
            }
        });
        panelComisiones.add(sliderMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 140, -1));

        sliderMinimo1.setMaximum(48);
        sliderMinimo1.setPaintTicks(true);
        sliderMinimo1.setToolTipText("Selecione el valor mínimo de el cílindraje del vehículo");
        sliderMinimo1.setValue(0);
        sliderMinimo1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMinimo1StateChanged(evt);
            }
        });
        panelComisiones.add(sliderMinimo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 140, -1));

        labelValorSliderm1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelValorSliderm1.setText("0.0");
        panelComisiones.add(labelValorSliderm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 20));

        jPanel2.add(panelComisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 430, 170));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1750235069" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 120, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        llenadoCbx a = new llenadoCbx();
        a.llenado(jComboBox2);
        panelDescuentos.setVisible(true);
           panelComisiones.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cbxOpcionDesc = (String) jComboBox1.getSelectedItem();
        formularioRegistroDescuento z = new formularioRegistroDescuento(cbxOpcionDesc);
        
        if(cbxOpcionDesc.equals("Comisiones"))
       {
           int valorhorasantes = sliderMinimo.getValue();
        int valorhorasDespues = sliderMinimo.getValue();
        float valorcomision= Float.parseFloat(jTextField5.getText().trim());
           z.registroComision(panelDescuentos, panelComisiones, valorhorasantes, valorhorasDespues, valorcomision);
           banderac=true;
           if(banderad&&banderac)
             {
            JOptionPane.showMessageDialog(null, "e");
            formularioRegistroSalariosCod y = new formularioRegistroSalariosCod();
            String cbxOpcionCI = (String) jComboBox2.getSelectedItem();
           y.registrarCods(cbxOpcionCI,z.codDescuento ,z.codComision );
           banderac=false;
             }
       }
        else
        {
            float valorIESS=Float.parseFloat(jTextField1.getText().trim());
        float valorSRI=Float.parseFloat(jTextField2.getText().trim());
            z.registroDescuento(panelDescuentos, panelComisiones, valorIESS, valorSRI);
            banderad=true;
            if(banderad&&banderac)
             {
            JOptionPane.showMessageDialog(null, "e");
            formularioRegistroSalariosCod y = new formularioRegistroSalariosCod();
            String cbxOpcionCI = (String) jComboBox2.getSelectedItem();
           y.registrarCods(cbxOpcionCI,z.codDescuento ,z.codComision );
           banderad=false;
             }
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        pantallaOpciones x = new pantallaOpciones();
        x.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sliderMinimoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMinimoStateChanged
        // TODO add your handling code here:
        double valor = sliderMinimo.getValue();
        labelValorSliderm.setText("" + valor);
    }//GEN-LAST:event_sliderMinimoStateChanged

    private void sliderMinimo1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMinimo1StateChanged
        // TODO add your handling code here:
        double valor = sliderMinimo1.getValue();
        labelValorSliderm1.setText("" + valor);
    }//GEN-LAST:event_sliderMinimo1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String cbxOpcionDesc = (String) jComboBox1.getSelectedItem();
        if(cbxOpcionDesc.equals("Descuentos"))
       {
           panelDescuentos.setVisible(true);
           panelComisiones.setVisible(false);
       }
        else
        {
            panelDescuentos.setVisible(false);
           panelComisiones.setVisible(true);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresoDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresoDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresoDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaIngresoDescuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaIngresoDescuento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel labelValorSliderm;
    private javax.swing.JLabel labelValorSliderm1;
    private javax.swing.JPanel panelComisiones;
    private javax.swing.JPanel panelDescuentos;
    private javax.swing.JSlider sliderMinimo;
    private javax.swing.JSlider sliderMinimo1;
    // End of variables declaration//GEN-END:variables
}
