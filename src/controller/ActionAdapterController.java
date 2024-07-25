package controller;

import view.ChangeWindow;
import view.ChooserLocal;
import view.SearchWindow;
import view.helpWindow.HelpWindow;
import view.mainWindow.MainWindow;
import view.mainWindow.TabPanelMain;
import view.mainWindow.TextAreaMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class ActionAdapterController extends JPanel {
    MenuBarController menuBar;
    static ButtonPanelController panelButton;

    public ActionAdapterController() {
        this.setLayout(new BorderLayout());

        menuBar = new MenuBarController();
        this.add(menuBar, BorderLayout.NORTH);

        panelButton = new ButtonPanelController();
        this.add(panelButton, BorderLayout.SOUTH);
    }

    public static void createController(){
        MainWindow.tabPanelMain.addTab("Новый_" + MainWindow.tabPanelMain.numTab, new TextAreaMain(null));
        MainWindow.tabPanelMain.setSelectedIndex(MainWindow.tabPanelMain.getTabCount() - 1);
        MainWindow.tabPanelMain.numTab++;
        TabPanelMain.setCurrentTextArea();
    }

    public static void openController(){
        try {
            ChooserLocal openFileWindow = new ChooserLocal();
            int window = openFileWindow.showDialog(Main.start, "Открыть");
            openFileWindow.setFileSelectionMode(ChooserLocal.FILES_AND_DIRECTORIES);
            String fileFullName = null;
            if (window == ChooserLocal.APPROVE_OPTION) {
                fileFullName = openFileWindow.getCurrentDirectory().getAbsolutePath();
                File openFile = openFileWindow.getSelectedFile();
                String fileName = openFile.getName();
                fileFullName = fileFullName + "\\" + fileName;
                assert fileFullName != null;
                FileReader reader = new FileReader(fileFullName);
                BufferedReader tempBuf = new BufferedReader(reader);
                MainWindow.tabPanelMain.addTab(fileName, new TextAreaMain(tempBuf.readLine()));
                MainWindow.tabPanelMain.setSelectedIndex(MainWindow.tabPanelMain.getTabCount() - 1);
                TabPanelMain.setCurrentTextArea();
            } else if (window == ChooserLocal.CANCEL_OPTION) {
                openFileWindow.setVisible(false);
            }
        } catch (IOException e) {
            new JOptionPane().showMessageDialog(
                    null,
                    "Возникла ошибка во время открытия, проверьте данные!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void saveController(){
        try {
            ChooserLocal saveFileWindow = new ChooserLocal();
            saveFileWindow.setSelectedFile(new File("new.txt"));
            int window = saveFileWindow.showDialog(Main.start, "Сохранить");
            saveFileWindow.setFileSelectionMode(ChooserLocal.FILES_AND_DIRECTORIES);
            String fileFullName = null;
            if (window == ChooserLocal.APPROVE_OPTION) {
                fileFullName = saveFileWindow.getCurrentDirectory().getAbsolutePath();
                File openFile = saveFileWindow.getSelectedFile();
                String fileName = openFile.getName();
                fileFullName = fileFullName + "\\" + fileName;
                assert fileFullName != null;
                FileWriter writer = new FileWriter(fileFullName, false);
                TextAreaMain textPane = TabPanelMain.getCurrentTextArea();
                writer.write(textPane.getTextData());
                MainWindow.tabPanelMain.setTitleAt(MainWindow.tabPanelMain.getSelectedIndex(), fileName);
                writer.close();
            } else {
                saveFileWindow.setVisible(false);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            new JOptionPane().showMessageDialog(
                    null,
                    "Возникла ошибка во время записи, проверьте данные!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void closeController(){
        try {
            MainWindow.tabPanelMain.remove(MainWindow.tabPanelMain.getSelectedIndex());
            TabPanelMain.setCurrentTextArea();
        } catch (IndexOutOfBoundsException e) {
            MainWindow.statusBar.setText("Нет активных окон");
        }
    }

    public static void searchController() {
        if (MainWindow.tabPanelMain.getTabCount() > 0) {
            SearchWindow searchWindow = new SearchWindow();
        } else {
            new JOptionPane().showMessageDialog(
                    null,
                    "Для операции поиска откройте текстовый файл или создайте новый!",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void changeController() {
        if (MainWindow.tabPanelMain.getTabCount() > 0) {
            ChangeWindow changeWindow = new ChangeWindow();
        } else {
            new JOptionPane().showMessageDialog(
                    null,
                    "Для операции замены откройте текстовый файл или создайте новый!",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void helpController() {
        HelpWindow helpWindow = new HelpWindow();
    }

    public static KeyListener allKeyListener() {
        return new KeyAdapter() {
            boolean ctrl = false;
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_CONTROL) {
                    ctrl = true;
                }
                if (ctrl) {
                    if (keyCode == 78) {
                        createController();
                    }
                    if (keyCode == 79) {
                        openController();
                    }
                    if (keyCode == 83) {
                        saveController();
                    }
                    if (keyCode == 87) {
                        closeController();
                    }
                    if (keyCode == 70) {
                        searchController();
                    }
                    if (keyCode == 72) {
                        changeController();
                    }
                }
                if (keyCode == KeyEvent.VK_F1) {
                    helpController();
                }
            }
            public void keyReleased(KeyEvent e) {
                ctrl = false;
            }
        };
    }
}
