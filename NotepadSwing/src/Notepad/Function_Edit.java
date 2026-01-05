package Notepad;

public class Function_Edit {

    GUI gui;

    public Function_Edit(GUI gui) {
        this.gui = gui;
    }

    private NoteTab current() {
        return gui.getTab();
    }

    public void undo() {
        try {
            current().undoManager.undo();
        } catch(Exception e) {}
    }

    public void redo() {
        try {
            current().undoManager.redo();
        } catch(Exception e) {}
    }
}

