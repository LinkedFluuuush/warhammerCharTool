package gui.listeners;

import core.World;
import gui.CharacterPanel;
import gui.ComboboxToolTipRenderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by LinkedFluuuush on 03/10/2015.
 */
public class updateComboBoxesAL implements ActionListener {
    private final CharacterPanel panel;

    public updateComboBoxesAL(CharacterPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboRace = panel.getComboRace();
        JComboBox<String> comboCareer = panel.getComboCareer();
        JComboBox<String> comboGod = panel.getComboGod();

        panel.emptyElements();

        if(!comboRace.getSelectedItem().equals("")) {
            /* Update gods */
            LinkedList<String> availableGods = World.loadRace((String) comboRace.getSelectedItem()).getWorshipedGods();

            comboGod.removeAllItems();

            ComboboxToolTipRenderer comboGodRenderer = new ComboboxToolTipRenderer();
            Collections.sort(availableGods);
            comboGod.setRenderer(comboGodRenderer);

            LinkedList<String> tooltips = new LinkedList<>();
            String domain;
            LinkedList<String> domains;
            comboGod.addItem("");
            tooltips.add("");
            for (String god : availableGods) {
                domain = "";
                comboGod.addItem(god);
                domains = World.loadGod(god).getDomains();
                for (String aDomain : domains) {
                    domain += aDomain + ", ";
                }
                tooltips.add(domain.substring(0, domain.length() - 2));
            }
            comboGodRenderer.setTooltips(tooltips);

            /* Update careers */
            comboCareer.removeAllItems();

            LinkedList<String> availableCareers = new LinkedList<>(World.CAREERS.keySet());
            Collections.sort(availableCareers);
            for (String careerName : availableCareers) {
                if (World.loadCareer(careerName).getAvailableRaces().contains(comboRace.getSelectedItem())) {
                    comboCareer.addItem(careerName);
                }
            }

            panel.getCreateCharacterButton().setEnabled(true);
        } else {
            comboCareer.removeAllItems();
            comboGod.removeAllItems();
            panel.getCreateCharacterButton().setEnabled(false);
        }
    }
}
