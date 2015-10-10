package gui.menu;

import core.World;
import gui.CharacterPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 03/12/13
 * Time: 17:14
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class MainMenu extends JMenuBar{
    private final MainFrame mainFrame;

    public MainMenu (MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.generateMenu();
    }

    private void generateMenu(){
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem menuFichierAddCharacter = new JMenuItem("Ajouter un personnage");
        menuFichierAddCharacter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        menuFichierAddCharacter.addActionListener(actionEvent -> {
            JTabbedPane tabbedPane = mainFrame.tabbedPane;

            CharacterPanel characterPanel = new CharacterPanel();

            tabbedPane.add(characterPanel);
            tabbedPane.setSelectedComponent(characterPanel);
            tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "New Character");
        });

        JMenuItem menuFichierRemoveCharacter = new JMenuItem("Retirer le personnage");
        menuFichierRemoveCharacter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        menuFichierRemoveCharacter.addActionListener(actionEvent -> {
            JTabbedPane tabbedPane = mainFrame.tabbedPane;
            if(tabbedPane.getTabCount() > 0){
                tabbedPane.remove(tabbedPane.getSelectedIndex());
            }
        });

        JMenuItem menuFichierQuit = new JMenuItem("Quitter");
        menuFichierQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        menuFichierQuit.addActionListener(actionEvent -> System.exit(0));

        JMenu menuFichierData = new JMenu("Données");

        JMenuItem menuFichierReload = new JMenuItem("Recharger les fichiers");
        menuFichierQuit.addActionListener(actionEvent -> World.loadAll());

        /*JMenuItem menuFichierConvert = new JMenuItem("Reconvertir les fichiers");
        menuFichierQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convertData.convertAll();
                World.loadAll();
            }
        });*/

        menuFichierData.add(menuFichierReload);
        //menuFichierData.add(menuFichierConvert);

        menuFichier.add(menuFichierAddCharacter);
        menuFichier.add(menuFichierRemoveCharacter);
        menuFichier.addSeparator();
        menuFichier.add(menuFichierData);
        menuFichier.addSeparator();
        menuFichier.add(menuFichierQuit);

        JMenu menuHelp = new JMenu("Aide");

        JMenuItem menuHelpDoc = new JMenuItem("Documentation");

        JMenuItem menuHelpAbout = new JMenuItem("À propos");

        menuHelp.add(menuHelpDoc);
        menuHelp.addSeparator();
        menuHelp.add(menuHelpAbout);

        this.add(menuFichier);
        this.add(menuHelp);
    }
}
