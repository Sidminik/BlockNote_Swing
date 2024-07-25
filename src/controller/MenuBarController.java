package controller;

import view.mainWindow.MainWindow;

import javax.swing.*;
import java.awt.event.ItemEvent;

import static controller.Main.start;

public class MenuBarController extends JMenuBar {

    public MenuBarController() {
        JMenu file = new JMenu("Файл");

        JMenuItem create = new JMenuItem("Создать");
        create.addActionListener(e -> {
            ActionAdapterController.createController();
        });
        file.add(create);

        JMenuItem open = new JMenuItem("Открыть");
        open.addActionListener(e -> {
            ActionAdapterController.openController();
        });
        file.add(open);

        JMenuItem save = new JMenuItem("Сохранить");
        save.addActionListener(e -> {
            ActionAdapterController.saveController();
        });
        file.add(save);

        JMenuItem close = new JMenuItem("Закрыть");
        close.addActionListener(e -> {
            ActionAdapterController.closeController();
        });
        file.add(close);

        file.addSeparator();

        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(e -> {
            System.exit(0);
        });
        file.add(exit);

        this.add(file);

        JMenu searchChange = new JMenu("Поиск");

        JMenuItem search = new JMenuItem("Найти...");
        searchChange.add(search);

        search.addActionListener(e -> {
            ActionAdapterController.searchController();
        });

        JMenuItem change = new JMenuItem("Заменить...");
        change.addActionListener(e -> {
            ActionAdapterController.changeController();
        });
        searchChange.add(change);

        this.add(searchChange);

        JMenu view = new JMenu("Вид");

        JCheckBoxMenuItem onPanelButton = new JCheckBoxMenuItem("Панель кнопок", true);
        onPanelButton.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ActionAdapterController.panelButton.setVisible(true);
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                ActionAdapterController.panelButton.setVisible(false);
            }
        });
        view.add(onPanelButton);

        JCheckBoxMenuItem onStatusBar = new JCheckBoxMenuItem("Строка состояния", true);
        onStatusBar.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                MainWindow.statusBar.setVisible(true);
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                MainWindow.statusBar.setVisible(false);
            }
        });
        view.add(onStatusBar);

        view.addSeparator();

        JCheckBoxMenuItem onSystemJava = new JCheckBoxMenuItem("Java / cистемный", true);
        onSystemJava.addItemListener(e -> {
            try {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                SwingUtilities.updateComponentTreeUI(start);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        });
        view.add(onSystemJava);

        this.add(view);

        JMenu program = new JMenu("О программе");
        JMenuItem help = new JMenuItem("Справка");
        help.addActionListener(e -> {
            ActionAdapterController.helpController();
        });
        program.add(help);

        JMenuItem developer = new JMenuItem("О разработчике");
        developer.addActionListener(e -> {
            new JOptionPane().showMessageDialog(
                    null,
                    "Sidminik",
                    "Сведения о разработчике",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        program.add(developer);

        this.add(program);
    }
}
