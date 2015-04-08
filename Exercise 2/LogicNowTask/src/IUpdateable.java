import java.util.ArrayList;

/**
 * 
 * Objects that want to interact with the DB through the DB persister need to implement this
 */
public interface IUpdateable {
	
	/**
	 * Used for acquiring the id of the object
	 * @return The ID of the object
	 */
	int getId();
	
	/**
	 * Used for acquiring a list of the DB fields in this object excluding the ID
	 * @return an array list with all the DB fields in this object excluding the ID
	 */
	ArrayList<DatabaseField> getDatabaseFields();
}
