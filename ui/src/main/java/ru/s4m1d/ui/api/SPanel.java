package ru.s4m1d.ui.api;

import javax.swing.*;

public abstract class SPanel extends JPanel {
    public abstract void setup() throws Exception;

    public void addSPanel(Class<? extends SPanel> cls) throws Exception {
        SPanel sPanel = cls.newInstance();
        add(sPanel);
        sPanel.setup();
    }
    public void addSPanel(Class<? extends SPanel> cls, Object constraints) throws Exception {
        SPanel sPanel = cls.newInstance();
        add(sPanel, constraints);
        sPanel.setup();
    }
    public void addSPanelWithImage(Class<? extends SPanelWithImage> cls, String img) throws Exception {
        SPanelWithImage sPanel = cls.getConstructor(String.class).newInstance(img);
        add(sPanel);
        sPanel.setup();
    }
    public void addSPanelWithImage(Class<? extends SPanelWithImage> cls, String img, Object constraints) throws Exception {
        SPanelWithImage sPanel = cls.getConstructor(String.class).newInstance(img);
        add(sPanel, constraints);
        sPanel.setup();
    }
}
