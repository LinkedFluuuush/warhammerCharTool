package gui.actionListeners;

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
        CharacterPanel characterPanel = (CharacterPanel)((JPanel)((JButton)e.getSource()).getParent()).getParent();
        characterPanel.setCharacter(null);
        characterPanel.applyCharacter();
    }
}
