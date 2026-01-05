package Notepad;

import java.awt.Color;

public class Function_Color {

    GUI gui;

    public Function_Color(GUI gui) {
        this.gui = gui;
    }

    private NoteTab current() {
        return gui.getTab();
    }

    public void changeColor(String color) {

        switch (color) {
            case "White Background":
                current().textArea.setBackground(Color.white);
                current().textArea.setForeground(Color.black);
                break;

            case "Black Background":
                current().textArea.setBackground(Color.black);
                current().textArea.setForeground(Color.white);
                break;

            case "Blue Background":
                current().textArea.setBackground(Color.blue);
                current().textArea.setForeground(Color.white);
                break;

            case "Yellow Background":
                current().textArea.setBackground(Color.yellow);
                current().textArea.setForeground(Color.black);
                break;

            case "Red Background":
                current().textArea.setBackground(Color.red);
                current().textArea.setForeground(Color.white);
                break;

            case "Green Background":
                current().textArea.setBackground(Color.green);
                current().textArea.setForeground(Color.black);
                break;
        }
    }

    public void changeTextColor(String color) {
        switch(color) {
            case "White":  current().textArea.setForeground(Color.white); break;
            case "Black":  current().textArea.setForeground(Color.black); break;
            case "Blue":   current().textArea.setForeground(Color.blue); break;
            case "Yellow": current().textArea.setForeground(Color.yellow); break;
            case "Red":    current().textArea.setForeground(Color.red); break;
            case "Green":  current().textArea.setForeground(Color.green); break;
        }
    }
}
