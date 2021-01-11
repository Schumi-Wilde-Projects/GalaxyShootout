package schumiwilde.projects;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

@Component
public class GameRun {
    public void run() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("GalaxyShootout");
        config.setWindowedMode(1024, 768);
        new Lwjgl3Application(new Orchestrator(), config);
    }
}
