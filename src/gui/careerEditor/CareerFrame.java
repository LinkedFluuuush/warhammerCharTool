package gui.careerEditor;

import core.World;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class CareerFrame extends JFrame {
    public CareerFrame(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addAllPanels();
    }

    private void addAllPanels() {
        Container contentPanel = this.getRootPane().getContentPane();
        contentPanel.add(new CareerEditorPanel());
    }

    public static void main(String[] args){
        World.loadAll();

        CareerFrame mainFrame = new CareerFrame("");

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }

}
