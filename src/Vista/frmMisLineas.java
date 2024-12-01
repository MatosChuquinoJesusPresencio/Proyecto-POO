/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author megap
 */
public class frmMisLineas extends javax.swing.JFrame {
    
    //Atributos de frmMisLineas
    private frmMenu frmMenu;
    private Cliente Cliente;
    private DefaultTableModel modelo;
    private frmCambiarEstadoLinea frmCambiarEstadoLinea;

    /**
     * Creates new form frmSolicitarLinea
     */
    public frmMisLineas() {
        initComponents();
    }
    
    //Constructor parametrizado
    public frmMisLineas (Cliente Cliente){
        initComponents();       
        this.Cliente = Cliente;
        inicializarTabla();
        
        jtbLineas.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbLineas.rowAtPoint(evt.getPoint());
                if (row >= 0 && evt.getClickCount() == 2) { // Detecta doble clic
                    abrirFormulario(row);
                }
            }
        });
    }
    
    //Metodos setters y getters
    public frmMenu getFrmMenu() {
        return frmMenu;
    }
    public void setFrmMenu(frmMenu frmMenu) {
        this.frmMenu = frmMenu;
    }  
    public frmCambiarEstadoLinea getFrmCambiarEstadoLinea() {
        return frmCambiarEstadoLinea;
    }
    public void setFrmCambiarEstadoLinea(frmCambiarEstadoLinea frmCambiarEstadoLinea) {
        this.frmCambiarEstadoLinea = frmCambiarEstadoLinea;
    }
    
    //Metodo que inicializa la tabla
    private void inicializarTabla() {
        modelo = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };        
        
        modelo.addColumn("ID Línea");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Plan");
        modelo.addColumn("Estado");
        modelo.addColumn("F. Inicio");
        modelo.addColumn("F. Fin");
        
        jtbLineas.setModel(modelo);
        
        jtbLineas.getTableHeader().setReorderingAllowed(false);

        jtbLineas.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtbLineas.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtbLineas.getColumnModel().getColumn(2).setPreferredWidth(40);
        jtbLineas.getColumnModel().getColumn(3).setPreferredWidth(75);    
        jtbLineas.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtbLineas.getColumnModel().getColumn(5).setPreferredWidth(60);
        jtbLineas.setRowHeight(30);
    }
    
    //Metodo que abre el frm para cambiar el estado de la linea
    public void abrirFormulario(int row){
        
        int idLinea = (int) modelo.getValueAt(row, 0);
        int Telefono = (int) modelo.getValueAt(row, 1);
        String idCliente = Cliente.getIdUusario();
        
        String estadoPago =  Controlador.ControladorLinea.obtenerEstadoPagoPorLinea(idLinea, Cliente.getIdUusario());
        if (estadoPago.equals("VENCIDO") || estadoPago.equals("PENDIENTE")){
            JOptionPane.showMessageDialog(this, "Pague su linea antes de cambiar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            

            if (frmCambiarEstadoLinea == null){
                frmCambiarEstadoLinea = new frmCambiarEstadoLinea(Telefono, idLinea,idCliente);
                frmCambiarEstadoLinea.setFrmMisLineas(this);
            } else {
                frmCambiarEstadoLinea.setTelefono(Telefono);
                frmCambiarEstadoLinea.setIdLinea(idLinea);
                frmCambiarEstadoLinea.setIdCliente(idCliente);
            }
            frmCambiarEstadoLinea.setVisible(true);
        }
    }

    //Metodo que carga las lineas en la tabla
    public void cargarLineaTabla(ArrayList<Object[]> datos) {

        modelo.setRowCount(0);

        for (Object[] fila: datos){
            modelo.addRow(fila);
        }
    }
    
    //Override para cargar las lineas en la tabla al volver a entrar al frm
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);  // Llama al setVisible original para mostrar el formulario
        if (visible) {
        cargarLineaTabla(Controlador.ControladorLinea.obtenerLineas(Cliente.getIdUusario()));  // Recarga las líneas cuando se vuelve a hacer visible
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelSoliLinea = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLineas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lineas del Cliente");
        setMinimumSize(new java.awt.Dimension(868, 612));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(868, 612));
        jPanel1.setMinimumSize(new java.awt.Dimension(868, 612));
        jPanel1.setPreferredSize(new java.awt.Dimension(868, 612));

        labelSoliLinea.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        labelSoliLinea.setForeground(new java.awt.Color(255, 255, 255));
        labelSoliLinea.setText("MIS LINEAS");

        jPanel2.setPreferredSize(new java.awt.Dimension(798, 376));

        jScrollPane1.setViewportView(jtbLineas);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Haga dos veces para cambiar el estado de Linea");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238)
                .addComponent(labelSoliLinea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSoliLinea)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        frmMenu.setfrmVermisLineas(this);
        frmMenu.setVisible(true);
        this.setVisible(false);      
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(frmMisLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMisLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMisLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMisLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMisLineas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbLineas;
    private javax.swing.JLabel labelSoliLinea;
    // End of variables declaration//GEN-END:variables
}