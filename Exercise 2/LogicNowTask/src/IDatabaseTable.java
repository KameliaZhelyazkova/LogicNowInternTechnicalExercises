import java.sql.SQLException;

/**
 * 
 * Represents a DB table
 *
 */
public interface IDatabaseTable {
	
	/**
	 * 
	 * Used for inserting entities to the DB
	 * @param databseObject - A DB object implementing the IUpdateable interface
	 * @return the ID of the inserted object
	 * @throws SQLException
	 */
	int Add(IUpdateable databseObject) throws SQLException;
	
	/**
	 * Used for updating an existing DB entity 
	 * @param databaseObject - A DB object implementing the IUpdateable interface
	 * @return the number of updated records
	 * @throws SQLException
	 */
	int Update(IUpdateable databaseObject) throws SQLException;
	
	/**
	 * Used for deleting a DB entity
	 * @param databaeObject - A DB object implementing the IUpdateable interface
	 * @return - True if the delete process succeeds - false otherwise
	 * @throws SQLException
	 */
	boolean Delete(IUpdateable databaeObject) throws SQLException;
}
