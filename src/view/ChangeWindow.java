package view;

import model.TextHandler;
import view.mainWindow.TabPanelMain;
import view.mainWindow.TextAreaMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChangeWindow extends TemplateWindow {
    private JTextField inputSearch;
    private JTextField inputChange;
    public ChangeWindow() {
        super("Замена", 500, 260, false);

        JLabel labelInputSearch = new JLabel("Текст (слово, выражение) для поиска:");
        labelInputSearch.setBounds(10, 10, 465, 20);
        this.add(labelInputSearch);

        inputSearch = new JTextField(26);
        inputSearch.setBounds(10, 40, 465, 40);
        inputSearch.setFont(new Font("Dialog", Font.PLAIN, 20));
        inputSearch.addKeyListener(allKeyListener());
        this.add(inputSearch);

        JLabel labelInputChange = new JLabel("Текст (слово, выражение) для замены:");
        labelInputChange.setBounds(10, 90, 465, 20);
        this.add(labelInputChange);

        inputChange = new JTextField(26);
        inputChange.setBounds(10, 120, 465, 40);
        inputChange.setFont(new Font("Dialog", Font.PLAIN, 20));
        inputChange.addKeyListener(allKeyListener());
        this.add(inputChange);

        JButton change = new JButton("Заменить");
        change.setBounds(185, 170, 140, 40);

        change.addActionListener(e -> {
            okChange();
        });
        change.addKeyListener(allKeyListener());
        this.add(change);

        JButton cancel = new JButton("Отмена");
        cancel.setBounds(335, 170, 140, 40);
        cancel.addActionListener(e -> {
            escChange();
        });
        cancel.addKeyListener(allKeyListener());
        this.add(cancel);

        this.setLayout(null);
        this.setVisible(true);
    }

    public KeyListener allKeyListener() {
        return new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER) {
                    okChange();
                }
                if (keyCode == KeyEvent.VK_ESCAPE) {
                    escChange();
                }
            }
        };
    }

    public void okChange() {
        TextAreaMain currentTextArea = TabPanelMain.getCurrentTextArea();
        TextHandler algorithm = new TextHandler(currentTextArea.getTextData(), inputSearch.getText(), inputChange.getText());
        int searchCount = algorithm.getCount();
        TextHandler.setNullCount();
        TextAreaMain.setTextData(algorithm.getNewMainText());

        new JOptionPane().showMessageDialog(
                null,
                "Выполнено замен:  " + searchCount,
                "Результаты замены",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void escChange() {
        this.dispose();
    }
}
