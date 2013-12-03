package gui.menu;

import gui.CharacterPanel;
import gui.MainFrame;
import sun.security.jgss.krb5.Krb5Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private MainFrame mainFrame;

    public MainMenu (MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.generateMenu();
    }

    private void generateMenu(){
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem menuFichierAddCharacter = new JMenuItem("Ajouter un personnage");
        menuFichierAddCharacter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        menuFichierAddCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Toolkit t = mainFrame.getToolkit();
                Dimension dim = new Dimension(t.getScreenSize());
                int nbV = (int)dim.getHeight() / 500;
                int nbH = (int)dim.getWidth() / 784;

                JTabbedPane tabbedPane = mainFrame.tabbedPane;

                JPanel rootPane = new JPanel(new GridLayout(nbV, nbH));

                for(int i = 0; i < nbV ; i++){
                    for (int j = 0; j < nbH ; j++){
                        rootPane.add(new CharacterPanel());
                    }
                }

                tabbedPane.add(rootPane);
                tabbedPane.setSelectedComponent(rootPane);
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), "New Character");
            }
        });

        menuFichier.add(menuFichierAddCharacter);

        this.add(menuFichier);
    }
}
