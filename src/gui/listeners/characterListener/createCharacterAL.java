package gui.listeners.characterListener;

import core.entities.Character;
import core.equipment.Money;
import gui.CharacterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 23:30
 */
public class createCharacterAL implements ActionListener {
    private CharacterPanel characterPanel;
    private boolean creating;

    public createCharacterAL(CharacterPanel characterPanel) {
        this.characterPanel = characterPanel;
        creating = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        characterPanel.emptyElements();

        if(creating) {
            characterPanel.getCharacter().completeCharacter();

            JTabbedPane tabbedPane = (JTabbedPane) characterPanel.getParent();
            String title = "";

            if (characterPanel.getCharacter().getName() != null && !characterPanel.getCharacter().getName().equals("")) {
                title += characterPanel.getCharacter().getName() + " - ";
            }

            title += characterPanel.getCharacter().getRace()
                    + " " + characterPanel.getCharacter().getCareers();

            tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), title);

            this.characterPanel.getCreateCharacterButton().setText("New Character");
            this.creating = false;
        } else {
            characterPanel.setCharacter(new Character());
            JTabbedPane tabbedPane = (JTabbedPane) characterPanel.getParent();
            tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "New character");

            this.characterPanel.getCreateCharacterButton().setText("Generate Character");
            this.creating = true;
        }

        characterPanel.applyCharacter();

    }
}
