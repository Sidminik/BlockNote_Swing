package view.mainWindow;

import controller.ActionAdapterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextAreaMain extends JPanel {
    public JTextArea textArea;
    public int caretPosition = 0;
    public TextAreaMain(String textData) {
        this.setLayout(new BorderLayout());
        textArea = new JTextArea(textData);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
        textArea.addCaretListener(e -> {
            caretPosition = textArea.getCaretPosition();
            MainWindow.statusBar.setText("Позиция курсора: " + textArea.getCaretPosition() + " символ");
        });
        textArea.addKeyListener(ActionAdapterController.allKeyListener());


        JScrollPane scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollBar, BorderLayout.CENTER);
    }
    public String getTextData() {
        return this.textArea.getText();
    }
    public static void setTextData(String textData) {
        TabPanelMain.getCurrentTextArea().textArea.setText(textData);
    }

}
