package Notepad;

import java.awt.FileDialog;
import java.io.*;

public class Function_File {

    GUI gui;

    public Function_File(GUI gui) {
        this.gui = gui;
    }

    private NoteTab current() {
        return gui.getTab();
    }

    public void open() {

        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            gui.createNewTab();
            NoteTab tab = current();

            tab.fileName = fd.getFile();
            tab.fileAddress = fd.getDirectory();

            try {
                BufferedReader br = new BufferedReader(new FileReader(tab.fileAddress + tab.fileName));
                String line;
                tab.textArea.setText("");

                while ((line = br.readLine()) != null) {
                    tab.textArea.append(line + "\n");
                }

                br.close();
            } catch (Exception e) {
                System.out.println("File open error");
            }

            gui.window.setTitle(tab.fileName); // Change le titre de la fenêtre

            int index = gui.tabs.indexOfComponent(tab.scrollPane); // Trouve l'indice de l'onglet correspondant
            if (index != -1) { // Vérifie que l'onglet existe
                gui.tabs.setTitleAt(index, tab.fileName); // Change le titre de l'onglet
            }
            gui.updateTabTitle(tab);
        }
    }

    public void save() {
        NoteTab tab = current();

        if (tab.fileName == null) {
            saveAs();
            return;
        }

        try {
        	if(!tab.fileName.endsWith(".txt")) tab.fileName += ".txt";
            FileWriter fw = new FileWriter(tab.fileAddress + tab.fileName);
            fw.write(tab.textArea.getText());
            fw.close();

            gui.window.setTitle(tab.fileName);
        } catch (Exception e) {
            System.out.println("Save error");
        }
        gui.updateTabTitle(tab);
    }
    
    public void saveAs() {
        NoteTab tab = current();

        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            tab.fileName = fd.getFile();
            tab.fileAddress = fd.getDirectory();
            
            if(!tab.fileName.endsWith(".txt")) tab.fileName += ".txt";

            gui.window.setTitle(tab.fileName);
        }

        try {
            FileWriter fw = new FileWriter(tab.fileAddress + tab.fileName);
            fw.write(tab.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("SaveAs error");
        }
        gui.updateTabTitle(tab);
    }
    
}
