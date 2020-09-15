package ui;

import exceptions.OutOfDateException;
import model.MyWardrobe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadTool extends Tool {
    private JMenuItem load;

    public LoadTool(MyWardrobe wardrobe, JFrame frame, JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        load = new JMenuItem("Load wardrobe");
        menu.add(load);
        load.addActionListener(new Listener());
    }

    //EFFECT: loading function
    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                wardrobe.loadMyWardrobe();
            } catch (IOException | OutOfDateException ex) {
                ex.printStackTrace();
            }
            output.append(wardrobe.showMyWardrobe());
            if (wardrobe.showMyWardrobe() == null) {
                output.append("your wardrobe is empty!");
            }
        }
    }
}

