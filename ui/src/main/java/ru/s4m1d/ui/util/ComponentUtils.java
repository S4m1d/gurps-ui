package ru.s4m1d.ui.util;

import java.awt.*;

public class ComponentUtils {
    public static void makeVisibleContentOf(Container container){
        for(Component innerComponent:container.getComponents()){
            innerComponent.setVisible(true);
        }
    }

    public static void throwExceptionIfDoesNotHaveParent(Component component) throws Exception {
        if(component.getParent() == null) {
            throw new Exception("component does not have parent");
        }
    }
}
