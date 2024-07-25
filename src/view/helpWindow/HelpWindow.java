package view.helpWindow;

import view.TemplateWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HelpWindow extends TemplateWindow {

    public HelpWindow() {
        super("Справка", 680, 480, false);

        JLabel mainHelpText = new JLabel();
        mainHelpText.setBackground(Color.LIGHT_GRAY);
        mainHelpText.setPreferredSize(new Dimension(680, 40));
        mainHelpText.setText("<html>&nbsp &nbsp Программа представляет собой оконное приложение, " +
                "которое позволяет загружать и просматривать<br/> &nbsp &nbsp текстовые файлы " +
                "с возможностью поиска и замены слов и выражений</html>");
        this.add(mainHelpText, BorderLayout.NORTH, SwingConstants.CENTER);

        JPanel tab = new JPanel();
        tab.setPreferredSize(new Dimension(605, 760));

        JScrollPane scrollBar = new JScrollPane(tab);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.getVerticalScrollBar().setUnitIncrement(16);
        this.add(scrollBar, BorderLayout.CENTER);

        RowConstructorHelp rowFile = new RowConstructorHelp(
                "",
                "",
                "Файл",
                "<html>вкладка меню, позволяющая создать, открыть, сохранить<br/> и закрыть файлы</html>",
                Color.RED
        );
        tab.add(rowFile);

        RowConstructorHelp rowCreate = new RowConstructorHelp(
                "src/view/mainWindow/img/create.png",
                "CTRL + N",
                "Создать",
                "создать новый файл",
                Color.RED
        );
        tab.add(rowCreate);

        RowConstructorHelp rowOpen = new RowConstructorHelp(
                "src/view/mainWindow/img/open.png",
                "CTRL + O",
                "Открыть",
                "открыть имеющийся файл",
                Color.RED
        );
        tab.add(rowOpen);

        RowConstructorHelp rowSave = new RowConstructorHelp(
                "src/view/mainWindow/img/save.png",
                "CTRL + S",
                "Сохранить",
                "сохранить новый или открытый ранее файл",
                Color.RED
        );
        tab.add(rowSave);

        RowConstructorHelp rowCloseTab = new RowConstructorHelp(
                "src/view/mainWindow/img/close.png",
                "CTRL + W",
                "Закрыть",
                "закрыть вкладку текущего файла",
                Color.RED
        );
        tab.add(rowCloseTab);

        RowConstructorHelp rowCloseApp = new RowConstructorHelp(
                "",
                "ALT + F4",
                "Выход",
                "выход из приложения",
                Color.RED
        );
        tab.add(rowCloseApp);

        RowConstructorHelp rowSearchMenu = new RowConstructorHelp(
                "",
                "",
                "Поиск",
                "вкладка меню, позволяющая найти или заменить часть текста",
                Color.GREEN
        );
        tab.add(rowSearchMenu);

        RowConstructorHelp rowSearch = new RowConstructorHelp(
                "src/view/mainWindow/img/search.png",
                "CTRL + F",
                "Найти...",
                "найти символ, слово или выражение",
                Color.GREEN
        );
        tab.add(rowSearch);

        RowConstructorHelp rowChange = new RowConstructorHelp(
                "src/view/mainWindow/img/change.png",
                "CTRL + H",
                "Заменить...",
                "заменить символ, слово или выражение",
                Color.GREEN
        );
        tab.add(rowChange);

        RowConstructorHelp rowView = new RowConstructorHelp(
                "",
                "",
                "Вид",
                "<html>вкладка меню, позволяющая изменить отображение панели<br/> кнопок и строки состояния</html>",
                Color.ORANGE
        );
        tab.add(rowView);

        RowConstructorHelp rowButtonPanel = new RowConstructorHelp(
                "",
                "",
                "Панель кнопок",
                "вкл/выкл режима отображения панели кнопок",
                Color.ORANGE
        );
        tab.add(rowButtonPanel);

        RowConstructorHelp rowStatusBar = new RowConstructorHelp(
                "",
                "",
                "Строка состояния",
                "вкл/выкл режима отображения строки состояния",
                Color.ORANGE
        );
        tab.add(rowStatusBar);

        RowConstructorHelp rowInfo = new RowConstructorHelp(
                "",
                "",
                "О программе",
                "<html>вкладка меню, позволяющая получить дополнительную<br/> информацию о работе программы и разработчике</html>",
                Color.BLUE
        );
        tab.add(rowInfo);

        RowConstructorHelp rowHelp = new RowConstructorHelp(
                "src/view/mainWindow/img/help.png",
                "F1",
                "Справка",
                "справочная информация об органах управления программой",
                Color.BLUE
        );
        tab.add(rowHelp);

        RowConstructorHelp rowDev = new RowConstructorHelp(
                "",
                "",
                "О разработчике",
                "краткая информация о разработчике",
                Color.BLUE
        );
        tab.add(rowDev);

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_ESCAPE) {
                    closeHelp();
                }
            }
        });

        this.setVisible(true);
    }

    public void closeHelp() {
        this.dispose();
    }
}
