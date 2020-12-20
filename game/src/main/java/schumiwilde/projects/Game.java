package schumiwilde.projects;

import com.badlogic.gdx.ApplicationAdapter;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class Game extends ApplicationAdapter {

    @Autowired
    private Generator gen;

    @Override
    public void create() {
        System.out.println("Hello!");
        gen.working();
    }
}
