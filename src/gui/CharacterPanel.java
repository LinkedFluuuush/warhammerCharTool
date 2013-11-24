package gui;

import core.entities.Character;

import javax.swing.*;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 13:09
 */
public class CharacterPanel extends JPanel {
    private Character character;

    public CharacterPanel(Character character){
        super();

        this.character = character;

        applyCharacter();
    }

    public CharacterPanel(){
        super();

        this.character = null;

        applyCharacter();
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void applyCharacter(){
        if(this.character == null){
            this.add(new JButton("Créer un personnage"));
        } else {
            this.add(new JLabel(character.toString()));
        }
    }
}
