package ui;

import model.MyWardrobe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTool extends Tool {

    public SearchTool(MyWardrobe wardrobe, JFrame frame,JTextArea output) {
        super(wardrobe, frame,output);
    }

    @Override
    protected void createItem(JMenu menu) {
        menu.addSeparator();
        JMenu submenu1 = new JMenu("Filter by...");
        JMenuItem season = new JMenuItem("season");
        season.addActionListener(new SearchSeasonTool());
        submenu1.add(season);
        JMenuItem brand = new JMenuItem("brand");
        brand.addActionListener(new SearchToolListener());
        submenu1.add(brand);
        JMenuItem color = new JMenuItem("color");
        color.addActionListener(new SearchToolListener());
        submenu1.add(color);
        JMenuItem type = new JMenuItem("type");
        type.addActionListener(new SearchToolListener());
        submenu1.add(type);
        JMenuItem date = new JMenuItem("date");
        date.addActionListener(new SearchDateTool());
        submenu1.add(date);
        menu.add(submenu1);
    }


    //EFFECT: search season function
    private class SearchSeasonTool extends Component implements ActionListener {
        Object[] seasons = {"spring", "summer", "fall", "winter"};

        @Override
        public void actionPerformed(ActionEvent e) {
            String sc = (String) JOptionPane.showInputDialog(
                    frame,
                    "Choose a season",
                    "Season",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    seasons,
                    "Spring");
            wardrobe.search(sc);
            output.append(wardrobe.getTempWardrobe());
            if (wardrobe.getTempWardrobe() == "") {
                JOptionPane.showMessageDialog(frame, "No result");
            }
        }
    }

    //EFFECT: Searching function
    private class SearchToolListener extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = new JLabel("condition: ");
            JTextField textField = new JTextField(15);
            JPanel myPanel = new JPanel();
            myPanel.add(label);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(textField);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter ", JOptionPane.OK_CANCEL_OPTION);
            wardrobe.search(textField.getText());
            output.append(wardrobe.getTempWardrobe());
            if (wardrobe.getTempWardrobe() == "") {
                JOptionPane.showMessageDialog(frame, "No result");
            }
        }
    }

    //EFFECT: search date function
    private class SearchDateTool extends JFrame implements ActionListener {
        Object[] dates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        @Override
        public void actionPerformed(ActionEvent e) {
            int sc = (int) JOptionPane.showInputDialog(
                    frame,
                    "Choose a month",
                    "Month",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    dates,
                    "1");
            wardrobe.searchDate(sc);
            output.append(wardrobe.getTempWardrobe());
            if (wardrobe.getTempWardrobe() == "") {
                JOptionPane.showMessageDialog(frame, "No result");
            }
        }
    }

}

