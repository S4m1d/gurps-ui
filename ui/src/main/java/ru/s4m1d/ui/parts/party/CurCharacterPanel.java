package ru.s4m1d.ui.parts.party;

import ru.s4m1d.gurps.datamodel.CharacterDTO;
import ru.s4m1d.system.services.CharacterService;
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
        characterDTO = CharacterService.getCharacter(2);
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
        jPanel.setLayout(new GridLayout(5,1,0,0));
        jPanel.setBackground(new Color(0,0,0,0));
        jPanel.add(new ScratchWhiteTextLabel(characterDTO.getCharacterName()));
        jPanel.add(new ScratchWhiteTextLabel("ST:"+String.valueOf(characterDTO.getStrength())));
        jPanel.add(new ScratchWhiteTextLabel("DX:"+String.valueOf(characterDTO.getDexterity())));
        jPanel.add(new ScratchWhiteTextLabel("IQ:"+String.valueOf(characterDTO.getIq())));
        jPanel.add(new ScratchWhiteTextLabel("HT:"+String.valueOf(characterDTO.getHealth())));
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
