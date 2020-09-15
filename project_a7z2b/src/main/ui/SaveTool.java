package ui;

import model.MyWardrobe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SaveTool extends Tool {
    private JMenuItem save;

    public SaveTool(MyWardrobe wardrobe, JFrame frame,JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        save = new JMenuItem("Save my wardrobe");
        menu.add(save);
        save.addActionListener(new Listener());
    }


    //EFFECT: save function
    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                wardrobe.saveMyWardrobe();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(frame, "Your wardrobe is saved successfully!");
        }
    }
}

