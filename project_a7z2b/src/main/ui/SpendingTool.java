package ui;

import model.MyWardrobe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpendingTool extends Tool {
    JMenuItem spending;

    public SpendingTool(MyWardrobe wardrobe, JFrame frame, JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        spending = new JMenuItem("Money spending");
        menu.add(spending);
        spending.addActionListener(new Listener());
    }


    //EFFECT: record the monthly spending and total spending
    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 12; i++) {
                output.append((i + 1) + " ");
                output.append((wardrobe.getMonthlySpending(i)) + " ");
                if (i == 6) {
                    output.append("\n");
                }
            }
            output.append("total value of your wardrobe is: " + (wardrobe.getTotalSpending()));
        }
    }
}

