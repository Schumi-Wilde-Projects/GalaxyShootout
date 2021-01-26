package schumiwilde.projects;

public class Memento {
    private float playerX;
    private float playerY;
    private static int index = 0;

    public Memento(float playerX, float playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public float getPlayerX() {
        return playerX;
    }

    public float getPlayerY() {
        return playerY;
    }

    public void setPlayerX(float playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(float playerY) {
        this.playerY = playerY;
    }

    public static int getIndex() {
        return index;
    }

    public static void incrementIndex() {
        index++;
    }
}
