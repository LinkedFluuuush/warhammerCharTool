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
    private JComboBox<String> comboRace;
    private JComboBox<String> comboCareer;
    private JTextArea nameArea;
    private CharacterPanel characterPanel;

    public createCharacterAL(JComboBox<String> comboRace, JComboBox<String> comboCareer, JTextArea nameArea, CharacterPanel characterPanel) {
        this.comboRace = comboRace;
        this.comboCareer = comboCareer;
        this.nameArea = nameArea;
        this.characterPanel = characterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String race = (String)comboRace.getSelectedItem();
        String career = (String)comboCareer.getSelectedItem();
        String name = nameArea.getText();

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
