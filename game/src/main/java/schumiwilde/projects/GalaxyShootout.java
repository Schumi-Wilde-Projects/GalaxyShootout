package schumiwilde.projects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GalaxyShootout {
    public static void main(String[] args) throws FileNotFoundException {
        System.err.close();
        System.setErr(new PrintStream("errors.log"));
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(GameRun.class).run();
    }
}
