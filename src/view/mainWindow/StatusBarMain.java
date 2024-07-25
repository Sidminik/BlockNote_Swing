package view.mainWindow;

import javax.swing.*;
import java.awt.*;

public class StatusBarMain extends JLabel {
    public StatusBarMain() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        this.setText("Позиция курсора: 0 символ");
    }
}
