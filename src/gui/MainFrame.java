package gui;

import core.World;
import core.entities.Character;
import gui.menu.MainMenu;

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
    public JTabbedPane tabbedPane;

    public MainFrame(){
        super();

        this.setTitle("NPC Generator");

//        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setJMenuBar(new MainMenu(this));

        this.addAllPanels();
    }

    public static void main(String[] args){
        World.loadAll();

        MainFrame mainFrame = new MainFrame();

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }

    public void addAllPanels(){
        /*Toolkit t = this.getToolkit();
        Dimension dim = new Dimension(t.getScreenSize());
        int nbV = (int)dim.getHeight() / 500;
        int nbH = (int)dim.getWidth() / 784;*/

        tabbedPane = new JTabbedPane();
        tabbedPane.setMinimumSize(new Dimension(784, 500));

        /*JPanel rootPane = new JPanel(new GridLayout(nbV, nbH));

        for(int i = 0; i < nbV ; i++){
            for (int j = 0; j < nbH ; j++){
                rootPane.add(new CharacterPanel());
            }
        }*/

        tabbedPane.add(new CharacterPanel());
        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "New Character");

        this.setContentPane(tabbedPane);
    }
}
