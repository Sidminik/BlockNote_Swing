package controller;

import view.mainWindow.*;

public class Main {
	public static MainWindow start;
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			start = new MainWindow();
		});
	}
}
