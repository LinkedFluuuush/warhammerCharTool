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
        JComboBox<String> comboGod = panel.getComboGod();

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

            panel.getCharacter().setCareers(new LinkedList<>());
            panel.getCharacter().setRace(String.valueOf(comboRace.getSelectedItem()));

            panel.getCreateCharacterButton().setEnabled(true);
        } else {
            panel.getCharacter().setCareers(new LinkedList<>());
            comboGod.removeAllItems();
            panel.getCreateCharacterButton().setEnabled(false);
        }
    }
}
