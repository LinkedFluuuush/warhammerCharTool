package gui.listeners.characterListener;

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
        String title = "";

        if(characterPanel.getCharacter().getName() != null && !characterPanel.getCharacter().getName().equals("")){
            title += characterPanel.getCharacter().getName() + " - ";
        }

        title += characterPanel.getCharacter().getRace()
                + " " + characterPanel.getCharacter().getCareer();

        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), title);
    }
}
