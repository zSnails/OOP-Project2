/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsnails.hangmanGame;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InvalidObjectException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.Registro.Registro;
import com.zsnails.game.iCentroJuego;
import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

/**
 * Class Graphical interface for the Hangman game
 * 
 * @author omega
 */
public class HangmanGameUI extends JFrame implements iJuego {

    /**
     * It generates a random number between 3 and 13, and then creates an array of
     * underscores of that
     * size
     * 
     * @return The underscores are being returned.
     */
    protected static char[] gen_underscores() {

        final Random ran = new Random();

        final int nLetters = 3 + ran.nextInt((13 - 3) + 1);
        System.out.println(nLetters);
        final char[] underscores = new char[nLetters];
        for (int i = 0; i < underscores.length; i++) {
            underscores[i] = '_';
        }
        return underscores;

    }
    protected ArrayList<String> words_list = new ArrayList<String>();
    char[] array_underscores;
    private iJugador player = null;
    private int points = 0;
    private int attempts = 0;
    protected LocalDateTime startDate;
    protected String hiddenWord;
    private boolean hardReset = false;

    private iCentroJuego gameCenter;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;

    private javax.swing.JButton btnB;

    private javax.swing.JButton btnC;

    private javax.swing.JButton btnD;

    private javax.swing.JButton btnE;

    private javax.swing.JButton btnExit;

    private javax.swing.JButton btnF;

    private javax.swing.JButton btnG;

    private javax.swing.JButton btnH;

    private javax.swing.JButton btnI;

    private javax.swing.JButton btnJ;

    private javax.swing.JButton btnK;

    private javax.swing.JButton btnL;

    private javax.swing.JButton btnM;

    private javax.swing.JButton btnN;

    private javax.swing.JButton btnN2;

    private javax.swing.JButton btnO;

    private javax.swing.JButton btnP;

    private javax.swing.JButton btnQ;

    private javax.swing.JButton btnR;

    private javax.swing.JButton btnS;

    private javax.swing.JButton btnT;

    private javax.swing.JButton btnU;

    private javax.swing.JButton btnV;

    private javax.swing.JButton btnW;

    private javax.swing.JButton btnX;

    private javax.swing.JButton btnY;

    private javax.swing.JButton btnZ;

    private javax.swing.JLabel imgscrag;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JLabel txtprintname;

    private javax.swing.JLabel txtprintrecord;

    private javax.swing.JLabel txtword;

    /**
     * constructor
     */
    public HangmanGameUI() {
        // super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public boolean isHardReset() {
        return hardReset;
    }

    /**
     * Set HardReset status
     * 
     * @param hardReset
     */
    public void setHardReset(final boolean hardReset) {
        this.hardReset = hardReset;
    }

    /**
     * It returns a new object of type Registro, which is a class that stores the
     * start date, end date,
     * points, hardReset, player, and the current instance of the class
     * 
     * @param hardReset boolean
     * @return A new instance of the class Registro.
     */
    public Registro getScore(final boolean hardReset) {
        return new Registro(this.startDate, LocalDateTime.now(), this.points, hardReset, player, this);
    }

    @Override
    // Initializing the game.
    /**
     * 
     */
    public void iniciarPartida(final iJugador jugador) {
        this.player = jugador;
        try {
            this.gameCenter = GameCenter.getInstance();
        } catch (final InvalidObjectException e) {
            e.printStackTrace();
        }

        array_underscores = gen_underscores();
        startDate = LocalDateTime.now();
        showvalues();
        showImage();
        hardReset = false;
        hiddenWord = gen_word();
        printUnderscores(array_underscores);
        this.setVisible(true);
        showMessageDialog(this, "Bienvenid@ " + jugador.getNombre());

    }

    @Override
    /**
     * 
     */
    public void terminarPartida() {
        final Registro score = this.getScore(this.hardReset);
        this.player.registrarPuntaje(this.points, this);
        this.points = 0;
        this.attempts = 0;
        words_list = new ArrayList<String>();
        this.player.registrarPuntaje(score.getPuntaje(), this);
        this.gameCenter.addRegistro(score);
        enableButtons();
    }

    // public static void main(String args[]) {
    // /* Set the Nimbus look and feel */
    // // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // // (optional) ">
    // /*
    // * If Nimbus (introduced in Java SE 6) is not available, stay with the default
    // * look and feel.
    // * For details see
    // * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    // */
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(HangmanGameUI.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(HangmanGameUI.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(HangmanGameUI.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(HangmanGameUI.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // }
    // // </editor-fold>
    // // </editor-fold>
    // // </editor-fold>
    // // </editor-fold>

    // /* Create and display the dialog */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // HangmanGameUI dialog = new HangmanGameUI(new javax.swing.JDialog(), true);
    // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    // @Override
    // public void windowClosing(java.awt.event.WindowEvent e) {
    // System.exit(0);
    // }
    // });
    // dialog.setVisible(true);
    // }
    // });
    // }

    /**
     * 
     * @return
     */
    @Override
    public String getNombre() {
        return "HangMan Game";
    }
    /**
     * 
     * @return
     */
    @Override
    public String getDescripcion() {
        return "Juego de adivinar la palabra oculta";
    }
    public ArrayList<String> getWords_list() {
		return words_list;
	}
    public void setWords_list(final ArrayList<String> words_list) {
		this.words_list = words_list;
	}
    public char[] getArray_underscores() {
		return array_underscores;
	}
    public void setArray_underscores(final char[] array_underscores) {
		this.array_underscores = array_underscores;
	}
    public iJugador getPlayer() {
		return player;
	}
    public void setPlayer(final iJugador player) {
		this.player = player;
	}
    public int getPoints() {
		return points;
	}
    public void setPoints(final int points) {
		this.points = points;
	}
    public int getAttempts() {
		return attempts;
	}
    public void setAttempts(final int attempts) {
		this.attempts = attempts;
	}
    public LocalDateTime getStartDate() {
		return startDate;
	}
    public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}
    public String getHiddenWord() {
		return hiddenWord;
	}
    public void setHiddenWord(final String hiddenWord) {
		this.hiddenWord = hiddenWord;
	}
    public iCentroJuego getGameCenter() {
		return gameCenter;
	}
    public void setGameCenter(final iCentroJuego gameCenter) {
		this.gameCenter = gameCenter;
	}
    public javax.swing.JButton getBtnA() {
		return btnA;
	}
    public void setBtnA(final javax.swing.JButton btnA) {
		this.btnA = btnA;
	}
    public javax.swing.JButton getBtnB() {
		return btnB;
	}
    public void setBtnB(final javax.swing.JButton btnB) {
		this.btnB = btnB;
	}
    public javax.swing.JButton getBtnC() {
		return btnC;
	}
    public void setBtnC(final javax.swing.JButton btnC) {
		this.btnC = btnC;
	}
    public javax.swing.JButton getBtnD() {
		return btnD;
	}
    public void setBtnD(final javax.swing.JButton btnD) {
		this.btnD = btnD;
	}
    public javax.swing.JButton getBtnE() {
		return btnE;
	}
    public void setBtnE(final javax.swing.JButton btnE) {
		this.btnE = btnE;
	}
    public javax.swing.JButton getBtnExit() {
		return btnExit;
	}
    public void setBtnExit(final javax.swing.JButton btnExit) {
		this.btnExit = btnExit;
	}
    public javax.swing.JButton getBtnF() {
		return btnF;
	}
    public void setBtnF(final javax.swing.JButton btnF) {
		this.btnF = btnF;
	}
    public javax.swing.JButton getBtnG() {
		return btnG;
	}
    public void setBtnG(final javax.swing.JButton btnG) {
		this.btnG = btnG;
	}
    public javax.swing.JButton getBtnH() {
		return btnH;
	}

    public void setBtnH(final javax.swing.JButton btnH) {
		this.btnH = btnH;
	}

    public javax.swing.JButton getBtnI() {
		return btnI;
	}

    public void setBtnI(final javax.swing.JButton btnI) {
		this.btnI = btnI;
	}

    public javax.swing.JButton getBtnJ() {
		return btnJ;
	}

    public void setBtnJ(final javax.swing.JButton btnJ) {
		this.btnJ = btnJ;
	}

    public javax.swing.JButton getBtnK() {
		return btnK;
	}

	public void setBtnK(final javax.swing.JButton btnK) {
		this.btnK = btnK;
	}

	public javax.swing.JButton getBtnL() {
		return btnL;
	}

	public void setBtnL(final javax.swing.JButton btnL) {
		this.btnL = btnL;
	}

	public javax.swing.JButton getBtnM() {
		return btnM;
	}

	public void setBtnM(final javax.swing.JButton btnM) {
		this.btnM = btnM;
	}

	public javax.swing.JButton getBtnN() {
		return btnN;
	}

	public void setBtnN(final javax.swing.JButton btnN) {
		this.btnN = btnN;
	}

	public javax.swing.JButton getBtnN2() {
		return btnN2;
	}

	public void setBtnN2(final javax.swing.JButton btnN2) {
		this.btnN2 = btnN2;
	}

	public javax.swing.JButton getBtnO() {
		return btnO;
	}

	public void setBtnO(final javax.swing.JButton btnO) {
		this.btnO = btnO;
	}

	public javax.swing.JButton getBtnP() {
		return btnP;
	}

	public void setBtnP(final javax.swing.JButton btnP) {
		this.btnP = btnP;
	}

	public javax.swing.JButton getBtnQ() {
		return btnQ;
	}

	public void setBtnQ(final javax.swing.JButton btnQ) {
		this.btnQ = btnQ;
	}

	public javax.swing.JButton getBtnR() {
		return btnR;
	}

	public void setBtnR(final javax.swing.JButton btnR) {
		this.btnR = btnR;
	}

	public javax.swing.JButton getBtnS() {
		return btnS;
	}

	public void setBtnS(final javax.swing.JButton btnS) {
		this.btnS = btnS;
	}

	public javax.swing.JButton getBtnT() {
		return btnT;
	}

	public void setBtnT(final javax.swing.JButton btnT) {
		this.btnT = btnT;
	}

	public javax.swing.JButton getBtnU() {
		return btnU;
	}

	public void setBtnU(final javax.swing.JButton btnU) {
		this.btnU = btnU;
	}

	public javax.swing.JButton getBtnV() {
		return btnV;
	}

	public void setBtnV(final javax.swing.JButton btnV) {
		this.btnV = btnV;
	}

	public javax.swing.JButton getBtnW() {
		return btnW;
	}

	public void setBtnW(final javax.swing.JButton btnW) {
		this.btnW = btnW;
	}

	public javax.swing.JButton getBtnX() {
		return btnX;
	}

	public void setBtnX(final javax.swing.JButton btnX) {
		this.btnX = btnX;
	}

	public javax.swing.JButton getBtnY() {
		return btnY;
	}

	public void setBtnY(final javax.swing.JButton btnY) {
		this.btnY = btnY;
	}

	public javax.swing.JButton getBtnZ() {
		return btnZ;
	}

	public void setBtnZ(final javax.swing.JButton btnZ) {
		this.btnZ = btnZ;
	}

	public javax.swing.JLabel getImgscrag() {
		return imgscrag;
	}

	public void setImgscrag(final javax.swing.JLabel imgscrag) {
		this.imgscrag = imgscrag;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(final javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public void setjLabel3(final javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(final javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	public javax.swing.JLabel getTxtprintname() {
		return txtprintname;
	}

	public void setTxtprintname(final javax.swing.JLabel txtprintname) {
		this.txtprintname = txtprintname;
	}

	public javax.swing.JLabel getTxtprintrecord() {
		return txtprintrecord;
	}

	public void setTxtprintrecord(final javax.swing.JLabel txtprintrecord) {
		this.txtprintrecord = txtprintrecord;
	}

	public javax.swing.JLabel getTxtword() {
		return txtword;
	}

	public void setTxtword(final javax.swing.JLabel txtword) {
		this.txtword = txtword;
	}

	/**
     * It sets the text of the textview txtprintname to the value of the player's
     * name and the text of the
     * textview txtprintrecord to the value of the points.
     * 
     */
    protected void showvalues() {
        txtprintname.setText(player.getNombre());
        txtprintrecord.setText(String.valueOf(points));

    }

	/**
     * It takes a char array and prints it to a text field
     * 
     * @param underscores the underscores that are printed in the interface
     */
    protected void printUnderscores(final char[] underscores) {
        String wordUnderscores = "";
        for (int i = 0; i < underscores.length; i++) {
            wordUnderscores = wordUnderscores + " " + underscores[i];

        }
        txtword.setText(wordUnderscores);
    }

	/**
     * It reads a file, generates a random number, and returns a word from the file
     * 
     * @return The hidden word is being returned.
     */
    protected String gen_word() {
        // generate the random number and select the hidden word

        read_lettersfile();
        final int min_val = 0;
        final int max_val = words_list.size();
        String hiddenWord = "";

        final int randomnum = (int) (Math.random() * (max_val - min_val));
        System.out.println(randomnum);
        hiddenWord = words_list.get(randomnum);
        System.out.println(hiddenWord);
        return hiddenWord;

    }

	/**
     * It checks if the letter guessed is in the word, if it is, it replaces the
     * underscore with the
     * letter, if not, it changes the image
     * 
     * @param underscores the array of underscores that are shown in the game.
     * @param letter      the letter that the user has guessed
     */
    protected void guessWord(final char[] underscores, final char letter) {

        boolean rightWord = false;
        for (int i = 0; i < this.hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                underscores[i] = letter;
                rightWord = true;
                printUnderscores(underscores);
                points++;
                showvalues();

            }
        }

        if (rightWord == true) {
            if (underscoresON(underscores) == false) {

                final windowwin win = new windowwin(new javax.swing.JDialog(), true);
                points = (points * 100) - (attempts);
                win.setpoints(points);
                dispose();
                terminarPartida();
                win.setVisible(true);
            }
            showvalues();

        } else {
            attempts++;
            changeImage();

        }

    }

	/**
     * It checks if there are underscores in the array
     * 
     * @param underscores the array of characters that the user has guessed so far
     * @return The method is returning a boolean value.
     */
    protected boolean underscoresON(final char[] underscores) {
        // check for underscores
        for (final char l : underscores) {
            if (l == '_')
                return true;
        }
        return false;
    }

	/**
     * Prints the base image on the UI
     * 
     */
    protected void showImage() {
        final ImageIcon scrag = new ImageIcon("src/main/java/com/zsnails/hangmanGame/images/ahorcado1.jpg");

        final ImageIcon icon = new ImageIcon(
                scrag.getImage().getScaledInstance(imgscrag.getWidth(), imgscrag.getHeight(), Image.SCALE_DEFAULT));
        imgscrag.setIcon(icon);
    }

	/**
     * changes the image depending on the number of attempts
     */
    protected void changeImage() {

        if (attempts >= 1) {
            final ImageIcon scrag = new ImageIcon("src/main/java/com/zsnails/hangmanGame/images/ahorcado2.jpg");

            final ImageIcon icon = new ImageIcon(
                    scrag.getImage().getScaledInstance(imgscrag.getWidth(), imgscrag.getHeight(), Image.SCALE_DEFAULT));
            imgscrag.setIcon(icon);
        }
        if (attempts >= 2) {
            final ImageIcon scrag = new ImageIcon("src/main/java/com/zsnails/hangmanGame/images/ahorcado3.jpg");

            final ImageIcon icon = new ImageIcon(
                    scrag.getImage().getScaledInstance(imgscrag.getWidth(), imgscrag.getHeight(), Image.SCALE_DEFAULT));
            imgscrag.setIcon(icon);
        }

        if (attempts >= 4) {
            final ImageIcon scrag = new ImageIcon("src/main/java/com/zsnails/hangmanGame/images/ahorcado4.jpg");
            final ImageIcon icon = new ImageIcon(
                    scrag.getImage().getScaledInstance(imgscrag.getWidth(), imgscrag.getHeight(), Image.SCALE_DEFAULT));
            imgscrag.setIcon(icon);
        }
        if (attempts >= 5) {
            final ImageIcon scrag = new ImageIcon("src/main/java/com/zsnails/hangmanGame/images/ahorcado5.jpg");
            final ImageIcon icon = new ImageIcon(
                    scrag.getImage().getScaledInstance(imgscrag.getWidth(), imgscrag.getHeight(), Image.SCALE_DEFAULT));
            imgscrag.setIcon(icon);
        }
    }

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnA = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnN2 = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtprintname = new javax.swing.JLabel();
        txtprintrecord = new javax.swing.JLabel();
        txtword = new javax.swing.JLabel();
        imgscrag = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(final java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnA.setBackground(new java.awt.Color(51, 204, 255));
        btnA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnA.setText("A");
        btnA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnA.setPreferredSize(new java.awt.Dimension(20, 20));
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnB.setBackground(new java.awt.Color(51, 204, 255));
        btnB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnB.setText("B");
        btnB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnC.setBackground(new java.awt.Color(51, 204, 255));
        btnC.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnC.setText("C");
        btnC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnD.setBackground(new java.awt.Color(51, 204, 255));
        btnD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnD.setText("D");
        btnD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        btnE.setBackground(new java.awt.Color(51, 204, 255));
        btnE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnE.setText("E");
        btnE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnF.setBackground(new java.awt.Color(51, 204, 255));
        btnF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnF.setText("F");
        btnF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnFActionPerformed(evt);
            }
        });

        btnG.setBackground(new java.awt.Color(51, 204, 255));
        btnG.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnG.setText("G");
        btnG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        btnH.setBackground(new java.awt.Color(51, 204, 255));
        btnH.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnH.setText("H");
        btnH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnHActionPerformed(evt);
            }
        });

        btnI.setBackground(new java.awt.Color(51, 204, 255));
        btnI.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnI.setText("I");
        btnI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnIActionPerformed(evt);
            }
        });

        btnJ.setBackground(new java.awt.Color(51, 204, 255));
        btnJ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnJ.setText("J");
        btnJ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnJActionPerformed(evt);
            }
        });

        btnK.setBackground(new java.awt.Color(51, 204, 255));
        btnK.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnK.setText("K");
        btnK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnKActionPerformed(evt);
            }
        });

        btnL.setBackground(new java.awt.Color(51, 204, 255));
        btnL.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnL.setText("L");
        btnL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        btnM.setBackground(new java.awt.Color(51, 204, 255));
        btnM.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnM.setText("M");
        btnM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        btnN.setBackground(new java.awt.Color(51, 204, 255));
        btnN.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnN.setText("N");
        btnN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        btnO.setBackground(new java.awt.Color(51, 204, 255));
        btnO.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnO.setText("O");
        btnO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnOActionPerformed(evt);
            }
        });

        btnP.setBackground(new java.awt.Color(51, 204, 255));
        btnP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnP.setText("P");
        btnP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setBackground(new java.awt.Color(51, 204, 255));
        btnQ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnQ.setText("Q");
        btnQ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnR.setBackground(new java.awt.Color(51, 204, 255));
        btnR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnR.setText("R");
        btnR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnS.setBackground(new java.awt.Color(51, 204, 255));
        btnS.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnS.setText("S");
        btnS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnT.setBackground(new java.awt.Color(51, 204, 255));
        btnT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnT.setText("T");
        btnT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnU.setBackground(new java.awt.Color(51, 204, 255));
        btnU.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnU.setText("U");
        btnU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });

        btnV.setBackground(new java.awt.Color(51, 204, 255));
        btnV.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnV.setText("V");
        btnV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });

        btnW.setBackground(new java.awt.Color(51, 204, 255));
        btnW.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnW.setText("W");
        btnW.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnWActionPerformed(evt);
            }
        });

        btnX.setBackground(new java.awt.Color(51, 204, 255));
        btnX.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnX.setText("X");
        btnX.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btnN2.setBackground(new java.awt.Color(51, 204, 255));
        btnN2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnN2.setText("Ñ");
        btnN2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnN2ActionPerformed(evt);
            }
        });

        btnZ.setBackground(new java.awt.Color(51, 204, 255));
        btnZ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnZ.setText("Z");
        btnZ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnZActionPerformed(evt);
            }
        });

        btnY.setBackground(new java.awt.Color(51, 204, 255));
        btnY.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnY.setText("Y");
        btnY.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jugador:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puntos:");

        txtprintname.setBackground(new java.awt.Color(0, 153, 153));
        txtprintname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtprintname.setForeground(new java.awt.Color(255, 255, 255));

        txtprintrecord.setBackground(new java.awt.Color(0, 153, 153));
        txtprintrecord.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtprintrecord.setForeground(new java.awt.Color(255, 255, 255));

        txtword.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtword.setForeground(new java.awt.Color(255, 255, 255));

        imgscrag.setText("jLabel5");

        btnExit.setBackground(new java.awt.Color(51, 204, 255));
        btnExit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExit.setText("Terminar");
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(imgscrag,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                343,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txtprintname,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        150,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txtprintrecord,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        150,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 78, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnExit,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(txtword, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnH, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnI, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnO, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnK,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnL,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnP,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnN,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnN2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnQ,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnS,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnT,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnV,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnY,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnZ,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnW,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(69, 69, 69)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnH, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnI, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnK, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnN2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnO, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtprintname,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtprintrecord,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(64, 64, 64)
                                                .addComponent(imgscrag, javax.swing.GroupLayout.PREFERRED_SIZE, 333,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(txtword, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
     * 
     * @param evt
     */
    private void btnBActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBActionPerformed
        final char letter = 'B';
        guessWord(array_underscores, letter);
        btnB.setEnabled(false);
    }// GEN-LAST:event_btnBActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnAActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAActionPerformed
        final char letter = 'A';
        guessWord(array_underscores, letter);
        btnA.setEnabled(false);
    }// GEN-LAST:event_btnAActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnCActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCActionPerformed
        final char letter = 'C';
        guessWord(array_underscores, letter);
        btnC.setEnabled(false);
    }// GEN-LAST:event_btnCActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnDActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDActionPerformed
        final char letter = 'D';
        guessWord(array_underscores, letter);
        btnD.setEnabled(false);
    }// GEN-LAST:event_btnDActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnEActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEActionPerformed
        final char letter = 'E';
        guessWord(array_underscores, letter);
        btnE.setEnabled(false);
    }// GEN-LAST:event_btnEActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnFActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFActionPerformed
        final char letter = 'F';
        guessWord(array_underscores, letter);
        btnF.setEnabled(false);
    }// GEN-LAST:event_btnFActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnGActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGActionPerformed
        final char letter = 'G';
        guessWord(array_underscores, letter);
        btnG.setEnabled(false);
    }// GEN-LAST:event_btnGActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnHActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHActionPerformed
        final char letter = 'H';
        guessWord(array_underscores, letter);
        btnH.setEnabled(false);
    }// GEN-LAST:event_btnHActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnIActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnIActionPerformed
        final char letter = 'I';
        guessWord(array_underscores, letter);
        btnI.setEnabled(false);
    }// GEN-LAST:event_btnIActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnJActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnJActionPerformed
        final char letter = 'J';
        guessWord(array_underscores, letter);
        btnJ.setEnabled(false);
    }// GEN-LAST:event_btnJActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnKActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKActionPerformed
        final char letter = 'K';
        guessWord(array_underscores, letter);
        btnK.setEnabled(false);
    }// GEN-LAST:event_btnKActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnLActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLActionPerformed
        final char letter = 'L';
        guessWord(array_underscores, letter);
        btnL.setEnabled(false);
    }// GEN-LAST:event_btnLActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnMActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMActionPerformed
        final char letter = 'M';
        guessWord(array_underscores, letter);
        btnM.setEnabled(false);
    }// GEN-LAST:event_btnMActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnNActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNActionPerformed
        final char letter = 'N';
        guessWord(array_underscores, letter);
        btnN.setEnabled(false);
    }// GEN-LAST:event_btnNActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnN2ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnN2ActionPerformed
        final char letter = 'Ñ';
        guessWord(array_underscores, letter);
        btnN2.setEnabled(false);
    }// GEN-LAST:event_btnN2ActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnOActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOActionPerformed
        final char letter = 'O';
        guessWord(array_underscores, letter);
        btnO.setEnabled(false);
    }// GEN-LAST:event_btnOActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnPActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPActionPerformed
        final char letter = 'P';
        guessWord(array_underscores, letter);
        btnP.setEnabled(false);
    }// GEN-LAST:event_btnPActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnQActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQActionPerformed
        final char letter = 'Q';
        guessWord(array_underscores, letter);
        btnQ.setEnabled(false);
    }// GEN-LAST:event_btnQActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnRActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRActionPerformed
        final char letter = 'R';
        guessWord(array_underscores, letter);
        btnR.setEnabled(false);
    }// GEN-LAST:event_btnRActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnSActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSActionPerformed
        final char letter = 'S';
        guessWord(array_underscores, letter);
        btnS.setEnabled(false);
    }// GEN-LAST:event_btnSActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnTActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTActionPerformed
        final char letter = 'T';
        guessWord(array_underscores, letter);
        btnT.setEnabled(false);
    }// GEN-LAST:event_btnTActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnUActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUActionPerformed
        final char letter = 'U';
        guessWord(array_underscores, letter);
        btnU.setEnabled(false);
    }// GEN-LAST:event_btnUActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnVActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVActionPerformed
        final char letter = 'V';
        guessWord(array_underscores, letter);
        btnV.setEnabled(false);
    }// GEN-LAST:event_btnVActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnWActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnWActionPerformed
        final char letter = 'W';
        guessWord(array_underscores, letter);
        btnW.setEnabled(false);
    }// GEN-LAST:event_btnWActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnXActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXActionPerformed
        final char letter = 'X';
        guessWord(array_underscores, letter);
        btnX.setEnabled(false);
    }// GEN-LAST:event_btnXActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnYActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnYActionPerformed
        final char letter = 'Y';
        guessWord(array_underscores, letter);
        btnY.setEnabled(false);
    }// GEN-LAST:event_btnYActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnZActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnZActionPerformed
        final char letter = 'Z';
        guessWord(array_underscores, letter);
        btnZ.setEnabled(false);
    }// GEN-LAST:event_btnZActionPerformed

	/**
     * 
     * @param evt
     */
    private void btnExitActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExitActionPerformed
        hardReset = true;
        terminarPartida();
        dispose();
    }// GEN-LAST:event_btnExitActionPerformed

	/**
     * 
     * @param evt
     */
    private void formWindowClosed(final java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
        terminarPartida();
        hardReset = true;
    }// GEN-LAST:event_formWindowClosed

	/**
     * It reads a file with words and adds them to an array if they have the same
     * length as the word to
     * be guessed
     */
    private void read_lettersfile() {

        try {
            final BufferedReader bf = new BufferedReader(
                    new FileReader("src/main/java/com/zsnails/hangmanGame/palabras.txt"));

            String bfRead;
            int i = 0;
            while ((bfRead = bf.readLine()) != null) {
                final String word = bfRead.toUpperCase();
                if (word.length() == array_underscores.length) {
                    words_list.add(word);
                }

                i++;

            }
        } catch (final Exception e) {
            System.out.println("NO hay");
        }
    }

	// End of variables declaration//GEN-END:variables
    /**
     * enable all buttons after playing
     */
    private void enableButtons() {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnG.setEnabled(true);
        btnH.setEnabled(true);
        btnI.setEnabled(true);
        btnJ.setEnabled(true);
        btnK.setEnabled(true);
        btnL.setEnabled(true);
        btnM.setEnabled(true);
        btnN.setEnabled(true);
        btnN2.setEnabled(true);
        btnO.setEnabled(true);
        btnP.setEnabled(true);
        btnQ.setEnabled(true);
        btnR.setEnabled(true);
        btnS.setEnabled(true);
        btnT.setEnabled(true);
        btnU.setEnabled(true);
        btnV.setEnabled(true);
        btnW.setEnabled(true);
        btnX.setEnabled(true);
        btnY.setEnabled(true);
        btnZ.setEnabled(true);
    }
}
