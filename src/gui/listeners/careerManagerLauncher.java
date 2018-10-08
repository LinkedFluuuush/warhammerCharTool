package gui.listeners;

import gui.careerEditor.CareerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class careerManagerLauncher implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CareerFrame careerFrame = new CareerFrame("Career Manager");
        careerFrame.pack();
        careerFrame.setLocationRelativeTo(null);

        careerFrame.setVisible(true);
    }
}
