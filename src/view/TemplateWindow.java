package view;

import javax.swing.*;

public abstract class TemplateWindow extends JFrame {
    public TemplateWindow(String nameWindow, int widthWindow, int heightWindow, boolean resizableWindow) {
        this.setTitle(nameWindow);
        this.setSize(widthWindow, heightWindow);

        ImageIcon img = new ImageIcon("src/view/mainWindow/img/frame.png");
        this.setIconImage(img.getImage());

        this.setResizable(resizableWindow);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(TemplateWindow.DISPOSE_ON_CLOSE);
    }
}
