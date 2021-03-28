package ru.s4m1d.gurps.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.s4m1d.ui.parts.MainFrame;

@Configuration
@EnableAutoConfiguration
@ComponentScan("ru.s4m1d")
public class AppLauncher {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AppLauncher.class).headless(false).run(args);
        MainFrame mainFrame = context.getBean(MainFrame.class);
        mainFrame.setup();
    }
}
