package view.mainWindow;

import controller.ActionAdapterController;
import view.*;

import java.awt.*;

public class MainWindow extends TemplateWindow {
	public static TabPanelMain tabPanelMain;
	public static StatusBarMain statusBar;
	public MainWindow() {
		super("Блокнот", 800, 600, true);
		this.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);

		this.getContentPane().setBackground(Color.LIGHT_GRAY);

		ActionAdapterController controller = new ActionAdapterController();
		this.add(controller, BorderLayout.NORTH);

		tabPanelMain = new TabPanelMain();
		this.add(tabPanelMain, BorderLayout.CENTER);

		statusBar = new StatusBarMain();
		this.add(statusBar, BorderLayout.SOUTH);

		this.setVisible(true);

		TabPanelMain.setCurrentTextArea();
	}
}
