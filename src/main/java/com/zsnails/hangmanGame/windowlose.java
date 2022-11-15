
package com.zsnails.hangmanGame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class windowlose extends javax.swing.JDialog {

    
    public windowlose(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setpoints();
        setskulls();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btntablerating = new javax.swing.JButton();
        btnshowreply = new javax.swing.JButton();
        btnplayagain = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtpoints = new javax.swing.JLabel();
        btnleave = new javax.swing.JButton();
        imgskull = new javax.swing.JLabel();
        imgskull1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HAS PERDIDO");

        btntablerating.setBackground(new java.awt.Color(51, 51, 51));
        btntablerating.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btntablerating.setForeground(new java.awt.Color(255, 255, 255));
        btntablerating.setText("Tabla de clasificación");
        btntablerating.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btntablerating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntableratingActionPerformed(evt);
            }
        });

        btnshowreply.setBackground(new java.awt.Color(51, 51, 51));
        btnshowreply.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnshowreply.setForeground(new java.awt.Color(255, 255, 255));
        btnshowreply.setText("Respuesta");
        btnshowreply.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnshowreply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowreplyActionPerformed(evt);
            }
        });

        btnplayagain.setBackground(new java.awt.Color(51, 51, 51));
        btnplayagain.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnplayagain.setForeground(new java.awt.Color(255, 255, 255));
        btnplayagain.setText("Volver a jugar");
        btnplayagain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnplayagain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplayagainActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Freestyle Script", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PUNTUACION ");

        txtpoints.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtpoints.setForeground(new java.awt.Color(255, 255, 255));

        btnleave.setBackground(new java.awt.Color(51, 51, 51));
        btnleave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnleave.setForeground(new java.awt.Color(255, 255, 255));
        btnleave.setText("Menu principal");
        btnleave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnleaveActionPerformed(evt);
            }
        });

        imgskull.setText("jLabel3");

        imgskull1.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnshowreply, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntablerating, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnplayagain, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnleave, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgskull1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpoints, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addComponent(imgskull, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgskull, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(imgskull1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addComponent(txtpoints, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addComponent(btntablerating)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnshowreply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnplayagain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnleave)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnshowreplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowreplyActionPerformed
        
    }//GEN-LAST:event_btnshowreplyActionPerformed

    private void btnplayagainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplayagainActionPerformed
        
    }//GEN-LAST:event_btnplayagainActionPerformed

    private void btnleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnleaveActionPerformed
        dispose();
    }//GEN-LAST:event_btnleaveActionPerformed

    private void btntableratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntableratingActionPerformed
        
        
    }//GEN-LAST:event_btntableratingActionPerformed

    
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
            java.util.logging.Logger.getLogger(windowlose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(windowlose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(windowlose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(windowlose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                windowlose dialog = new windowlose(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    protected void setpoints(){
        
    }
    protected void setskulls(){
        ImageIcon skulls = new ImageIcon("calavera.jpg");
        
        ImageIcon icon = new ImageIcon(skulls.getImage().getScaledInstance(imgskull.getWidth(), imgskull.getHeight(),Image.SCALE_DEFAULT));
        imgskull.setIcon(icon);
        ImageIcon icon1 = new ImageIcon(skulls.getImage().getScaledInstance(imgskull1.getWidth(), imgskull1.getHeight(),Image.SCALE_DEFAULT));
        imgskull.setIcon(icon);
        imgskull1.setIcon(icon1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnleave;
    private javax.swing.JButton btnplayagain;
    private javax.swing.JButton btnshowreply;
    private javax.swing.JButton btntablerating;
    private javax.swing.JLabel imgskull;
    private javax.swing.JLabel imgskull1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtpoints;
    // End of variables declaration//GEN-END:variables
}
