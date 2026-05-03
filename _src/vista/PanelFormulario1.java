package vista;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import servicios.PartidoService;

public class PanelFormulario1 extends javax.swing.JPanel {
    
    public PanelFormulario1() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblVotos = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        ftxtVotos = new javax.swing.JFormattedTextField();

        lblNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNombre.setText("Nombre del partido");
        lblNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreMouseClicked(evt);
            }
        });

        lblVotos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblVotos.setText("Votos");
        lblVotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVotosMouseClicked(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnAceptar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAceptarKeyReleased(evt);
            }
        });

        ftxtVotos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        ftxtVotos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtVotos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ftxtVotos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtVotosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblVotos))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ftxtVotos)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVotos)
                    .addComponent(ftxtVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Redirige el foco al campo de nombre al hacer click en su etiqueta.
     */
    private void lblNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreMouseClicked
        txtNombre.requestFocus();
    }//GEN-LAST:event_lblNombreMouseClicked

    /**
     * Redirige el foco al campo de votos al hacer click en su etiqueta.
     */
    private void lblVotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVotosMouseClicked
        ftxtVotos.requestFocus();
    }//GEN-LAST:event_lblVotosMouseClicked
    
    /**
    * Valida los datos ingresados y guarda el nuevo partido en la base de datos.
    * Delega la validación y persistencia a PartidoService, mostrando un mensaje
    * de éxito o error según el resultado.
    */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre = txtNombre.getText().trim();
        String votos = ftxtVotos.getText().trim();
        
        try {
            PartidoService.crearPartido(nombre, votos);
            txtNombre.setText("");
            txtNombre.requestFocus();
            ftxtVotos.setText("");
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.txtNombre.requestFocus();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
    * Filtra la entrada del teclado en el campo de votos,
    * permitiendo únicamente dígitos numéricos.
    */
    private void ftxtVotosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtVotosKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_ftxtVotosKeyTyped

    /**
    * Permite confirmar el formulario presionando Enter
    * como alternativa al click del botón Aceptar.
    */
    private void btnAceptarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             btnAceptar.doClick();
        }
    }//GEN-LAST:event_btnAceptarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JFormattedTextField ftxtVotos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblVotos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
