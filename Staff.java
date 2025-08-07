import java.util.HashMap;

public class Staff extends Individual
{
	protected static int MAX_NUM_CUSTOMERS = 3; // maximum number of clients that a employee can be responsible for
	
	protected String contract_date;  // this is the date in which the staff has been hired
	protected String work_shift; // work shift - 00-08 or 08-16 or 16-00
	protected HashMap<Integer, Customer> customerList; // stores customers with id as key
	protected boolean canDoubleShift = false; //Stores whether a staff member can do a double shift


	/**
	 * Constructor
	 * @param fn Full Name
	 * @param rn id Number
	 * @param em Email
	 * @param c Contract date
	 * @param ws Work shift

	 */
	public Staff(String fn, int rn, String em, String c, String ws) {
		super(fn,rn,em); //Calls to the Individual class in order to reduce code replication
		this.contract_date = c;
		this.work_shift = ws;
		this.customerList = new HashMap<>();
	}

	/**
	 * @param fn Full Name
	 * @param rn id Number
	 * @param em Email
	 * @param c Contract date
	 * @param ws Work shift
	 * @param list Customer List
	 * @param canDouble Can Double Shift
	*/
	public Staff(String fn, int rn, String em, String c, String ws, HashMap<Integer, Customer> list, boolean canDouble) {
		super(fn,rn,em); //Calls to the Individual class in order to reduce code replication
		this.contract_date = c;
		this.work_shift = ws;
		this.customerList = list;
		this.canDoubleShift = canDouble;
	}

	// gets and sets

	public String getContractDate() {
		return contract_date;
	}
	public void setContractDate(String cd) {
		this.contract_date = cd;
	}

	public String getWork_shift() {
		return work_shift;
	}
	public void setWork_shift(String work_shift) {
		this.work_shift = work_shift;
	}

	public HashMap<Integer, Customer> getCustomerList(){return customerList;}
	public void setCustomerList(HashMap<Integer, Customer> list){this.customerList = list;}

	public boolean getCanDoubleShift(){return canDoubleShift;}
	public void setCanDoubleShift(boolean doubleShift){this.canDoubleShift = doubleShift;}

	/**
	 * Add a new customer to the list of customers of the employee
	 * @param d -The new customer to be added
	 * @return true if the customer was added successfully
	 */
	public boolean addCustomer(Customer d) {
		if (customerList.size() < MAX_NUM_CUSTOMERS) { //Check whether the customer list is full
			customerList.put(d.idNumber, d);
			//This will check if the customer is in the list yet, as it is a HashMap a value with the corresponding key can only be added once
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Remove a customer of the list of customers of the employee
	 * @return true if the customer was removed successfully
	 */
	public boolean removeCustomer(Customer d) {
		if (customerList.remove(d.idNumber) == null) { //This checks if the id is equal to the value corresponding to d
			return false;
		}
		return true;
	}
		
	public String toString() {
		return "Staff: " + fullName; 
	}
}
