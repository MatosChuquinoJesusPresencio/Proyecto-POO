/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;
import Controlador.ControladorLogin;

/**
 *
 * @author megap
 */
public class frmLoginEmpleado extends javax.swing.JFrame {

    private frmBienvenida frmBienvenida;  
    /**
     * Creates new form frmLoginEmpleado
     */
    public frmLoginEmpleado() {
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

        panelLoginEmpleado1 = new javax.swing.JPanel();
        panelLoginEmpleado2 = new javax.swing.JPanel();
        btnVerificarDatosEmpleado = new javax.swing.JButton();
        labelDocumento = new javax.swing.JLabel();
        labelContra = new javax.swing.JLabel();
        txtNumDocuEmpleado = new javax.swing.JTextField();
        passwordEmpleado = new javax.swing.JPasswordField();
        labelBienvenidaLogin = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Empleado");
        setMaximumSize(new java.awt.Dimension(868, 612));
        setMinimumSize(new java.awt.Dimension(868, 612));

        panelLoginEmpleado1.setBackground(new java.awt.Color(0, 102, 102));
        panelLoginEmpleado1.setMaximumSize(new java.awt.Dimension(868, 612));
        panelLoginEmpleado1.setMinimumSize(new java.awt.Dimension(868, 612));
        panelLoginEmpleado1.setPreferredSize(new java.awt.Dimension(868, 612));

        btnVerificarDatosEmpleado.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        btnVerificarDatosEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        btnVerificarDatosEmpleado.setText("Ingresar");
        btnVerificarDatosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarDatosEmpleadoActionPerformed(evt);
            }
        });

        labelDocumento.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        labelDocumento.setForeground(new java.awt.Color(0, 0, 0));
        labelDocumento.setText("Nº Documento:");

        labelContra.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        labelContra.setForeground(new java.awt.Color(0, 0, 0));
        labelContra.setText("Contrasena:");

        txtNumDocuEmpleado.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtNumDocuEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        txtNumDocuEmpleado.setName(""); // NOI18N
        txtNumDocuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocuEmpleadoActionPerformed(evt);
            }
        });

        passwordEmpleado.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        passwordEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginEmpleado2Layout = new javax.swing.GroupLayout(panelLoginEmpleado2);
        panelLoginEmpleado2.setLayout(panelLoginEmpleado2Layout);
        panelLoginEmpleado2Layout.setHorizontalGroup(
            panelLoginEmpleado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginEmpleado2Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(btnVerificarDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(panelLoginEmpleado2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelLoginEmpleado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumDocuEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(passwordEmpleado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLoginEmpleado2Layout.setVerticalGroup(
            panelLoginEmpleado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginEmpleado2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(labelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumDocuEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(labelContra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnVerificarDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        txtNumDocuEmpleado.getAccessibleContext().setAccessibleName("");

        labelBienvenidaLogin.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        labelBienvenidaLogin.setForeground(new java.awt.Color(255, 255, 255));
        labelBienvenidaLogin.setText("Bienvenido denuevo empleado");

        btnAtras.setBackground(new java.awt.Color(0, 102, 102));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Atras.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras.setMaximumSize(new java.awt.Dimension(45, 55));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginEmpleado1Layout = new javax.swing.GroupLayout(panelLoginEmpleado1);
        panelLoginEmpleado1.setLayout(panelLoginEmpleado1Layout);
        panelLoginEmpleado1Layout.setHorizontalGroup(
            panelLoginEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginEmpleado1Layout.createSequentialGroup()
                .addGroup(panelLoginEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLoginEmpleado1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(panelLoginEmpleado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginEmpleado1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(labelBienvenidaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        panelLoginEmpleado1Layout.setVerticalGroup(
            panelLoginEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginEmpleado1Layout.createSequentialGroup()
                .addGroup(panelLoginEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginEmpleado1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelBienvenidaLogin))
                    .addGroup(panelLoginEmpleado1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(panelLoginEmpleado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLoginEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLoginEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public frmBienvenida getfrmBienvenida() {
        return frmBienvenida;
    }
    public void setfrmBienvenida(frmBienvenida frmBienvenida) {
        this.frmBienvenida = frmBienvenida;
    }   
    
    private void btnVerificarDatosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarDatosEmpleadoActionPerformed
        // TODO add your handling code here:
        String Documento = txtNumDocuEmpleado.getText();
        String Contrasena = new String(passwordEmpleado.getPassword());

        if (Documento.isEmpty() || Contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean autenticado = ControladorLogin.verificarDatos(Documento, Contrasena);

        if (autenticado) {
            JOptionPane.showMessageDialog(this, "Si", "Acceso correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {    
            JOptionPane.showMessageDialog(this, "No", "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarDatosEmpleadoActionPerformed

    private void txtNumDocuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocuEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocuEmpleadoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:       
        frmBienvenida.setfrmLoginEmpleado(this);
        frmBienvenida.setVisible(true);
        this.setVisible(false);
        txtNumDocuEmpleado.setText("");
        passwordEmpleado.setText("");
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void passwordEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordEmpleadoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_passwordEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(frmLoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLoginEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnVerificarDatosEmpleado;
    private javax.swing.JLabel labelBienvenidaLogin;
    private javax.swing.JLabel labelContra;
    private javax.swing.JLabel labelDocumento;
    private javax.swing.JPanel panelLoginEmpleado1;
    private javax.swing.JPanel panelLoginEmpleado2;
    private javax.swing.JPasswordField passwordEmpleado;
    private javax.swing.JTextField txtNumDocuEmpleado;
    // End of variables declaration//GEN-END:variables
}
