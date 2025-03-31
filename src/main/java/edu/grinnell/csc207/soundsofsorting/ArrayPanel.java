package edu.grinnell.csc207.soundsofsorting;
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
        int spacing = 0;
        for(int i = 0; i < this.notes.arr.length; i++){
            g.fillRect(0, spacing, (int) floor(this.width / this.notes.arr.length), 
                    (int) floor(this.height / this.notes.arr.length) * (1 + notes.arr[i]));
            spacing += (int) floor(this.width / this.notes.arr.length);
        }
    }
}