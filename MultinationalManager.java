import java.util.ArrayList;
import java.util.Comparator;


/**
 *  This class maintains an ArrayList that stores a list of companies and graph that indicates the relationship of those companies.
 *  Your task is to correctly implement the method bodies for:
 * 
 *  	protected boolean isConnected(Graph graph, Company i, Company j)
 *  	protected ArrayList<Company> mergeSort(ArrayList<Company> list, boolean ascending, String attr)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local modules object as a parameter. You can observe calls to these public
 *  methods in the go method of ManagerTest.java.  
 */
public class MultinationalManager
{
	private ArrayList<Company> companies;
	private Graph graph;
	
	public MultinationalManager()
	{
		companies = new ArrayList<Company>();
		graph = new Graph();
	}
	
	/**
	 * Cleans the object
	 */
	public void clear()
	{
		for (Company v : companies)
		{
			v.getBtree().clear();
		}
		companies.clear();
		graph = new Graph();
	}
	/**
	 * Add a company
	 * @param v the new company
	 */
	public void addCompany(Company v)
	{
		companies.add(v);
	}
	/**
	 * Get all companies
	 * @return An arraylist of companies
	 */
	public ArrayList<Company> getCompanies()
	{
		return companies;
	}
	/**
	 * Get the graph
	 * @return the graph
	 */
	public Graph getGraph()
	{
		return graph;
	}
	/**
	 * Add a new relationship (i.e., edge) between two companies (i <-> j)
	 * @param i Company
	 * @param j Company
	 */
	public void addRelationship(Company i, Company j) {
		graph.insertEdge(i, j);
	}
	public void describeCompanies()
	{
		for (Company v : companies)
		{
			System.out.println(v.toString());
			v.describeStudentTree();
		}
	}
	
	/**
	 * This method calls the tree walk method for a specific Company
	 * @param val The index of the company that you want to call the method for
	 * @return A String with the names of all Customers in the tree
	 */
	public String walkTree(int val)
	{
		return companies.get(val).walkTree();
	}
	
	/**
	 * This method calls the find method for a specific Company
	 * @param val The index of the company that you want to call the method for
	 * @param name Name of the customer we are looking for
	 * @return A reference to the Customer that was found or null if no Customer found
	 */
	public Customer find(int val, String name)
	{
		return companies.get(val).find(name);
	}
	
	/**
	 * This method calls the protected isConnected to find if two nodes are somehow connected in the graph.
	 * 
	 * You should not modify this code.
	 */
    public boolean isConnected(Company i, Company j)
    {
    	return isConnected(this.graph, i, j);
    }
    
	/**
	 * This method should search and find if two nodes are somehow connected in an undirected graph.
	 *
     * @param graph The graph
	 * @param i the starting node
	 * @param j the ending node
	 * 
 	 * @return true, if nodes i and j are connected in any way, false otherwise
	 */
    protected boolean isConnected(Graph graph, Company i, Company j)
    {
    	/*
    	 * TODO implement here
    	 */
		return false;
    }

	/**
	 * This method should use merge sort approach to rearrange
	 * the references in the ArrayList of 'Company' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
	 * @return	The ArrayList of 'Company' that has been sorted using merge sort
	 */
    public ArrayList<Company> mergeSort(boolean asc, String attr)
    {	
    	ArrayList<Company> sorted = new ArrayList<Company>(companies);
    	return mergeSort(sorted, asc, attr);
    }
    
    /**
	 * This method should use merge sort approach to rearrange
	 * the references in the ArrayList of 'Company' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * @param list The arraylist to be sorted
	 * @param ascending True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
	 * @return	The ArrayList of 'Company' that has been sorted using merge sort
	 */
    protected ArrayList<Company> mergeSort(ArrayList<Company> list, boolean ascending, String attr)
    {
		ArrayList<Company> left = new ArrayList<>(); //This ArrayList will be the left side to sort
		ArrayList<Company> right = new ArrayList<>(); //This ArrayList will be the right one to sort
		ArrayList<Company> sorted = new ArrayList<>(); //This is the ArrayList which the sorted entries will be stored in

		//This checks if the list is empty, not having this will cause a StackOverflowError, which will produce 1024 lines of errors
		if (list.size() <= 1){ //Just for reference, that is around 1000 more errors than my code averages
			return list;
		}
		else
		{



			//For Loop will split the list and put the attributes into each side
			for (int i = 0; i < list.size(); i++)
			{
				if (i < list.size() / 2) {
					left.add(list.get(i)); //Add to left
				} else {
					right.add(list.get(i)); //Add to right
				}
			}
			left = mergeSort(left, ascending, attr);

			right = mergeSort(right, ascending, attr);


			while ((left.isEmpty() || right.isEmpty()) == false) //While loop will keep going until both ArrayLists are empty
			{

				if(attr == "name") //Checking what the attr parameter equals
				{
					if(ascending == true) //Checking the ascending variable passed in @go in ManagerTest.java
					{

						//The Following section will add elements to the sorted ArrayList. As attr == "name" this is taking the company names and comparing them
						//This will sort in Ascending order
						if(left.get(0).getName().compareTo(right.get(0).getName()) < 0)
						{
							sorted.add(left.remove(0));

						}

						else
						{
							sorted.add(right.remove(0));

						}
					}
					//This is the same as above but will sort in descending order instead
					else
					{
						if(left.get(0).getName().compareTo(right.get(0).getName()) > 0)
						{
							sorted.add(right.remove(0));

						}//right and left are switched in comparison to the ascending sort in order to make this sort descending
						else
						{
							sorted.add(left.remove(0));

						}
					}

				}
				else if (attr == "code") //Now this will sort the code variable. This is based off of what is passed in ManagerTest.java
				{
					if(ascending == true) //Checking the ascending variable passed in @go in ManagerTest.java
					{
						if(left.get(0).getCode() > right.get(0).getCode())
						{
							sorted.add(left.remove(0));

						}
						else
						{
							sorted.add(right.remove(0));

						}
					}
					else
					//This is the same as above but will sort in descending order instead
					{
						if(left.get(0).getCode() < right.get(0).getCode())
						{
							sorted.add(right.remove(0));

						}//right and left are switched in comparison to the ascending sort in order to make this sort descending
						else
						{
							sorted.add(left.remove(0));
						}
					}
				}
			}
			//This makes sure that all sorted values are displayed. Without this only the first value of each sorted list will display
			while(left.isEmpty() == false)
			{
				sorted.add(left.remove(0));
			}
			while(right.isEmpty() == false)
			{
				sorted.add(right.remove(0));
			}
			return sorted; //return sorted when all the sorting is done successfully
		}
	}
}//I am fully aware how badly I formatted that section, the method was just so big though that I needed more whitespace in order to
// be able to read and actually see what I'm doing
