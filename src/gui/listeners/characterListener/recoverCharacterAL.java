package gui.listeners.characterListener;

import gui.CharacterPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 02/12/13
 * Time: 14:43
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class recoverCharacterAL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CharacterPanel characterPanel = (CharacterPanel)((JButton)actionEvent.getSource()).getParent();
        characterPanel.setCharacter(characterPanel.getPreviousCharacter());
        characterPanel.applyCharacter();
    }
}
