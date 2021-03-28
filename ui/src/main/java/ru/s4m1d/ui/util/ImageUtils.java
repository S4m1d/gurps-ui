package ru.s4m1d.ui.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {
    public static BufferedImage getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    public static Dimension calculateDimensionForImage(double bordersW, double bordersH, double w, double h){
        Dimension dimension = new Dimension((int)w, (int)h);
        double wCoef = 0;
        double hCoef = 0;
        double actualCoef = 0;
        if(bordersW<w){
            wCoef = bordersW/w;
        }
        if(bordersH<h) {
            hCoef = bordersH/h;
        }
        if(wCoef!=0 && hCoef!=0) {
            actualCoef = Math.min(wCoef, hCoef);
        } else if(wCoef!=0) {
            actualCoef = wCoef;
        } else if(hCoef!=0) {
            actualCoef = hCoef;
        }
        if(actualCoef!=0){
            dimension.setSize(dimension.getWidth()*actualCoef,dimension.getHeight()*actualCoef);
        }
        return dimension;
    }
}
