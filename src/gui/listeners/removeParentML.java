package gui.listeners;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 01/12/13
 * Time: 20:24
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class removeParentML implements MouseListener{
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JComponent sourceParent = (JComponent)((JComponent)mouseEvent.getSource()).getParent();
        JPanel panelParent = ((JPanel)sourceParent.getParent());
        panelParent.remove(sourceParent);
        panelParent.revalidate();
        panelParent.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
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
