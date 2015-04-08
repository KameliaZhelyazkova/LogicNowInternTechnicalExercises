
/**
 * 
 * Represents a contact entity in the contact DB table
 *
 */
public interface IContact {
	
	/**
	 * Getter for the first name
	 * @return The first name of the contact
	 */
	String getFirstName();
	
	/**
	 * Setter for the first name
	 * @param The first name of the contact
	 */
	void setFirstName(String firstName);
	
	/**
	 * Getter for the last name of the contact
	 * @return The last name of the contact
	 */
	String getLastName();
	
	/**
	 * Setter for the last name of the contact
	 * @param The last name of the cotnact
	 */
	void setLastName(String lastName);
	
	/**
	 * Saves the entity to the DB
	 */
	void save();
	
	/**
	 * Deletes the entity form the DB
	 */
	void delete();
	
}
