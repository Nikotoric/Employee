import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {

	private JLabel nameLabel, surnameLabel, departmentLabel, qualificationLabel, addOnLabel;
	private JTextField nameField, surnameField;
	private JComboBox<String> comboDepartment;
	private JRadioButton highQualification, lowQualification;
	private JCheckBox wageAddOn, overtimeAddOn, childrenAddOn;
	private JButton submitBtn, cancelBtn;

	public LeftPanel() {
		
		createComps();
		layoutComps();

	}

	private void createComps() {

		nameLabel = new JLabel("Name -");
		nameField = new JTextField(10);

		surnameLabel = new JLabel("Surname -");
		surnameField = new JTextField(10);

		departmentLabel = new JLabel("Department -");
		comboDepartment = new JComboBox<>();
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();
		boxModel.addElement("Marketing department");
		boxModel.addElement("Production department");
		boxModel.addElement("Finance department");
		boxModel.addElement("Personnel department");
		comboDepartment.setModel(boxModel);
		comboDepartment.setSelectedIndex(0);

		qualificationLabel = new JLabel("Qualification: ");
		ButtonGroup qualifications = new ButtonGroup();
		highQualification = new JRadioButton("High qualification");
		lowQualification = new JRadioButton("Low qualification");
		qualifications.add(highQualification);
		qualifications.add(lowQualification);
		highQualification.setSelected(true);

		addOnLabel = new JLabel("Add ons -");
		wageAddOn = new JCheckBox("Wage add-on");
		overtimeAddOn = new JCheckBox("Overtime");
		childrenAddOn = new JCheckBox("Children add-on");
		
		submitBtn = new JButton("ADD EMPLOYEE");
		cancelBtn = new JButton("Cancel");

	}

	private void layoutComps() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// name - label, field
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(nameLabel, gbc);

		gbc.gridx = 1;
		add(nameField, gbc);

		// surname - label, field
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(surnameLabel, gbc);

		gbc.gridx = 1;
		add(surnameField, gbc);

		// department - label, combobox
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(departmentLabel, gbc);

		gbc.gridx = 1;
		add(comboDepartment, gbc);

		// qualifications
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(qualificationLabel, gbc);
		
		gbc.gridx = 1;
		add(highQualification, gbc);

		gbc.gridx = 2;
		add(lowQualification, gbc);

		// add-ons
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(addOnLabel, gbc);
		
		gbc.gridx = 1;
		add(wageAddOn, gbc);

		gbc.gridy = 5;
		add(overtimeAddOn, gbc);

		gbc.gridy = 6;
		add(childrenAddOn, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 7;
		add(submitBtn, gbc);
		
		gbc.gridx = 1;
		add(cancelBtn, gbc);

	}
	
	public void resetInputData() {
		nameField.setText("");
		surnameField.setText("");
		comboDepartment.setSelectedIndex(0);
		highQualification.setSelected(true);
		wageAddOn.setSelected(false);
		overtimeAddOn.setSelected(false);
		childrenAddOn.setSelected(false);
	}
	
	public String getAddOn() {
		String addOn="";
		
		if(wageAddOn.isSelected() && overtimeAddOn.isSelected() && childrenAddOn.isSelected()) {
			addOn = wageAddOn.getText() + ", " + overtimeAddOn.getText() +  ", " + childrenAddOn.getText();
		} else if(wageAddOn.isSelected() && overtimeAddOn.isSelected()) {
			addOn = wageAddOn.getText() + ", " + overtimeAddOn.getText();
		} else if(wageAddOn.isSelected() && childrenAddOn.isSelected()) {
			addOn = wageAddOn.getText() + ", " + childrenAddOn.getText(); 
			} else if(overtimeAddOn.isSelected() && childrenAddOn.isSelected()) {
			addOn = overtimeAddOn.getText() + ", " + childrenAddOn.getText();
		} else if(wageAddOn.isSelected()) {
			addOn = wageAddOn.getText();
		} else if(overtimeAddOn.isSelected()) {
			addOn = overtimeAddOn.getText();
		} else if(childrenAddOn.isSelected()) {
			addOn = childrenAddOn.getText();
		}	
		return addOn;
	}



	public String getNameField() {
		return nameField.getText();
	}

	public String getSurnameField() {
		return surnameField.getText();
	}

	public String getComboDepartment() {
		return comboDepartment.getSelectedItem().toString();
	}

	public String getQualification() {
		
		if(highQualification.isSelected()) {
			return highQualification.getText();
		}else {
			return lowQualification.getText();
		}
		
	}

	public JButton getSubmitBtn() {
		return submitBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}
	
	
		
}
