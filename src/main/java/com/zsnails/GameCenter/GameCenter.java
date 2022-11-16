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
import java.util.List;
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

    public static void makeInstance(final iJugador jugador, final iJuego... juegos) {
        if (instance == null)
            instance = new GameCenter(jugador, juegos);
    }

    public static GameCenter getInstance() throws InvalidObjectException {
        if (instance == null)
            throw new InvalidObjectException("the singleton must first be created with 'makeInstance'");
        return instance;
    }

    public static void setInstance(final GameCenter instance) {
        GameCenter.instance = instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGame1;
    private javax.swing.JButton btnGame2;
    private javax.swing.JButton btnGame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;

    private List<iJugador> jugadores = new ArrayList<>();

    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form GameCenter
     */
    private ArrayList<iJuego> juegos = new ArrayList<>();

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
        this.cargarJugadores();
        this.cargarRegistros();

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

    public javax.swing.JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(final javax.swing.JButton btnExit) {
        this.btnExit = btnExit;
    }

    public javax.swing.JButton getBtnGame1() {
        return btnGame1;
    }

    public List<iRegistro> getTop10AllGames() {
        return this.registros.stream().sorted((r1, r2) -> r1.getPuntaje() > r2.getPuntaje() ? 1 : -1).limit(10)
                .toList();
    }

    public List<iRegistro> getTop10User(iJugador user) {
        Stream<iRegistro> porUsuario = this.registros.stream().filter((r) -> r.getJugador() == user);
        return porUsuario.sorted((r1, r2) -> r1.getPuntaje() > r2.getPuntaje() ? 1 : -1).limit(10).toList();
    }

    public void setBtnGame1(final javax.swing.JButton btnGame1) {
        this.btnGame1 = btnGame1;
    }

    public javax.swing.JButton getBtnGame2() {
        return btnGame2;
    }

    public void setBtnGame2(final javax.swing.JButton btnGame2) {
        this.btnGame2 = btnGame2;
    }

    public javax.swing.JButton getBtnGame3() {
        return btnGame3;
    }

    public void setBtnGame3(final javax.swing.JButton btnGame3) {
        this.btnGame3 = btnGame3;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(final javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(final javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public ArrayList<iJuego> getJuegos() {
        return juegos;
    }

    public void setJuegos(final ArrayList<iJuego> juegos) {
        this.juegos = juegos;
    }

    public iJugador getJugador() {
        return jugador;
    }

    public iJugador findJugador(String nombre) {
        return this.jugadores.stream().filter((j) -> j.getNombre().compareTo(nombre) == 0).findAny().get();
    }

    public void setJugador(final iJugador jugador) {
        this.jugador = jugador;
    }

    public JButton[] getBtns() {
        return btns;
    }

    public void setBtns(final JButton[] btns) {
        this.btns = btns;
    }

    public List<iRegistro> getRegistros() {
        return registros;
    }

    public void setRegistros(final List<iRegistro> registros) {
        this.registros = registros;
    }

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGame1 = new javax.swing.JButton();
        btnGame2 = new javax.swing.JButton();
        btnGame3 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

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
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        final javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGame2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnGame3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
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
                .addGap(44, 44, 44)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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

    private void btnExitActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }// GEN-LAST:event_btnExitActionPerformed
     //

    public iJuego findJuego(String nombre) {
        return this.juegos.stream().filter((j) -> j.getNombre().compareTo(nombre) == 0).findFirst().get();
    }

    private void cargarRegistros() {
        try {
            final Scanner ss = new Scanner(new File("data.dat"));

            // ss.useDelimiter("|");

            while (ss.hasNextLine()) {
                final Scanner value = new Scanner(ss.nextLine());
                value.useDelimiter(",");

                Registro rr = new Registro();
                // inicio, finalizacion, int puntaje, boolean estadoFinalizado,
                // iJugador jugador, iJuego juego
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

    private void cargarJugadores() {

        try {
            Scanner pFile = new Scanner(new File("players.dat"));

            while (pFile.hasNextLine()) {
                Scanner line = new Scanner(pFile.nextLine());
                Player p = new Player();

                line.useDelimiter(",");
                while (line.hasNext()) {
                    p.setNombre(line.next());
                    p.setContrasena(line.next());
                }

                this.jugadores.add(p);

                line.close();
            }

            pFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
