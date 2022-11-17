/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zsnails.GameCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.JButton;

import com.zsnails.Registro.Registro;
import com.zsnails.game.iCentroJuego;
import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;
import com.zsnails.player.Player;

/**
 *
 * @author omega
 */
public class GameCenter extends javax.swing.JFrame implements iCentroJuego {

    private static GameCenter instance = null;

    /**
     * Creates the initial GameCenter instance
     * 
     * @param jugador The player
     * @param juegos  The games list
     */
    public static void makeInstance(final iJugador jugador, final iJuego... juegos) {
        if (instance == null)
            instance = new GameCenter(jugador, juegos);
    }

    /**
     * Returns the GameCenter instance
     * 
     * @return The GameCenter instance
     * @throws InvalidObjectException
     */
    public static GameCenter getInstance() throws InvalidObjectException {
        if (instance == null)
            throw new InvalidObjectException("the singleton must first be created with 'makeInstance'");
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGame1;
    private javax.swing.JButton btnGame2;
    private javax.swing.JButton btnGame3;
    private javax.swing.JButton btnStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form GameCenter
     */
    private ArrayList<iJuego> juegos = new ArrayList<>();

    private List<iJugador> jugadores = new ArrayList<>();

    private iJugador jugador = null;

    private JButton[] btns;

    private List<iRegistro> registros = new ArrayList<>();

    private GameCenter(final iJugador jugador, final iJuego... juegos) {
        this.initComponents();
        this.btns = new JButton[] { btnGame1, btnGame2, btnGame3 };
        for (final iJuego j : juegos)
            this.juegos.add(j);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.loadGames();

        // this.cargarJugadores();
        // this.cargarRegistros();

        this.jugador = jugador;

    }

    @Override
    public ArrayList<iRegistro> getRegistros(final iJuego tipoJuego) {
        return new ArrayList<iRegistro>(
                this.registros.stream().filter((r) -> ((Registro) (r)).getJuego().getClass() == tipoJuego.getClass())
                        .toList());
    }

    @Override
    public ArrayList<iJuego> getJuegosDisponibles() {
        // TODO Auto-generated method stub
        return this.juegos;
    }

    @Override
    public void addRegistro(final iRegistro registro) {
        this.registros.add(registro);
        try {
            this.almacenarRegistros();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the top 10 scores of all games
     * 
     * @return
     */
    public List<iRegistro> getTop10() {
        return this.registros.stream().sorted((a, b) -> compare(a, b)).limit(10)
                .toList();
    }

    /**
     * Gets the top 10 scores of a given user
     * 
     * @param user
     * @return
     */
    public List<iRegistro> getTop10(iJugador user) {
        if (user == null)
            return null;
        return this.registros.stream().filter((r) -> {
            if (r.getJugador() == null)
                return false;
            return user.getNombre().compareTo(r.getJugador().getNombre()) == 0;
        }).sorted((a, b) -> compare(a, b)).limit(10).toList();
    }

    /**
     * Gets the top 10 of a given game
     * 
     * @param game
     * @return
     */
    public List<iRegistro> getTop10(iJuego game) {
        Stream<iRegistro> porJuego = this.registros.stream().filter((r) -> ((Registro) (r)).getJuego() == game);
        return porJuego.sorted((a, b) -> compare(a, b)).limit(10).toList();
    }

    /**
     * Gets juegos
     * 
     * @return
     */
    public ArrayList<iJuego> getJuegos() {
        return juegos;
    }

    /**
     * Sets juegos
     * 
     * @param juegos
     */
    public void setJuegos(final ArrayList<iJuego> juegos) {
        this.juegos = juegos;
    }

    /**
     * Gets jugador
     * 
     * @return
     */
    public iJugador getJugador() {
        return jugador;
    }

    /**
     * Tries to find a player within the players list
     * 
     * @param nombre The player's name
     * @return
     */
    public iJugador findJugador(String nombre) {
        // System.out.printf("Trying to find player: %s\n", nombre);
        return this.jugadores.stream().filter((j) -> j.getNombre().compareTo(nombre) == 0).findFirst().get();
    }

    /**
     * Sets jugador
     * 
     * @param jugador
     */
    public void setJugador(final iJugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Gets registros
     * 
     * @return
     */
    public List<iRegistro> getRegistros() {
        return registros;
    }

    /**
     * Sets registros
     * 
     * @param registros
     */
    public void setRegistros(final List<iRegistro> registros) {
        this.registros = registros;
    }

    /**
     * Searches for a game within the games list
     * 
     * @param nombre The name of the game
     * @return The game it found
     */
    public iJuego findJuego(String nombre) {
        return this.juegos.stream().filter((j) -> j.getNombre().compareTo(nombre) == 0).findFirst().get();
    }

    /**
     * Loads all records from the records file
     */
    public void cargarRegistros() {
        try {
            final Scanner ss = new Scanner(new File("data.dat"));

            while (ss.hasNextLine()) {
                final Scanner value = new Scanner(ss.nextLine());
                value.useDelimiter(",");

                Registro rr = new Registro();
                while (value.hasNext()) {
                    rr.setInicio(LocalDateTime.parse(value.next()));
                    rr.setFinalizacion(LocalDateTime.parse(value.next()));
                    rr.setPuntaje(value.nextInt());
                    rr.setEstadoFinalizado(value.nextBoolean());
                    String nombreJugador = value.next();
                    rr.setJugador(findJugador(nombreJugador));
                    String nombreJuego = value.next();
                    rr.setJuego(findJuego(nombreJuego));
                }

                this.registros.add(rr);

                value.close();
            }

            ss.close();

        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all players from the players file
     */
    public void cargarJugadores() {
        Map<String, String> cache = new HashMap<>();

        try {
            Scanner pFile = new Scanner(new File("players.dat"));

            while (pFile.hasNextLine()) {
                Scanner line = new Scanner(pFile.nextLine());
                Player p = new Player();

                line.useDelimiter(",");

                String nombre = line.next();
                String contrasena = line.next();

                if (cache.containsKey(nombre)) {
                    continue;
                }

                p.setNombre(nombre);
                p.setContrasena(contrasena);

                this.jugadores.add(p);

                line.close();
            }
            System.out.printf("Finished loading players: %s\n", this.jugadores);

            pFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Players list
     */
    public List<iJugador> getJugadores() {
        return jugadores;
    }

    /**
     * Sets the players list
     * 
     * @param jugadores
     */
    public void setJugadores(List<iJugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Compares 2 records to determine which has more points
     * 
     * @param ra The first record
     * @param rb The second record
     * @return int value
     */
    private int compare(iRegistro ra, iRegistro rb) {
        int a = ra.getPuntaje();
        int b = rb.getPuntaje();

        if (a == b)
            return 0;
        if (a < b)
            return 1;
        return -1;
    }

    /**
     * Loads all games from the games list
     */
    private void loadGames() {
        System.out.println(this.btns);
        for (int i = 0; i < this.juegos.size(); i++) {
            System.out.println(i);
            final iJuego juego = this.juegos.get(i);
            if (juego == null)
                continue;
            this.btns[i].setText(this.juegos.get(i).getNombre());

            this.btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent evt) {
                    juego.iniciarPartida(GameCenter.this.jugador);
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGame1 = new javax.swing.JButton();
        btnGame2 = new javax.swing.JButton();
        btnGame3 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnStats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("CENTRO DE JUEGOS");

        btnGame1.setBackground(new java.awt.Color(204, 204, 204));
        btnGame1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGame2.setBackground(new java.awt.Color(204, 204, 204));
        btnGame2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGame3.setBackground(new java.awt.Color(204, 204, 204));
        btnGame3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setText("Salir");
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnStats.setBackground(new java.awt.Color(204, 204, 204));
        btnStats.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnStats.setText("Estadisticas");
        btnStats.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGame2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(btnGame3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGame2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addComponent(btnGame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGame3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnStats, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStatsActionPerformed
        statsUI stats = new statsUI();
        stats.setVisible(true);
    }// GEN-LAST:event_btnStatsActionPerformed

    private void btnExitActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        // System.exit(0);
        dispose();
    }// GEN-LAST:event_btnExitActionPerformed
     //

    /**
     * Stores all records into the records file
     * 
     * @throws IOException
     */
    private void almacenarRegistros() throws IOException {
        final PrintWriter pw = new PrintWriter(new FileWriter("data.dat"));
        for (int i = 0; i < this.registros.size(); i++) {
            final Registro r = (Registro) this.registros.get(i);
            pw.printf("%s,%s,%d,%b,%s,%s", r.getInicio(), r.getFinalizacion(), r.getPuntaje(),
                    r.getEstadoFinalizado(),
                    r.getJugador().getNombre(), r.getJuego().getNombre());

            if (i != (this.registros.size() - 1)) {
                pw.print("\n");
            }
        }
        pw.flush();
        pw.close();
    }
}
