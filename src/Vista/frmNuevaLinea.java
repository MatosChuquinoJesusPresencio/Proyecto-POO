/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Controlador.ControladorPlan;
import Controlador.ControladorFactura;
import java.util.ArrayList;
import Modelo.Plan;
import Controlador.ControladorLinea;
import Modelo.Cliente;
import Modelo.Linea;
import javax.swing.JOptionPane;
import Modelo.Factura;

/**
 *
 * @author megap
 */
public class frmNuevaLinea extends javax.swing.JFrame {
    
    //Atributos de frmNuevaLinea
    private frmMenu frmMenu;
    private ArrayList<Plan> listaPlanes;  
    private Cliente Cliente;
    
    /**
     * Creates new form frmSolicitarLinea
     */
    
    //Constructor parametrizado
    public frmNuevaLinea(Cliente Cliente) {
        this.Cliente = Cliente;
        initComponents();
    }
    public frmNuevaLinea() {
        initComponents();
    }

    //Metodos setters y getters
    public frmMenu getFrmMenu() {
        return frmMenu;
    }
    public void setFrmMenu(frmMenu frmMenu) {
        this.frmMenu = frmMenu;
    }  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelSoliLinea = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPlan = new javax.swing.JLabel();
        jcbPlanes = new javax.swing.JComboBox<>();
        btnSolicitarPlan = new javax.swing.JButton();
        lblPrecio = new javax.swing.JLabel();
        lblBeneficios = new javax.swing.JLabel();
        lblApps = new javax.swing.JLabel();
        lblGigas = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        jbPostpago = new javax.swing.JRadioButton();
        jbPrepago = new javax.swing.JRadioButton();
        jbEmpresarial = new javax.swing.JRadioButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nueva Linea");
        setMinimumSize(new java.awt.Dimension(868, 612));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(868, 612));
        jPanel1.setMinimumSize(new java.awt.Dimension(868, 612));
        jPanel1.setPreferredSize(new java.awt.Dimension(868, 612));

        labelSoliLinea.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        labelSoliLinea.setForeground(new java.awt.Color(255, 255, 255));
        labelSoliLinea.setText("SOLICITA UNA LINEA");

        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(798, 376));

        lblPlan.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblPlan.setForeground(new java.awt.Color(0, 0, 0));
        lblPlan.setText("Seleccione un plan:");

        jcbPlanes.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jcbPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPlanesActionPerformed(evt);
            }
        });

        btnSolicitarPlan.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnSolicitarPlan.setForeground(new java.awt.Color(0, 0, 0));
        btnSolicitarPlan.setText("Solicitar Linea");
        btnSolicitarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarPlanActionPerformed(evt);
            }
        });

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecio.setText("Precio: ...");

        lblBeneficios.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblBeneficios.setForeground(new java.awt.Color(0, 0, 0));
        lblBeneficios.setText("Beneficios: ...");
        lblBeneficios.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblApps.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblApps.setForeground(new java.awt.Color(0, 0, 0));
        lblApps.setText("Apps: ...");

        lblGigas.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblGigas.setForeground(new java.awt.Color(0, 0, 0));
        lblGigas.setText("Gigas: ....");

        lblDetalles.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblDetalles.setForeground(new java.awt.Color(0, 0, 0));
        lblDetalles.setText("Detalles: .....");

        buttonGroup1.add(jbPostpago);
        jbPostpago.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jbPostpago.setForeground(new java.awt.Color(0, 0, 0));
        jbPostpago.setText("Postpago");
        jbPostpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPostpagoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbPrepago);
        jbPrepago.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jbPrepago.setForeground(new java.awt.Color(0, 0, 0));
        jbPrepago.setText("Prepago");
        jbPrepago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrepagoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jbEmpresarial);
        jbEmpresarial.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jbEmpresarial.setForeground(new java.awt.Color(0, 0, 0));
        jbEmpresarial.setText("Empresarial");
        jbEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmpresarialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBeneficios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbPrepago)
                                    .addComponent(jbPostpago)
                                    .addComponent(jbEmpresarial)))
                            .addComponent(lblPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGigas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 43, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(btnSolicitarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGigas)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDetalles))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbPostpago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPrepago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEmpresarial)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApps, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSolicitarPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(labelSoliLinea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSoliLinea)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para cargar los planes
    private void cargarPlanes(String tipoPlan) {
        jcbPlanes.removeAllItems(); // Limpiar el ComboBox antes de cargar nuevos planes
        listaPlanes = ControladorPlan.cargarPlanes(tipoPlan);
    
        for (Plan plan : listaPlanes) {
            jcbPlanes.addItem(plan.getIdPlan());
        }
    }
    
    //Metodo para mostrar las caracteristicas de los planes en el label
    private void mostrarDatosPlan(Plan Plan){
        lblApps.setText("Apps: " + Plan.getApps());
        String Beneficios = Plan.getBeneficios();
        lblBeneficios.setText("<html><body style='width: 500px;'>" + "Beneficios: " + Beneficios + "</body></html>");
        lblGigas.setText("Gigas: " + Plan.getGigas());
        lblPrecio.setText("Precio: S/." + Plan.getPrecio());
        lblDetalles.setText("Detalles: " + Plan.getDetalles());
    }
    
    //Combo box para elegir los planes
    private void jcbPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPlanesActionPerformed
        // TODO add your handling code here:
        int index = jcbPlanes.getSelectedIndex();
        if (index >= 0 && listaPlanes != null) {
            Plan planSeleccionado = listaPlanes.get(index);
            mostrarDatosPlan(planSeleccionado);
        }
    }//GEN-LAST:event_jcbPlanesActionPerformed

    //Boton para volver al anterior frm
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        jcbPlanes.removeAllItems(); 
        lblApps.setText("Apps: ...");
        lblBeneficios.setText("Beneficios: ...");
        lblGigas.setText("Gigas: ...");
        lblPrecio.setText("Precio: ...");
        lblDetalles.setText("Detalles: ...");
        
        buttonGroup1.clearSelection();
        
        frmMenu.setfrmSolicitarLinea(this);
        frmMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed
    
    //Boton donde se agrega la linea al cliente, y se inserta la linea, factura y detalle factura en la base de datos
    private void btnSolicitarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarPlanActionPerformed
        // TODO add your handling code here:
        
        int index = jcbPlanes.getSelectedIndex(); 
        if (index >= 0 && listaPlanes != null && index < listaPlanes.size() && Cliente != null) {
            Plan planSeleccionado = listaPlanes.get(index);

            Linea linea = ControladorLinea.nuevaLinea(Cliente.getIdUusario(), 
                                                            planSeleccionado.getIdPlan(), 
                                                            planSeleccionado.getDuracionDias(),
                                                            planSeleccionado.getTipoPlan());
            
            if (linea != null) {
                Cliente.getLineas().add(linea);   
                if (!planSeleccionado.getTipoPlan().equals("PREPAGO")){
                    Factura Factura = ControladorFactura.nuevaFactura(Cliente.getIdUusario(), planSeleccionado.getPrecio(), 
                    planSeleccionado.getDuracionDias());
                    Cliente.getFacturas().add(Factura);
                    ControladorFactura.nuevoDetalleDactura(Factura.getIdFactura(), linea.getIdLinea(), null,
                            "Nuevo Plan", planSeleccionado.getPrecio(), 0, 0);
                }                
                frmMenu.setCliente(Cliente);   
                
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la línea. Intente nuevamente.");
            }
            JOptionPane.showMessageDialog(this, "Línea solicitada con éxito, su número es: " + linea.getTelefono());
            
            jcbPlanes.removeAllItems(); 
            lblApps.setText("Apps: ...");
            lblBeneficios.setText("Beneficios: ...");
            lblGigas.setText("Gigas: ...");
            lblPrecio.setText("Precio: ...");
            lblDetalles.setText("Detalles: ...");
            
            buttonGroup1.clearSelection();
            
            frmMenu.setfrmSolicitarLinea(this);
            frmMenu.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un plan antes de solicitar.");
        }      
    }//GEN-LAST:event_btnSolicitarPlanActionPerformed

    //Radiobutton para cargar el combobox 
    private void jbPostpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPostpagoActionPerformed
        // TODO add your handling code here:
        if (jbPostpago.isSelected()) {
            cargarPlanes("POSTPAGO");
        } else {
            jcbPlanes.removeAllItems();
        }
    }//GEN-LAST:event_jbPostpagoActionPerformed

    //Radiobutton para cargar el combobox 
    private void jbPrepagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrepagoActionPerformed
        // TODO add your handling code here:
        if (jbPrepago.isSelected()) {
            cargarPlanes("PREPAGO");
        } else {
            jcbPlanes.removeAllItems();
        }
    }//GEN-LAST:event_jbPrepagoActionPerformed

    //Radiobutton para cargar el combobox 
    private void jbEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmpresarialActionPerformed
        // TODO add your handling code here:
        if (jbEmpresarial.isSelected()) {
            cargarPlanes("EMPRESARIAL");
        } else {
            jcbPlanes.removeAllItems();
        }
    }//GEN-LAST:event_jbEmpresarialActionPerformed

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
            java.util.logging.Logger.getLogger(frmNuevaLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNuevaLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNuevaLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNuevaLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNuevaLinea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSolicitarPlan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jbEmpresarial;
    private javax.swing.JRadioButton jbPostpago;
    private javax.swing.JRadioButton jbPrepago;
    private javax.swing.JComboBox<String> jcbPlanes;
    private javax.swing.JLabel labelSoliLinea;
    private javax.swing.JLabel lblApps;
    private javax.swing.JLabel lblBeneficios;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblGigas;
    private javax.swing.JLabel lblPlan;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}