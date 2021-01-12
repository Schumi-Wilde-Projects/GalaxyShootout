package schumiwilde.projects;

import java.util.LinkedHashMap;
import java.util.Map;

public class HighScores {
    private final Map<String, Integer> highScores;

    public HighScores() {
        highScores = new LinkedHashMap<>(10);
        seedHighScores();
    }

    public Map<String, Integer> getHighScores() {
        return highScores;
    }

    private void seedHighScores() {
        int playerNumber = 1;
        int tempHighScore = 100000;
        for (int i = 0; i < 10; i++) {
            addHighScore("Gracz " + playerNumber, tempHighScore);
            playerNumber++;
            tempHighScore -= 10000;
        }
    }

    public void addHighScore(String playerName, int playerScore) {
        highScores.put(playerName, playerScore);
    }
}
