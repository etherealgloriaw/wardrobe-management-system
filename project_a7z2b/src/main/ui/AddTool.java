package ui;

import exceptions.OutOfDateException;
import model.Clothing;
import model.MyWardrobe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTool extends Tool {
    private JMenuItem add;

    public AddTool(MyWardrobe wardrobe, JFrame frame, JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        add = new JMenuItem("Add a new clothing");
        menu.add(add);
        add.addActionListener(new Listener());
    }


    //EFFECT: adding function
    private class Listener extends Component implements ActionListener {
        JTextField textField = new JTextField();
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();
        JTextField textField4 = new JTextField();
        JTextField textField5 = new JTextField();
        Object[] message = {
                "Type: ", textField,
                "Season: ", textField1,
                "Brand: ", textField2,
                "Color: ", textField3,
                "Price: ", textField4,
                "Date: ", textField5};


        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, message,
                    "Adding", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                Clothing c = new Clothing(textField.getText(), textField1.getText(),
                        textField3.getText(), textField2.getText(), Integer.parseInt(textField4.getText()),
                        Integer.parseInt(textField5.getText()));
                try {
                    wardrobe.addNewClothing(textField.getText(), textField1.getText(),
                            textField3.getText(), textField2.getText(), Integer.parseInt(textField4.getText()),
                            Integer.parseInt(textField5.getText()));
                    JOptionPane.showMessageDialog(frame, "New clothing is added successfully!");
                    output.append(c.showOneClothing());
                } catch (OutOfDateException ex) {
                    JOptionPane.showMessageDialog(frame, "Please input a date between 1 to 12");
                }

            } else {
                JOptionPane.showMessageDialog(frame, "Adding canceled");
            }
        }
    }
}

