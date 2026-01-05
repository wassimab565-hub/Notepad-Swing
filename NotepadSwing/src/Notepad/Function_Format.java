package Notepad;

import java.awt.Font;

public class Function_Format {

    GUI gui;

    Font arial, comicSansMS, timesNewRoman;
    String selectedFont = "Arial";

    public Function_Format(GUI gui) {
        this.gui = gui;
    }

    private NoteTab current() {
        return gui.getTab();
    }

    public void wordWrap() {
        NoteTab tab = current();

        if (!tab.textArea.getLineWrap()) {
            tab.textArea.setLineWrap(true);
            tab.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        } else {
            tab.textArea.setLineWrap(false);
            tab.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int size) {
        arial = new Font("Arial", Font.PLAIN, size);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, size);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, size);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch (font) {
            case "Arial":
                current().textArea.setFont(arial);
                break;

            case "Comic Sans MS":
                current().textArea.setFont(comicSansMS);
                break;

            case "Times New Roman":
                current().textArea.setFont(timesNewRoman);
                break;
        }
    }
}
