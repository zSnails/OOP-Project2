package com.zsnails.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InvalidObjectException;
import java.time.LocalDateTime;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.Registro.Registro;

public class SnakePanel extends JPanel implements ActionListener {

    public class SKeyAdapter extends KeyAdapter {
        /*
         * (non-Javadoc)
         * 
         * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (direction != 'R')
                        direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (direction != 'L')
                        direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (direction != 'D')
                        direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (direction != 'U')
                        direction = 'D';
                    break;
            }
        }
    }

    private class Apple {
        public int x;
        public int y;

        public Apple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Font monospacedFont = new Font(Font.MONOSPACED, Font.BOLD, 15);

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;

    private int bodyParts = 6;
    private int applesEaten = 0;

    private Apple apple = new Apple(0, 0);

    private char direction = 'R';

    private boolean running = false;

    private Timer timer;

    private GameCenter gameCenter = null;

    private LocalDateTime startDate;

    private Random random;

    private int x[] = new int[GAME_UNITS];
    private int y[] = new int[GAME_UNITS];

    public SnakePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new SKeyAdapter());
    }

    /**
     * Starts the game
     */
    public void startGame() {
        try {
            this.gameCenter = GameCenter.getInstance();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        this.random = new Random();
        this.newApple();
        this.running = true;
        this.timer = new Timer(DELAY, this);
        this.timer.start();

        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.applesEaten = 0;
        this.bodyParts = 3;
        this.direction = 'D';

        this.startDate = LocalDateTime.now();

    }

    /**
     * Gets score
     * 
     * @param hardReset Whether or not the game didn't fully close
     * @return
     */
    public Registro getScore(boolean hardReset) {
        return new Registro(this.startDate, LocalDateTime.now(), this.applesEaten, hardReset, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Draws the main game's graphics
     * 
     * @param g
     */
    public void draw(Graphics g) {
        if (this.running) {
            this.drawGrid(g); // NOTE: optional method call
            g.setColor(Color.GREEN);
            g.fillRect(this.apple.x, this.apple.y, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            // NOTE: draw the current score on screen
            g.setColor(Color.WHITE);
            g.setFont(monospacedFont);
            FontMetrics met = this.getFontMetrics(g.getFont());
            String text = String.format("Puntos: %d", this.applesEaten);
            g.drawString(text, (SCREEN_WIDTH - met.stringWidth(text)) - 30, g.getFont().getSize());

        } else {
            this.gameOver(g);
        }
    }

    /**
     * Creates a new apple
     */
    public void newApple() {
        this.apple.x = this.random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        this.apple.y = this.random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    /**
     * Moves the snake on the screen
     */
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

        }
    }

    /**
     * Checks if the snake ate the apple
     */
    public void appleEaten() {
        if ((x[0] == this.apple.x) && (y[0] == this.apple.y)) {
            this.bodyParts++;
            applesEaten++;
            this.newApple();
        }
    }

    /**
     * Checks if the snake collided with the screen
     */
    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                this.running = false; // NOTE: if this triggers then that means the snake
                // touched itself
            }
        }

        // NOTE: if this triggers then that means the snake has touched a border
        if (x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT)
            this.running = false;

        if (!this.running)
            this.timer.stop();
    }

    /**
     * Shows a game over screen
     * 
     * @param g
     */
    public void gameOver(Graphics g) {
        this.running = false;
        g.setColor(Color.RED);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
        FontMetrics met = this.getFontMetrics(g.getFont());
        String text = "Se Acabó";
        g.drawString(text, (SCREEN_WIDTH - met.stringWidth(text)) / 2, SCREEN_HEIGHT / 2);
        String note = "Su puntaje ha sido guardado";

        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));

        met = this.getFontMetrics(g.getFont());

        g.drawString(note, (SCREEN_WIDTH - met.stringWidth(note)) / 2, (SCREEN_HEIGHT / 2) + 75);
    }

    /**
     * Stops the game
     */
    public void stopGame() {
        this.running = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (this.running) {
            move();
            appleEaten();
            checkCollisions();
        }

        repaint();
    }

    /**
     * Draws a grid on the screen
     * 
     * @param g
     */
    private void drawGrid(Graphics g) {
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
    }

}
