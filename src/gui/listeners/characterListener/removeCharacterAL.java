package gui.listeners.characterListener;

import gui.CharacterPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 23:42
 */
public class removeCharacterAL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CharacterPanel characterPanel = (CharacterPanel)((JButton)e.getSource()).getParent();
        characterPanel.setPreviousCharacter(characterPanel.getCharacter());
        characterPanel.setCharacter(null);
        characterPanel.applyCharacter();

        JTabbedPane tabbedPane = (JTabbedPane)characterPanel.getParent().getParent();
        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "New Character");

    }
}
