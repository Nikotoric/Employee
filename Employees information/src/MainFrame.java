import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	private LeftPanel inputData;
	private RightPanel viewData;
	private SearchPanel searchPanel;
	private ArrayList<Employee> database;
	private Data data;
	private Employee employee;

	public MainFrame() {

		super("Employees information");
		setVisible(true);
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createComps();
		layoutComps();
		activateComps();

	}

	private void activateComps() {

		inputData.getSubmitBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				employee = new Employee(inputData.getNameField(), inputData.getSurnameField(),
						inputData.getComboDepartment(), inputData.getQualification(), inputData.getAddOn());

				database.add(employee);

				viewData.getViewData().append("ID: " + employee.getId() + "\n");
				viewData.getViewData().append("Name: " + employee.getName() + "\n");
				viewData.getViewData().append("Surname: " + employee.getSurname() + "\n");
				viewData.getViewData().append("Department: " + employee.getDepartment() + "\n");
				viewData.getViewData().append("Qualification: " + employee.getQualification() + "\n");
				viewData.getViewData().append("Add-ons: " + employee.getAddOns() + "\n");

				
				if(employee.getId() >= 3) {
					viewData.getSearchBtn().setEnabled(true);
				}
			
				inputData.resetInputData();
				
			}
			
		});
		
		
		inputData.getCancelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				inputData.resetInputData();

			}
		});
		
		viewData.getSearchBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(employee.getId() >= 3) {
					
					searchPanel = new SearchPanel(new JFrame());
					SearchDataEvent sde = new SearchDataEvent(this);
					sde.setBaseEmployees(database);
					
					searchPanel.getBase(sde);
					
				}
				
			}
		});
		
		viewData.getClearBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				viewData.resetViewData();
				
			}
		});

	}

	private void createComps() {

		inputData = new LeftPanel();
		viewData = new RightPanel();
		database = new ArrayList<>();

		borders();

	}

	private void layoutComps() {

		setLayout(new FlowLayout());

		add(inputData);
		add(viewData);

	}

	private void borders() {

		Border bottom = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border input = BorderFactory.createTitledBorder("Information");
		Border view = BorderFactory.createTitledBorder("View");

		inputData.setBorder(BorderFactory.createCompoundBorder(input, bottom));
		viewData.setBorder(BorderFactory.createCompoundBorder(view, bottom));

	}

	public void setData(Data data) {
		this.data = data;
	}

}
