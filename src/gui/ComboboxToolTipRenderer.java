package gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ComboboxToolTipRenderer extends DefaultListCellRenderer {
    LinkedList tooltips;

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {

        JComponent comp = (JComponent) super.getListCellRendererComponent(list,
                value, index, isSelected, cellHasFocus);

        if (-1 < index && null != value && null != tooltips) {
            list.setToolTipText((String) tooltips.get(index));
        }
        return comp;
    }

    public void setTooltips(LinkedList tooltips) {
        this.tooltips = tooltips;
    }
}
