package com.project.game.keys;

import org.lwjgl.input.Keyboard;

public class KeyBoardHandler {
    private Directions lastDirectionKeyPressed;

    public void update() {
        resetValues();
        lastDirectionKeyPressed = Directions.WAITING;

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                switch (Keyboard.getEventKey()) {
                    case Keyboard.KEY_UP -> lastDirectionKeyPressed = Directions.UP;
                    case Keyboard.KEY_RIGHT -> lastDirectionKeyPressed = Directions.RIGHT;
                    case Keyboard.KEY_DOWN -> lastDirectionKeyPressed = Directions.DOWN;
                    case Keyboard.KEY_LEFT -> lastDirectionKeyPressed = Directions.LEFT;
                }
            }
        }
    }

    private void resetValues() {
        lastDirectionKeyPressed = Directions.WAITING;
    }
    public Directions lastDirectionKeyPressed() {
        return lastDirectionKeyPressed;
    }
}
