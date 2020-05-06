import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RightPanel extends JPanel {

	private JPanel mainPanel, bottomPanel;
	private JTextArea viewData;
	private JScrollPane scroll;
	private JButton searchBtn, clearBtn;

	public RightPanel() {

		createComps();
		layoutComps();


	}

	private void createComps() {

		mainPanel = new JPanel();

		viewData = new JTextArea();
		

		searchBtn = new JButton("Search");
		searchBtn.setEnabled(false);
		clearBtn = new JButton("Clear view");

	}

	private void layoutComps() {

		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(searchBtn, BorderLayout.NORTH);
		
		viewData.setPreferredSize(new Dimension(250, 280));
		scroll = new JScrollPane(viewData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		mainPanel.add(scroll, BorderLayout.CENTER);
		mainPanel.add(clearBtn, BorderLayout.SOUTH);

		add(mainPanel);

	}

	public void resetViewData() {
		viewData.selectAll();
		viewData.setText("");
	}

	public JTextArea getViewData() {
		return viewData;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

}
