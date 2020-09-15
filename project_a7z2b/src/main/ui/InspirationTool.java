package ui;

import model.MyWardrobe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InspirationTool extends Tool {

    public InspirationTool(MyWardrobe wardrobe, JFrame frame, JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        menu.addSeparator();
        JMenu submenu2 = new JMenu("Inspire me");
        JMenuItem spring = new JMenuItem("spring");
        spring.addActionListener(new InspirationSpringTool());
        submenu2.add(spring);
        JMenuItem summer = new JMenuItem("summer");
        summer.addActionListener(new InspirationSummerTool());
        submenu2.add(summer);
        JMenuItem fall = new JMenuItem("fall");
        fall.addActionListener(new InspirationFallTool());
        submenu2.add(fall);
        JMenuItem winter = new JMenuItem("winter");
        winter.addActionListener(new InspirationWinterTool());
        submenu2.add(winter);
        menu.add(submenu2);

    }

    //EFFECT: inspiration function
    private class InspirationSpringTool implements ActionListener {
        ImageIcon icon = new ImageIcon(new ImageIcon("./data/IMG_5522.JPG").getImage().getScaledInstance(
                300, 400, Image.SCALE_DEFAULT));

        @Override
        public void actionPerformed(ActionEvent e) {
            wardrobe.produceNewOutfits("spring");
            if (!wardrobe.produceNewOutfits("spring")) {
                JOptionPane.showMessageDialog(frame, "Sorry, your clothing is not enough--but we still have some ideas",
                        "Sorry", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(frame, wardrobe.getTempWardrobe());
            }
        }
    }

    //EFFECT: inspiration function
    private class InspirationSummerTool implements ActionListener {
        ImageIcon icon = new ImageIcon(new ImageIcon("./data/IMG_5753.JPG").getImage().getScaledInstance(
                200, 400, Image.SCALE_DEFAULT));

        @Override
        public void actionPerformed(ActionEvent e) {
            wardrobe.produceNewOutfits("summer");
            if (!wardrobe.produceNewOutfits("summer")) {
                JOptionPane.showMessageDialog(frame, "Sorry, your clothing is not enough--but we still have some ideas",
                        "Sorry", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(frame, wardrobe.getTempWardrobe());
            }
        }
    }

    //EFFECT: inspiration function
    private class InspirationFallTool implements ActionListener {
        ImageIcon icon = new ImageIcon(new ImageIcon("./data/IMG_5526.JPG").getImage().getScaledInstance(
                200, 400, Image.SCALE_DEFAULT));

        @Override
        public void actionPerformed(ActionEvent e) {
            wardrobe.produceNewOutfits("fall");
            if (!wardrobe.produceNewOutfits("fall")) {
                JOptionPane.showMessageDialog(frame, "Sorry, your clothing is not enough--but we still have some ideas",
                        "Sorry", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(frame, wardrobe.getTempWardrobe());
            }
        }
    }

    //EFFECT: inspiration function
    private class InspirationWinterTool implements ActionListener {
        ImageIcon icon = new ImageIcon(new ImageIcon("./data/IMG_5752.JPG").getImage().getScaledInstance(
                300, 400, Image.SCALE_DEFAULT));

        @Override
        public void actionPerformed(ActionEvent e) {
            wardrobe.produceNewOutfits("winter");
            if (!wardrobe.produceNewOutfits("winter")) {
                JOptionPane.showMessageDialog(frame, "Sorry, your clothing is not enough--but we still have some ideas",
                        "Sorry", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(frame, wardrobe.getTempWardrobe());
            }
        }
    }
}

