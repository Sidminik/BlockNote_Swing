package view.helpWindow;

import javax.swing.*;
import java.awt.*;

public class RowConstructorHelp extends JPanel {
    public RowConstructorHelp(String iconPath, String key, String menu, String description, Color borderColor) {
        this.setPreferredSize(new Dimension(625, 45));

        JLabel col_1 = new JLabel(menu, SwingConstants.LEFT);
        col_1.setPreferredSize(new Dimension(110, 20));
        col_1.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        col_1.setOpaque(true);
        col_1.setBackground(Color.WHITE);
        this.add(col_1);

        JLabel col_2 = new JLabel(key, SwingConstants.CENTER);
        col_2.setPreferredSize(new Dimension(60, 40));
        this.add(col_2);

        JLabel col_3 = new JLabel(new ImageIcon(iconPath));
        col_3.setPreferredSize(new Dimension(40, 40));
        this.add(col_3);

        JLabel col_4 = new JLabel(description, SwingConstants.LEADING);
        col_4.setPreferredSize(new Dimension(395, 40));
        col_4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.add(col_4);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

    }
}
