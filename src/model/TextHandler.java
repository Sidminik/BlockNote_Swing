package model;

import view.mainWindow.TabPanelMain;

public class TextHandler {
    private static String mainText;
    private static String templateSearch;
    private static String templateChange;
    private static int count = 0;
    private static String newMainText;

    public TextHandler(String mainText, String templateSearch) {
        this.mainText = mainText;
        this.templateSearch = templateSearch;
        setCount();
    }

    public TextHandler(String mainText, String templateSearch, String templateChange) {
        this.mainText = mainText;
        this.templateSearch = templateSearch;
        this.templateChange = templateChange;
        setCount();
        setNewMainText();
    }

    public static void setCount() { // searchInText
        mainText = TabPanelMain.getCurrentTextArea().getTextData();
        for (int position = 0; position < mainText.length(); ) {
            if (mainText.indexOf(templateSearch, position) >= 0) {
                count++;
                position = mainText.indexOf(templateSearch, position) + 1;
            } else {
                break;
            }
        }
    }
    public static void setNullCount() {
        count = 0;
    }
    public static int getCount() {
        return count;
    }
    public static void setNewMainText() {
        newMainText = TabPanelMain.getCurrentTextArea().getTextData().replaceAll(templateSearch, templateChange);
    }
    public static String getNewMainText() {
        return newMainText;
    }

}
