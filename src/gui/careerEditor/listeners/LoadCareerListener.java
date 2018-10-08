package gui.careerEditor.listeners;

import core.World;
import gui.careerEditor.CareerEditorPanel;
import gui.careerEditor.CareerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LoadCareerListener implements ActionListener {
    private CareerEditorPanel careerEditorPanel;

    public LoadCareerListener(CareerEditorPanel careerEditorPanel) {
        this.careerEditorPanel = careerEditorPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> loadable = new LinkedList<>(World.CAREERS.keySet());

        Container container = careerEditorPanel.getParent();

        while (container.getClass() != CareerFrame.class){
            container = container.getParent();
        }

        JFrame frame = (JFrame) container;

        JDialog dialog = new JDialog(frame,"Sélection", true);
        Container contentPane = dialog.getContentPane();

        /* Panels */
        JPanel choicePane = new JPanel();
        choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
        choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        /* Selection elements */
        JComboBox<String> comboBox = new JComboBox<>();

        Collections.sort(loadable);
        for(String toAdd : loadable) {
            comboBox.addItem(toAdd);
        }

        JButton cancelButton = new JButton("Annuler");
        JButton saveButton = new JButton("Valider");

        /* Buttons */
        cancelButton.addActionListener(e1 -> dialog.dispose());

        saveButton.addActionListener(e1 -> {
            careerEditorPanel.setCareer(World.loadCareer(String.valueOf(comboBox.getSelectedItem())));
            careerEditorPanel.emptyElements();
            careerEditorPanel.applyCareer();
            careerEditorPanel.revalidate();
            careerEditorPanel.repaint();
            dialog.dispose();
        });

        choicePane.add(comboBox);

        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(cancelButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(saveButton);

        contentPane.add(choicePane, BorderLayout.PAGE_START);
        contentPane.add(buttonPane, BorderLayout.PAGE_END);

        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);

    }
}
