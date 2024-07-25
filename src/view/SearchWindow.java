package view;

import model.TextHandler;
import view.mainWindow.TabPanelMain;
import view.mainWindow.TextAreaMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchWindow extends TemplateWindow {
    private JTextField inputSearch;
    public SearchWindow() {
        super("Поиск", 500, 180, false);

        JLabel labelInputSearch = new JLabel("Текст (слово, выражение) для поиска:");
        labelInputSearch.setBounds(10, 10, 465, 20);
        this.add(labelInputSearch);

        inputSearch = new JTextField(26);
        inputSearch.setBounds(10, 40, 465, 40);
        inputSearch.setFont(new Font("Dialog", Font.PLAIN, 20));
        inputSearch.addKeyListener(allKeyListener());
        this.add(inputSearch);

        JButton search = new JButton("Найти");
        search.setBounds(185, 90, 140, 40);

        search.addActionListener(e -> {
            allKeyListener();
        });
        search.addKeyListener(allKeyListener());
        this.add(search);

        JButton cancel = new JButton("Отмена");
        cancel.setBounds(335, 90, 140, 40);
        cancel.addActionListener(e -> {
            escSearch();
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
                    okSearch();
                }
                if (keyCode == KeyEvent.VK_ESCAPE) {
                    escSearch();
                }
            }
        };
    }

    public void okSearch() {
        TextAreaMain currentTextArea = TabPanelMain.getCurrentTextArea();
        TextHandler algorithm = new TextHandler(currentTextArea.getTextData(), inputSearch.getText());

        new JOptionPane().showMessageDialog(
                null,
                "Найдено совпадений:  " + algorithm.getCount(),
                "Результаты поиска",
                JOptionPane.INFORMATION_MESSAGE);

        TextHandler.setNullCount();
    }

    public void escSearch() {
        this.dispose();
    }
}
