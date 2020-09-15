package ui;

import model.MyWardrobe;

import javax.swing.*;

// abstract Tool class to create the menuitems and implement functions
public abstract class Tool {
    protected JFrame frame;
    protected MyWardrobe wardrobe;
    protected JMenu menu;
    protected JTextArea output;

    public Tool(MyWardrobe wardrobe, JFrame frame, JTextArea output) {
        this.wardrobe = wardrobe;
        this.frame = frame;
        this.output = output;
        this.menu = new JMenu("A Menu");
        createItem(menu);
    }

    // EFFECTS: creates menu items to activate tool
    protected abstract void createItem(JMenu menu);

}
