
public class Employee {

	private static int cnt = 1;
	private int id;
	private String name, surname, department, qualification, addOns;

	public Employee(int id, String name, String surname, String department, String qualification, String addOns) {
		super();
		this.id = cnt;
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.qualification = qualification;
		this.addOns = addOns;
		cnt++;
	}

	public Employee(String nameField, String surnameField, String comboDepartment, String qualification2,
			String addOn) {
		
		this.id = cnt;
		this.name = nameField;
		this.surname = surnameField;
		this.department = comboDepartment;
		this.qualification = qualification2;
		this.addOns = addOn;
		cnt++;
		
	}

	public static int getCnt() {
		return cnt;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDepartment() {
		return department;
	}

	public String getQualification() {
		return qualification;
	}

	public String getAddOns() {
		return addOns;
	}

	public static void setCnt(int cnt) {
		Employee.cnt = cnt;
	}

}
