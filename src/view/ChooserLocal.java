package view;

import javax.swing.*;

public class ChooserLocal extends JFileChooser {
    public ChooserLocal() {
        super("C:\\");
        frameChooserLocal();
        updateUI();
    }
    public static void frameChooserLocal() {
        UIManager.put("FileChooser.lookInLabelText", "Текущая директория:");

        UIManager.put("FileChooser.upFolderToolTipText", "На один уровень вверх");
        UIManager.put("FileChooser.newFolderToolTipText", "Создание новой папки");
        UIManager.put("FileChooser.homeFolderToolTipText", "Домой");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");

        UIManager.put("FileChooser.fileNameHeaderText", "Имя");
        UIManager.put("FileChooser.fileSizeHeaderText", "Размер");
        UIManager.put("FileChooser.fileTypeHeaderText", "Тип");
        UIManager.put("FileChooser.fileDateHeaderText", "Изменен");

        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Все файлы");

        UIManager.put("FileChooser.openButtonToolTipText", false);
        UIManager.put("FileChooser.cancelButtonToolTipText", false);
        UIManager.put("FileChooser.saveButtonToolTipText", false);

        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.directoryOpenButtonText", "Открыть");

        UIManager.put("FileChooser.viewMenuLabelText","Вид");
        UIManager.put("FileChooser.newFolderActionLabelText","Новая папка");
        UIManager.put("FileChooser.refreshActionLabelText","Обновить");
        UIManager.put("FileChooser.listViewActionLabelText","Список");
        UIManager.put("FileChooser.detailsViewActionLabelText","Таблица");
    }
}
