package gui;

import core.World;
import core.characteristics.Career;
import core.characteristics.Race;
import gui.listeners.characterListener.createCharacterAL;

import javax.swing.*;

/**
 * User: Linked
 * Date: 24/11/13
 * Time: 23:23
 */
public class CreateCharacterPanel extends JPanel {
    public CreateCharacterPanel(){
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JComboBox<Race> comboRace = new JComboBox<Race>();

        for(Race r : World.RACES){
            comboRace.addItem(r);
        }

        JComboBox<Career> comboCareer = new JComboBox<Career>();

        for(Career c : World.CAREERS){
            comboCareer.addItem(c);
        }

        this.add(comboRace);
        this.add(comboCareer);

        JButton create = new JButton("Créer un nouveau personnage");

        create.addActionListener(new createCharacterAL(comboRace, comboCareer, this));

        this.add(create);
    }
}
