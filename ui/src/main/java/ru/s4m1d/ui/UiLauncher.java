package ru.s4m1d.ui;

import ru.s4m1d.ui.parts.MainFrame;
import sun.net.www.http.HttpClient;

import java.net.URL;

public class UiLauncher {
    public static void launch() throws Exception {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setup();
    }
}
