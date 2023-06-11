/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosoftware;

/**
 *
 * @author danny
 */
public class pantallaOpciones extends javax.swing.JFrame {

    /**
     * Creates new form pantallaOpciones
     */
    public pantallaOpciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnIngresoEmpleados = new javax.swing.JButton();
        btnConsultaSalario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 13)); // NOI18N
        jLabel1.setText("¿Qué opción desea Realizar ?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 27, -1, 20));

        btnIngresoEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN INGRESO EMPLEADOS.jpg"))); // NOI18N
        btnIngresoEmpleados.setToolTipText("Boton que permite registrar empleados");
        btnIngresoEmpleados.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnIngresoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoEmpleadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresoEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 90));

        btnConsultaSalario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnBusqueda.jpg"))); // NOI18N
        btnConsultaSalario.setToolTipText("boton que permite realizar consultas");
        btnConsultaSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaSalarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultaSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 110, 90));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnIngreso descuentos.jpg"))); // NOI18N
        jButton1.setToolTipText("Bton que permite registrar Salarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 110, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantallaOpciones.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 300));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaSalarioActionPerformed
        // TODO add your handling code here:
        
        pantallaConsultar a = new pantallaConsultar();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnConsultaSalarioActionPerformed

    private void btnIngresoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoEmpleadosActionPerformed
        // TODO add your handling code here:
        IngresoEmpleado a =new IngresoEmpleado();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnIngresoEmpleadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        pantallaIngresoDescuento a = new pantallaIngresoDescuento();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaSalario;
    private javax.swing.JButton btnIngresoEmpleados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
