package edu.grinnell.csc207.soundsofsorting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Math.floor;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    int width;
    int height;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, width, height);
        int spacing = 0;
        for(int i = 0; i < this.notes.arr.length; i++){
            int tmp = (int) floor(this.height / this.notes.arr.length) * (1 + notes.arr[i]);
            int properHeight = this.height - tmp;
            Color lastColor = g.getColor();
            g.setColor(Color.BLACK);
            g.drawRect(spacing, properHeight,
                       (int) floor(this.width / this.notes.arr.length), this.height);
            if(lastColor.equals(Color.BLUE)){
                g.setColor(Color.GREEN);
            } else if(lastColor.equals(Color.GREEN)){
                g.setColor(Color.CYAN);
            } else{
                g.setColor(Color.BLUE);
            }
            g.fillRect(spacing, properHeight,
                       (int) floor(this.width / this.notes.arr.length), this.height);
            spacing += (int) floor(this.width / this.notes.arr.length);
        }
    }
}