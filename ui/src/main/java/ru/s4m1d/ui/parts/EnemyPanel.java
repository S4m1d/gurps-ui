package ru.s4m1d.ui.parts;

import ru.s4m1d.ui.api.SPanel;
import ru.s4m1d.ui.util.ComponentUtils;

import java.awt.*;

public class EnemyPanel extends SPanel {

    public EnemyPanel(){

    }
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
    }
}
