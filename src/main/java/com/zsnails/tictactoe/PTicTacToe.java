/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zsnails.tictactoe;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author omega
 */
public class PTicTacToe extends JPanel implements ActionListener, iJuego {

    private int turn = 0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10; // botón de salir

    private JButton[] board = { jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8,
            jButton9 };

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;

    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form PTicTacToe
     */
    public PTicTacToe() {
        initComponents();
    }

    public void actionPerformed(ActionEvent evt) {
        turn++;
        for (JButton b : board) {
            if (evt.getSource() == b) {
                b.setText("dog");
                b.setEnabled(false);
            }
        }

        if (turn == 9) {
            System.out.println("dog");
        }
    }

    private void makeList() {
        for (JButton b : board) {
            b.addActionListener(this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        // jButton3.addActionListener(new java.awt.event.ActionListener() {
        // jButton3ActionPerformed(evt);
        // }
        // });

        jButton7.setMaximumSize(new java.awt.Dimension(60, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(60, 30));

        jLabel1.setText("JUGADOR");

        jLabel3.setText("PUNTOS");

        jButton10.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addGap(98, 98, 98))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton10,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                        .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(
                                                                                                                jButton4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                80,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(
                                                                                                                jButton7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                80,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout
                                                                                                        .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(
                                                                                                                        jButton8,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        80,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18,
                                                                                                                        18,
                                                                                                                        18)
                                                                                                                .addComponent(
                                                                                                                        jButton9,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        80,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(
                                                                                                                        jButton5,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        80,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18,
                                                                                                                        18,
                                                                                                                        18)
                                                                                                                .addComponent(
                                                                                                                        jButton3,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        80,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        80,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton2,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        80,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton6,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        80,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel4,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        54, Short.MAX_VALUE)
                                                                                .addGap(220, 220, 220)
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        67,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(24, 24, 24)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
                                        Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void iniciarPartida(iJugador jugador) {
        makeList();
        // TODO: inicializar todo lo demás xd
    }

    @Override
    public void terminarPartida() {
        // TODO: validar de que forma se terminó la partida
        // TODO: ok
    }

    @Override
    public String getNombre() {
        return "Tic Tac Toe";
    }

    @Override
    public String getDescripcion() {
        return "Juego de tic tac toe sencillo, no espere mucho profe";
    }

}
