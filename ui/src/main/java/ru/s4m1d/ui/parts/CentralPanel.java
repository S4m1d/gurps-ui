package ru.s4m1d.ui.parts;

import ru.s4m1d.ui.api.SPanel;
import ru.s4m1d.ui.util.ComponentUtils;
import ru.s4m1d.ui.util.FileConstants;
import ru.s4m1d.ui.util.ImageUtils;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.nio.file.Paths;


public class CentralPanel extends SPanel {
    private String imageFileName = "enchanted_forest.jpg";

    @Override
    public void setup() throws Exception {
        ComponentUtils.throwExceptionIfDoesNotHaveParent(this);
        setLayout(new BorderLayout());
        int parentWidth = getParent().getWidth();
        int parentHeight = getParent().getHeight();
        setMinimumSize(new Dimension((parentWidth/5),parentHeight));
        setPreferredSize(new Dimension((parentWidth/5),parentHeight));
        setBackground(Color.BLACK);
        setContent();
    }
    public void setContent() {
        String filename = Paths.get(FileConstants.IMAGES)
                .resolve(imageFileName).toAbsolutePath().toString();
        ImageIcon imageIcon = new ImageIcon(filename);
        JLabel jLabel = new JLabel(imageIcon);
        add(jLabel, BorderLayout.CENTER);
        Dimension imageDimension = ImageUtils.calculateDimensionForImage(
                getParent().getWidth()*3.0/5.0,
                getParent().getHeight()*3.0/5.0,
                imageIcon.getImage().getWidth(null),
                imageIcon.getImage().getHeight(null)
        );
        Image image = imageIcon.getImage().getScaledInstance(
                imageDimension.width,
                imageDimension.height,
                Image.SCALE_SMOOTH
        );
        imageIcon.setImage(image);
    }
}
