package view.mainWindow;

import javax.swing.*;
import java.awt.event.*;

public class TabPanelMain extends JTabbedPane {
    public int numTab = 1;
    public TabPanelMain() {
        this.addTab("Новый_" + numTab, new TextAreaMain(null));
        numTab++;

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setCurrentTextArea();
            }
        });
    }
    public static TextAreaMain getCurrentTextArea() {
        return (TextAreaMain) MainWindow.tabPanelMain.getComponentAt(MainWindow.tabPanelMain.getSelectedIndex());
    }
    public static void setCurrentTextArea() {
        try {
            getCurrentTextArea().textArea.grabFocus();
            MainWindow.statusBar.setText("Позиция курсора: " + getCurrentTextArea().textArea.getCaretPosition() + " символ");
        } catch (IndexOutOfBoundsException e) {
            new JOptionPane().showMessageDialog(
                    null,
                    "Для ввода текста откройте текстовый файл или создайте новый!",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
