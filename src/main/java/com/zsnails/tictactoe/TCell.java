package com.zsnails.tictactoe;

import javax.swing.JButton;

public class TCell extends JButton {
    /**
     * The owner of this cell
     */
    private TPlayer owner = TPlayer.NONE;

    private int field;

    /**
     * TODO: esto
     * 
     * @return
     */
    public int getField() {
        return field;
    }

    /**
     * TODO: esto
     * 
     * @param field
     */
    public void setField(final int field) {
        this.field = field;
    }

    /**
     * Updates the owner of the current cell
     * 
     * @param owner
     */
    public void setOwner(final TPlayer owner) {
        this.owner = owner;
    }

    /**
     * Returns the owner of the current cell
     * 
     * @return
     */
    public TPlayer getOwner() {
        return owner;
    }
}
