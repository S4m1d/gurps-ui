package ru.s4m1d.ui.parts.party;

import ru.s4m1d.ui.api.SPanelWithImage;
import ru.s4m1d.ui.util.ComponentUtils;
import ru.s4m1d.ui.util.FileConstants;
import ru.s4m1d.ui.util.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

public class CharacterPanel extends SPanelWithImage {
    private Image backgroundImage;

    private int PREFERRED_BORDERS = 100;

    public CharacterPanel(String img) throws IOException {
        super();
        backgroundImage = ImageIO.read(
                Paths
                .get(FileConstants.IMAGES)
                .resolve(img)
                .toAbsolutePath()
                .toFile()
        );
    }
    @Override
    public void setup() throws Exception {
        ComponentUtils.throwExceptionIfDoesNotHaveParent(this);
        setPreferredSize(new Dimension(
                (int)getParent().getPreferredSize().getWidth()/5,
                (int)getParent().getPreferredSize().getHeight()/5)
        );
        setLayout(new GridLayout(2,1,0,0));
        setBackground(new Color(0,0,0,0));
        setContent();
        setVisible(true);
    }
    public void setContent(){
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
