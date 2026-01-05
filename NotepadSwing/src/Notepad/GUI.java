package Notepad;

import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    JFrame window;
    JTabbedPane tabs;

    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuTextColor;

    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    JMenuItem iUndo, iRedo;
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR;
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;

    JMenu menuFont, menuFontSize;
    JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5, iColor6;
    JMenuItem tWhite, tBlack, tBlue, tYellow, tRed, tGreen;

    Function_File file = new Function_File(this);
    Function_Edit edit = new Function_Edit(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);

    KeyHandler KHandler = new KeyHandler(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTabs();
        createNewTab(); // Premier onglet
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();
        createTextColorMenu();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTabs() {
        tabs = new JTabbedPane();
        window.add(tabs);
    }

    public void createNewTab() {
        NoteTab tab = new NoteTab();

        tab.textArea.addKeyListener(KHandler);

        // Attacher NoteTab via client property
        attachTab(tab);

        tabs.addTab("New", tab.scrollPane);
        tabs.setSelectedComponent(tab.scrollPane);
    }

    // Fix complet ici
    public void attachTab(NoteTab tab) {
        tab.textArea.putClientProperty("tab", tab);

        // Le viewport renvoie un Component → on le caste
        JComponent view = (JComponent) tab.scrollPane.getViewport().getView();
        view.putClientProperty("tab", tab);
    }

    public NoteTab getCurrentTab() {
        JScrollPane sp = (JScrollPane) tabs.getSelectedComponent();
        if (sp == null) return null;

        JComponent comp = (JComponent) sp.getViewport().getView();
        return (NoteTab) comp.getClientProperty("tab");
    }

    public NoteTab getTab() {
        JScrollPane sp = (JScrollPane) tabs.getSelectedComponent();
        if (sp == null) return null;

        JComponent comp = (JComponent) sp.getViewport().getView();
        return (NoteTab) comp.getClientProperty("tab");
    }

    public void updateTabTitle(NoteTab tab) {
        if (tab.fileName == null) return;

        // Mettre à jour le titre de la fenêtre uniquement pour l'onglet actif
        if (getCurrentTab() == tab) {
            window.setTitle(tab.fileName);
        }

        // Mettre à jour le titre de l'onglet correspondant
        int index = tabs.indexOfComponent(tab.scrollPane);
        if (index != -1) {
            tabs.setTitleAt(index, tab.fileName);
        }
    }

    
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuColor = new JMenu("Background Color");
        menuTextColor = new JMenu("Text Color");

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
        menuBar.add(menuColor);
        menuBar.add(menuTextColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);

        menuFile.add(iNew);
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuFile.add(iSaveAs);
        menuFile.add(iExit);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);

        menuEdit.add(iUndo);
        menuEdit.add(iRedo);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);

        menuFont.add(iFontArial);
        menuFont.add(iFontCSMS);
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);

        menuFontSize.add(iFontSize8);
        menuFontSize.add(iFontSize12);
        menuFontSize.add(iFontSize16);
        menuFontSize.add(iFontSize20);
        menuFontSize.add(iFontSize24);
        menuFontSize.add(iFontSize28);
    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("White Background");
        iColor1.addActionListener(this);

        iColor2 = new JMenuItem("Black Background");
        iColor2.addActionListener(this);

        iColor3 = new JMenuItem("Blue Background");
        iColor3.addActionListener(this);

        iColor4 = new JMenuItem("Yellow Background");
        iColor4.addActionListener(this);

        iColor5 = new JMenuItem("Red Background");
        iColor5.addActionListener(this);

        iColor6 = new JMenuItem("Green Background");
        iColor6.addActionListener(this);

        menuColor.add(iColor1);
        menuColor.add(iColor2);
        menuColor.add(iColor3);
        menuColor.add(iColor4);
        menuColor.add(iColor5);
        menuColor.add(iColor6);
    }

    public void createTextColorMenu() {
        tWhite = new JMenuItem("White Text");
        tWhite.addActionListener(this);

        tBlack = new JMenuItem("Black Text");
        tBlack.addActionListener(this);

        tBlue = new JMenuItem("Blue Text");
        tBlue.addActionListener(this);

        tYellow = new JMenuItem("Yellow Text");
        tYellow.addActionListener(this);

        tRed = new JMenuItem("Red Text");
        tRed.addActionListener(this);

        tGreen = new JMenuItem("Green Text");
        tGreen.addActionListener(this);

        menuTextColor.add(tWhite);
        menuTextColor.add(tBlack);
        menuTextColor.add(tBlue);
        menuTextColor.add(tYellow);
        menuTextColor.add(tRed);
        menuTextColor.add(tGreen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "New": createNewTab(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "Save As": file.saveAs(); break;
            case "Exit": System.exit(0); break;

            case "Undo": edit.undo(); break;
            case "Redo": edit.redo(); break;

            case "Word Wrap: Off":
            case "Word Wrap: On":
                format.wordWrap();
                break;

            case "Arial":
            case "Comic Sans MS":
            case "Times New Roman":
                format.setFont(e.getActionCommand());
                break;

            case "8": format.createFont(8); break;
            case "12": format.createFont(12); break;
            case "16": format.createFont(16); break;
            case "20": format.createFont(20); break;
            case "24": format.createFont(24); break;
            case "28": format.createFont(28); break;

            case "White Background":
            case "Black Background":
            case "Blue Background":
            case "Yellow Background":
            case "Red Background":
            case "Green Background":
                color.changeColor(e.getActionCommand());
                break;

            case "White Text": color.changeTextColor("White"); break;
            case "Black Text": color.changeTextColor("Black"); break;
            case "Blue Text": color.changeTextColor("Blue"); break;
            case "Yellow Text": color.changeTextColor("Yellow"); break;
            case "Red Text": color.changeTextColor("Red"); break;
            case "Green Text": color.changeTextColor("Green"); break;
        }
    }
}
