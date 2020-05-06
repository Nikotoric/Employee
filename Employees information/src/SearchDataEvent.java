import java.util.ArrayList;
import java.util.EventObject;

public class SearchDataEvent extends EventObject {

	private ArrayList<Employee> baseEmployees;

	public SearchDataEvent(Object source) {
		super(source);
	}

	public ArrayList<Employee> getBaseEmployees() {
		return baseEmployees;
	}

	public void setBaseEmployees(ArrayList<Employee> baseEmployees) {
		this.baseEmployees = baseEmployees;
	}
}
