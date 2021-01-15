package schumiwilde.projects.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyboardControl implements InputProcessor {
    public boolean leftPressed, rightPressed, escapePressed;

    @Override
    public boolean keyDown(int keycode) {
        boolean keyPressed = false;
        switch (keycode) {
            case Input.Keys.LEFT:
                leftPressed = true;
                keyPressed = true;
                break;
            case Input.Keys.RIGHT:
                rightPressed = true;
                keyPressed = true;
                break;
            case Input.Keys.ESCAPE:
                escapePressed = true;
                keyPressed = true;
                break;
        }

        return keyPressed;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean keyPressed = false;
        switch (keycode) {
            case Input.Keys.LEFT:
                leftPressed = false;
                keyPressed = true;
                break;
            case Input.Keys.RIGHT:
                rightPressed = false;
                keyPressed = true;
                break;
            case Input.Keys.ESCAPE:
                escapePressed = false;
                keyPressed = true;
                break;
        }

        return keyPressed;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
