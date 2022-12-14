/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zsnails.hiddenNumber;

import static javax.swing.JOptionPane.showMessageDialog;

import java.time.LocalDateTime;
import java.util.Random;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;

/**
 *
 * @author omega
 */
public class HiddenNumberGameUI extends javax.swing.JFrame implements iJuego {
    private Random rand = new Random();
    private int attempts = 0;
    private int puntos = 0;
    private int numeroOculto = 0;
    public final int MAX_NUM = 100;

    private iJugador jugador = null;

    /**
     * Creates new form HiddenNumberGameUI
     */
    public HiddenNumberGameUI() {

        initComponents();
        LabelAttempts.setText("0");
        LabelPoints.setText("0");

    }

    private void nuevaPartida() {
        this.numeroOculto = nuevoNumero();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelPoints = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelAttempts = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        btnVerify = new javax.swing.JButton();
        txtExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Jugador:");

        jLabel3.setText("Puntos:");

        jLabel5.setText("Intentos:");

        jLabel7.setText("N??mero:");

        btnVerify.setText("Verificar");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        txtExit.setText("Terminar Partida");
        txtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        25, Short.MAX_VALUE)
                                                                .addComponent(jLabel7,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnVerify,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        89,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(txtNum,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        72, Short.MAX_VALUE)
                                                                                .addGap(145, 176, Short.MAX_VALUE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(LabelName,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtExit)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        41,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(LabelPoints,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        58,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap())))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(LabelAttempts, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelPoints, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(LabelName, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LabelAttempts, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtExitActionPerformed
        // TODO add your handling code here:
        terminarPartida();
        this.dispose();
    }// GEN-LAST:event_txtExitActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
        terminarPartida();
    }// GEN-LAST:event_formWindowClosed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerifyActionPerformed
        int adivinado;

        try {
            adivinado = Integer.valueOf(txtNum.getText());
        } catch (NumberFormatException ex) {
            showMessageDialog(this, "Que le pasa bro?\nSolo n??meros aqu??");
            this.txtNum.setText("");
            return;
        }

        this.attempts++;
        LabelAttempts.setText(String.valueOf(attempts));
        if (this.numeroOculto == adivinado) {
            // TODO: incrementar los puntos de la partida y al final de todo registrarlos
            // en el perfil del usuario

            this.puntos++;
            LabelPoints.setText(String.valueOf(this.puntos));

            nuevaPartida();
            showMessageDialog(this, "Yessir ????\nPuntaco");
        } else {
            showMessageDialog(this, "N??o n??o amig??o (^///^)\nNo puntaco\nPista: el n??mero "
                    + ((adivinado > this.numeroOculto) ? "es menor" : "es mayor"));
        }

        this.txtNum.setText("");

    }// GEN-LAST:event_btnVerifyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAttempts;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPoints;
    private javax.swing.JButton btnVerify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtExit;
    private javax.swing.JTextField txtNum;

    // End of variables declaration//GEN-END:variables
    private int nuevoNumero() {
        return rand.nextInt(MAX_NUM);
    }

    @Override
    public void iniciarPartida(iJugador jugador) {
        this.jugador = jugador;
        this.numeroOculto = nuevoNumero();
        // NOTE: removed this due to startDate never being read

        // this.startDate = LocalDateTime.now();

        LabelName.setText(jugador.getNombre());
        this.setVisible(true);

        showMessageDialog(this, "Bienvenid@ " + jugador.getNombre());
    }

    @Override
    public void terminarPartida() {
        this.jugador.registrarPuntaje(this.puntos, this);
        this.puntos = 0;
        this.attempts = 0;
    }

    @Override
    public String getNombre() {
        return "Hidden Number";
    }

    @Override
    public String getDescripcion() {
        return "algo breve";
    }

}
