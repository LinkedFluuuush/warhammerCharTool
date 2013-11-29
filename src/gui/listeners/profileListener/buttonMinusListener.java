package gui.listeners.profileListener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 25/11/13
 * Time: 15:03
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class buttonMinusListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JPanel sourcePanel = (JPanel)((JLabel)mouseEvent.getSource()).getParent();

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
