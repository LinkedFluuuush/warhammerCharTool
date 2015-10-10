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
    private CharacterPanel characterPanel;

    public createCharacterAL(CharacterPanel characterPanel) {
        this.characterPanel = characterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String race = (String)this.characterPanel.getComboRace().getSelectedItem();
        String career = (String)this.characterPanel.getComboCareer().getSelectedItem();
        String name = this.characterPanel.getNameArea().getText();

        String caracs[] = {}

        Character character = new Character(name, "NPC", race, career, "NPC");

        characterPanel.setCharacter(character);
        characterPanel.applyCharacter();

        JTabbedPane tabbedPane = (JTabbedPane)characterPanel.getParent();
        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), characterPanel.getCharacter().getName() + " - " + characterPanel.getCharacter().getRace()
                + " " + characterPanel.getCharacter().getCareer());
    }
}
