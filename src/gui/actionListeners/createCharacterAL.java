package gui.actionListeners;

import core.characteristics.Career;
import core.characteristics.Race;
import core.entities.Character;
import gui.CharacterPanel;
import gui.CreateCharacterPanel;

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
    private CreateCharacterPanel createCharacterPanel;

    public createCharacterAL(JComboBox<Race> comboRace, JComboBox<Career> comboCareer, CreateCharacterPanel createCharacterPanel) {
        this.comboRace = comboRace;
        this.comboCareer = comboCareer;
        this.createCharacterPanel = createCharacterPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Race race = (Race)comboRace.getSelectedItem();
        Career career = (Career)comboCareer.getSelectedItem();

        Character character = new Character(race, career);

        CharacterPanel characterPanel = (CharacterPanel)createCharacterPanel.getParent();

        characterPanel.setCharacter(character);
        characterPanel.applyCharacter();
    }
}
