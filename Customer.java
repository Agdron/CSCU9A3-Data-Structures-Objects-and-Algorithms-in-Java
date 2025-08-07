
public class Customer extends Individual
{

	protected int phone;  // phone of the customer
	protected String company;  // company of the customer

	/**
	 * Constructor
	 * @param fn Full name
	 * @param rn id number
	 * @param em email
	 * @param pn phone number
	 * @param c company
	 */
	public Customer(String fn, int rn, String em, int pn, String c) {
		super(fn,rn,em); //Calls to the Individual class in order to reduce code replication

		this.phone = pn;
		this.company = c;
	}

	// gets and sets

	public int getTableNum() {
		return phone;
	}
	public void setTableNum(int tableNum) {
		this.phone = tableNum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String c) {
		this.company = c;
	}

	/**
	 * Get a description of this class as a String
	 */
	public String toString() {
		return "Customer - Name: " + fullName + " - Company: " + company;
	}

}
