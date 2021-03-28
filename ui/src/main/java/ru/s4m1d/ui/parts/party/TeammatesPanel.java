package ru.s4m1d.ui.parts.party;

import ru.s4m1d.ui.api.SPanel;
import ru.s4m1d.ui.util.ComponentUtils;

import java.awt.*;

public class TeammatesPanel extends SPanel {
    public TeammatesPanel(){

    }
    @Override
    public void setup() throws Exception {
        ComponentUtils.throwExceptionIfDoesNotHaveParent(this);
        setPreferredSize(new Dimension(
                (int)getParent().getPreferredSize().getWidth(),
                (int)getParent().getPreferredSize().getHeight()/2
                )
        );
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(0,0,0,0));
        setContent();
        setVisible(true);
    }
    public void setContent() throws Exception {
        addSPanelWithImage(CharacterPanel.class, "goblin_ava.jpg");
        addSPanelWithImage(CharacterPanel.class, "mage_girl_ava.jpg");
        addSPanelWithImage(CharacterPanel.class, "ork_ava.jpg");
    }
}
