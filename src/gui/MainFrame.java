package gui;

import core.World;
import core.entities.Character;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 24/11/13
 * Time: 13:02
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        super();

        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

        JPanel rootPane = new JPanel(new GridLayout(2, 2));

        Character randomCharacter = new Character("Random Player", World.searchRaceByName("Halfing"), World.searchCareerByName("Agitateur"), "PC");

        rootPane.add(new CharacterPanel(randomCharacter));
        rootPane.add(new CharacterPanel());
        rootPane.add(new CharacterPanel());
        rootPane.add(new CharacterPanel());

        this.setContentPane(rootPane);

    }

    public static void main(String[] args){
        World.loadAll();

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
