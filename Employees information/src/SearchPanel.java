import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.omg.CORBA.IdentifierHelper;

public class SearchPanel extends JDialog implements Data {

	private JPanel upperPanel, mainPanel;
	private JLabel name, surname, id;
	private JTextField nameField, surnameField, idField;
	private JTextArea viewData;
	private JScrollPane scroll;
	private JButton showBtn, exitBtn, listBtn;

	private ArrayList<Employee> database;
	private Employee employee;

	public SearchPanel(JFrame frame) {

		super(frame, "Search panel", false);
		setVisible(true);
		setSize(700, 450);
		setLocationRelativeTo(null);

		createComps();
		createLayout();
		activateComps();

	}

	private void activateComps() {

		showBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int searchID = Integer.parseInt(idField.getText());
				employee = searchEmployee(searchID);

				nameField.setText(employee.getName());
				surnameField.setText(employee.getSurname());

			}

		});

		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		listBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int searchID = Integer.parseInt(idField.getText());
				employee = searchEmployee(searchID);

				viewData.append("ID: " + employee.getId() + "\n");
				viewData.append("Name: " + employee.getName() + "\n");
				viewData.append("Surname: " + employee.getSurname() + "\n");
				viewData.append("Department: " + employee.getDepartment() + "\n");
				viewData.append("Qualification: " + employee.getQualification() + "\n");
				viewData.append("Add-ons: " + employee.getAddOns() + "\n");

			}
		});

	}

	private void createComps() {

		mainPanel = new JPanel();
		upperPanel = new JPanel();

		name = new JLabel("Name");
		nameField = new JTextField(10);
		nameField.setEditable(false);

		surname = new JLabel("Surname");
		surnameField = new JTextField(10);
		surnameField.setEditable(false);

		id = new JLabel("Enter employee ID:");
		idField = new JTextField(10);

		viewData = new JTextArea();
		scroll = new JScrollPane(viewData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		showBtn = new JButton("Search by ID");
		exitBtn = new JButton("Exit display");
		listBtn = new JButton("Info about employee");

		database = new ArrayList<>();

	}

	private void createLayout() {

		mainPanel.setLayout(new GridLayout(2, 1));

		upperPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		upperPanel.add(id, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		upperPanel.add(idField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		upperPanel.add(showBtn, gbc);

		gbc.gridx = 1;
		upperPanel.add(exitBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		upperPanel.add(listBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		upperPanel.add(name, gbc);
		gbc.gridx = 1;
		upperPanel.add(nameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		upperPanel.add(surname, gbc);
		gbc.gridx = 1;
		upperPanel.add(surnameField, gbc);

		Border top = BorderFactory.createTitledBorder("Data");
		Border bottom = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		upperPanel.setBorder(BorderFactory.createCompoundBorder(top, bottom));

		mainPanel.add(upperPanel, BorderLayout.NORTH);

		mainPanel.add(scroll, BorderLayout.CENTER);

		add(mainPanel);

	}

	private Employee searchEmployee(int id) {
		boolean flag = false;

		for (Employee employee : database) {
			if (employee.getId() == id) {
				flag = true;
				return employee;
			}
		}

		if (flag == false) {
			JOptionPane.showMessageDialog(null, "There's no employee with the entered ID", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}

	@Override
	public void getBase(SearchDataEvent sEvent) {

		database = sEvent.getBaseEmployees();

	}

}
