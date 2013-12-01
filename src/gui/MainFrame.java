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

        this.setTitle("NPC Generator");

        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Character randomCharacter = new Character("Random Player", World.searchRaceByName("Halfing"), World.searchCareerByName("Agitateur"), "PC");

        this.addAllPanels();

        /*rootPane.add(new CharacterPanel());
        rootPane.add(new CharacterPanel());
        rootPane.add(new CharacterPanel());
        rootPane.add(new CharacterPanel());*/
    }

    public static void main(String[] args){
        World.loadAll();

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public void addAllPanels(){
        Toolkit t = this.getToolkit();
        Dimension dim = new Dimension(t.getScreenSize());
        int nbV = (int)dim.getHeight() / 500;
        int nbH = (int)dim.getWidth() / 784;

        JPanel rootPane = new JPanel(new GridLayout(nbV, nbH));

        for(int i = 0; i < nbV ; i++){
            for (int j = 0; j < nbH ; j++){
                rootPane.add(new CharacterPanel());
            }
        }

        this.setContentPane(rootPane);
    }
}
