package gui;

import core.entities.Character;

import javax.swing.*;
import java.awt.*;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 13:09
 */
public class CharacterPanel extends JPanel {
    private Character character;

    public CharacterPanel(Character character){
        super();

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.character = character;

        applyCharacter();
    }

    public CharacterPanel(){
        super();

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
        this.removeAll();

        if(this.character == null){
            this.add(new CreateCharacterPanel());
        } else {
            JPanel panel = character.toPanel();
            this.add(panel);
            //this.setPreferredSize(new Dimension(??, 500));
            //TODO : redimensionner l'image de fond
        }

        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g){
        if(this.character == null){

        } else {
            g.drawImage(new ImageIcon("./resources/imgs/OneChar.png").getImage(), 0, 0, null);
        }
    }
}
