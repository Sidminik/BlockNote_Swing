package controller;

import javax.swing.*;
import java.awt.*;

public class ButtonPanelController extends JToolBar {
	public ButtonPanelController() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(250, 52));

		JButton createButton = new JButton(new ImageIcon("src/view/mainWindow/img/create.png"));
			createButton.setPreferredSize(new Dimension(40, 40));
			createButton.setContentAreaFilled(false);
			createButton.setFocusable(false);
			createButton.addActionListener(e -> {
				ActionAdapterController.createController();
			});
			createButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(createButton);

		JButton openButton = new JButton(new ImageIcon("src/view/mainWindow/img/open.png"));
			openButton.setPreferredSize(new Dimension(40, 40));
			openButton.setContentAreaFilled(false);
			openButton.setFocusable(false);
			openButton.addActionListener(e -> {
				ActionAdapterController.openController();
			});
			openButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(openButton);

		JButton saveButton = new JButton(new ImageIcon("src/view/mainWindow/img/save.png"));
			saveButton.setPreferredSize(new Dimension(40, 40));
			saveButton.setContentAreaFilled(false);
			saveButton.setFocusable(false);
			saveButton.addActionListener(e -> {
				ActionAdapterController.saveController();
			});
			saveButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(saveButton);

		JButton closeButton = new JButton(new ImageIcon("src/view/mainWindow/img/close.png"));
			closeButton.setPreferredSize(new Dimension(40, 40));
			closeButton.setContentAreaFilled(false);
			closeButton.setFocusable(false);
			closeButton.addActionListener(e -> {
				ActionAdapterController.closeController();
			});
			closeButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(closeButton);

		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setPreferredSize(new Dimension(1, 40));
		this.add(separator_1);

		JButton searchButton = new JButton(new ImageIcon("src/view/mainWindow/img/search.png"));
			searchButton.setPreferredSize(new Dimension(40, 40));
			searchButton.setContentAreaFilled(false);
			searchButton.setFocusable(false);
			searchButton.addActionListener(e -> {
				ActionAdapterController.searchController();
			});
			searchButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(searchButton);

		JButton changeButton = new JButton(new ImageIcon("src/view/mainWindow/img/change.png"));
			changeButton.setPreferredSize(new Dimension(40, 40));
			changeButton.setContentAreaFilled(false);
			changeButton.setFocusable(false);
			changeButton.addActionListener(e -> {
				ActionAdapterController.changeController();
			});
			changeButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(changeButton);

		JSeparator separator_2 = new JSeparator(SwingConstants.VERTICAL);
		separator_2.setPreferredSize(new Dimension(1, 40));
		this.add(separator_2);

		JButton helpButton = new JButton(new ImageIcon("src/view/mainWindow/img/help.png"));
			helpButton.setPreferredSize(new Dimension(40, 40));
			helpButton.setContentAreaFilled(false);
			helpButton.setFocusable(false);
			helpButton.addActionListener(e -> {
				ActionAdapterController.helpController();
			});
			helpButton.addKeyListener(ActionAdapterController.allKeyListener());
		this.add(helpButton);

	}
}
