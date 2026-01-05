package Notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class NoteTab {

    public JTextArea textArea;
    public JScrollPane scrollPane;
    public UndoManager undoManager;

    public String fileName = null;
    public String fileAddress = null;

    public NoteTab() {
        textArea = new JTextArea();
        undoManager = new UndoManager();

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
        
        // Attach the NoteTab to the JTextArea
        textArea.putClientProperty("tab", this);
        scrollPane = new JScrollPane(
            textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
    }
}