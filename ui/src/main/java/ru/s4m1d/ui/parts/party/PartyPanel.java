package ru.s4m1d.ui.parts.party;

import ru.s4m1d.ui.api.SPanel;
import ru.s4m1d.ui.util.ComponentUtils;

import javax.swing.*;
import java.awt.*;

public class PartyPanel extends SPanel {

    public PartyPanel(){

    }
    @Override
    public void setup() throws Exception {
        ComponentUtils.throwExceptionIfDoesNotHaveParent(this);
        setLayout(new BorderLayout());
        int parentWidth = getParent().getWidth();
        int parentHeight = getParent().getHeight();
        setMinimumSize(new Dimension(parentWidth/5,parentHeight));
        setPreferredSize(new Dimension(parentWidth/5,parentHeight));
        setBackground(Color.GRAY);
        setContent();
    }
    public void setContent() throws Exception {

        JLabel paneName = new JLabel("ADVENTURERS");
        paneName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
        paneName.setForeground(Color.WHITE);
        add(paneName,BorderLayout.NORTH);

        addSPanelWithImage(CurCharacterPanel.class, "archer-man.jpg", BorderLayout.CENTER);

        addSPanel(TeammatesPanel.class, BorderLayout.SOUTH);
    }
}
