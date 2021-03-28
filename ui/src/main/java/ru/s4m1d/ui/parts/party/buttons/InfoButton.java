package ru.s4m1d.ui.parts.party.buttons;

import javax.swing.*;
import java.awt.*;

public class InfoButton extends JButton {
    @Override
    public void paintComponent(Graphics g){
        Dimension preferredSize = getPreferredSize();
        g.setColor(Color.RED);
        g.fillOval(0,0, preferredSize.width*2,preferredSize.height*2);
        g.dispose();
    }
}
