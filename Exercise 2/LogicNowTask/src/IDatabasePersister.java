
/**
 * 
 * Represent a whole DB and holds its containing tables
 *
 */
public interface IDatabasePersister {
	
	/**
	 * Used for acquiring the contact table form the DB
	 * @return The contact table form the DB
	 */
	IDatabaseTable getContactTable();
}
