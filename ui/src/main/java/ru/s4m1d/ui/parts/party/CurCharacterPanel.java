package ru.s4m1d.ui.parts.party;

import org.springframework.stereotype.Component;
import ru.s4m1d.gurps.datamodel.CharacterDTO;
import ru.s4m1d.ui.api.SPanelWithImage;
import ru.s4m1d.ui.util.ComponentUtils;
import ru.s4m1d.ui.util.FileConstants;
import ru.s4m1d.ui.util.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

public class CurCharacterPanel extends SPanelWithImage {
    private Image backgroundImage;

    private CharacterDTO characterDTO;

    public CurCharacterPanel(String img) throws IOException {
        super();
        characterDTO = new CharacterDTO(
                "Arnold Swanson",
                "archer-man.jpg",
                "",
                9,
                13,
                12,
                9
        );
        backgroundImage = ImageIO.read(Paths
                .get(FileConstants.IMAGES)
                .resolve(characterDTO.getImageName())
                .toAbsolutePath()
                .toFile()
        );
    }

    public void setup() throws Exception {
        ComponentUtils.throwExceptionIfDoesNotHaveParent(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(0,0,0,0));
        setContent();
        setVisible(true);
    }
    public void setContent(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,1,0,0));
        jPanel.setBackground(new Color(0,0,0,0));
        jPanel.setForeground(Color.WHITE);
        jPanel.add(new JLabel(characterDTO.getCharacterName()));
        jPanel.add(new JLabel(String.valueOf(characterDTO.getStrength())));
        add(jPanel);
    }

    //setting image as background
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension imageDimension = ImageUtils.calculateDimensionForImage(
                getSize().getWidth(),
                getSize().getHeight(),
                backgroundImage.getWidth(null),
                backgroundImage.getHeight(null)
        );
        g.drawImage(backgroundImage, 0, 0, imageDimension.width, imageDimension.height, null);
    }
}
