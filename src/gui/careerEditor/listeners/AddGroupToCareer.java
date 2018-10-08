package gui.careerEditor.listeners;

import core.World;
import core.characteristics.Career;
import gui.ComboboxToolTipRenderer;
import gui.careerEditor.CareerEditorPanel;
import gui.careerEditor.CareerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddGroupToCareer implements ActionListener {
    private String type;
    private CareerEditorPanel careerEditorPanel;

    public AddGroupToCareer(String type, CareerEditorPanel careerEditorPanel) {
        this.type = type;
        this.careerEditorPanel = careerEditorPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> addable = new LinkedList<>();
        switch (type){
            case "skill":
                addable = new LinkedList<>(World.SKILLS.keySet());
                break;
            case "talent":
                addable = new LinkedList<>(World.TALENTS.keySet());
                break;
            case "weapon":
                addable = new LinkedList<>(World.WEAPONS.keySet());
                break;
            case "armour":
                addable = new LinkedList<>(World.ARMOURS.keySet());
                break;
            case "equipment":
                addable = new LinkedList<>(World.EQUIPMENTS.keySet());
                break;
            default:
                break;
        }

        Container container = careerEditorPanel.getParent();

        while (container.getClass() != CareerFrame.class){
            container = container.getParent();
        }

        LinkedList<String> selectedGroup = new LinkedList<>();

        JFrame frame = (JFrame) container;

        JDialog dialog = new JDialog(frame,"Sélection de groupe", true);
        Container contentPane = dialog.getContentPane();

        /* Panels */
        JPanel choicePane = new JPanel();
        choicePane.setLayout(new BoxLayout(choicePane, BoxLayout.LINE_AXIS));
        choicePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        JPanel selectedPanel = new JPanel();
        selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.PAGE_AXIS));
        selectedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JScrollPane scrollPane = new JScrollPane(selectedPanel);
        scrollPane.setPreferredSize(new Dimension(100, 100));

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        /* Selection elements */
        JComboBox<String> comboBox = new JComboBox<>();

        Collections.sort(addable);
        for(String toAdd : addable) {
            comboBox.addItem(toAdd);
        }

        JButton plusButton = new JButton("Ajouter");
        plusButton.addActionListener(e12 -> {
            selectedGroup.add(String.valueOf(comboBox.getSelectedItem()));
            selectedPanel.add(new JLabel(String.valueOf(comboBox.getSelectedItem())));
            selectedPanel.revalidate();
        });

        JButton cancelButton = new JButton("Annuler");
        JButton saveButton = new JButton("Valider");

        /* Buttons */
        cancelButton.addActionListener(e1 -> dialog.dispose());

        saveButton.addActionListener(e1 -> {
            LinkedList<LinkedList<String>> finalList = new LinkedList<>();

            switch (type){
                case "skill":
                    finalList = careerEditorPanel.getCareer().getSkills();
                    break;
                case "talent":
                    finalList = careerEditorPanel.getCareer().getTalents();
                    break;
                case "weapon":
                    finalList = careerEditorPanel.getCareer().getWeapons();
                    break;
                case "armour":
                    finalList = careerEditorPanel.getCareer().getArmours();
                    break;
                case "equipment":
                    finalList = careerEditorPanel.getCareer().getEquipments();
                    break;
                default:
                    break;
            }

            finalList.add(selectedGroup);

            careerEditorPanel.applyProfile();
            careerEditorPanel.emptyElements();
            careerEditorPanel.applyCareer();
            careerEditorPanel.revalidate();
            careerEditorPanel.repaint();
            dialog.dispose();
        });

        buttonPane.add(Box.createHorizontalGlue());
        choicePane.add(comboBox);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        choicePane.add(plusButton);

        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(cancelButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(saveButton);

        contentPane.add(choicePane, BorderLayout.PAGE_START);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.PAGE_END);

        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);

    }
}
