package ru.s4m1d.ui.parts;

import org.springframework.stereotype.Component;
import ru.s4m1d.ui.api.SFrame;
import ru.s4m1d.ui.parts.party.PartyPanel;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends SFrame {
    public MainFrame() throws Exception {
        setPreferredSize(new Dimension(1920,1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public void setup() throws Exception {
        setContent();
        pack();
    }

    private void setContent() throws Exception {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);

        addSPanel(PartyPanel.class,BorderLayout.WEST);
        addSPanel(CentralPanel.class,BorderLayout.CENTER);
        addSPanel(EnemyPanel.class,BorderLayout.EAST);

        setVisible(true);
    }
}
