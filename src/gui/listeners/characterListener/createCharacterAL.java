package gui.listeners.characterListener;

import core.characteristics.Career;
import core.characteristics.Race;
import core.entities.Character;
import gui.CharacterPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 23:30
 */
public class createCharacterAL implements ActionListener {
    private JComboBox<Race> comboRace;
    private JComboBox<Career> comboCareer;
    private CharacterPanel characterPanel;

    public createCharacterAL(JComboBox<Race> comboRace, JComboBox<Career> comboCareer, CharacterPanel characterPanel) {
        this.comboRace = comboRace;
        this.comboCareer = comboCareer;
        this.characterPanel = characterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String race = (String)comboRace.getSelectedItem();
        String career = (String)comboCareer.getSelectedItem();

        Character character = new Character(race, career);

        characterPanel.setCharacter(character);
        characterPanel.applyCharacter();

        JTabbedPane tabbedPane = (JTabbedPane)characterPanel.getParent().getParent();
        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), characterPanel.getCharacter().getRace()
                + " " + characterPanel.getCharacter().getCareer());
    }
}
