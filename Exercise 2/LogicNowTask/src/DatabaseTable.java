
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseTable extends BaseDatabaseTable implements IDatabaseTable {
	private String tableName;

	public DatabaseTable(String tableName, Connection connection) {
		super(connection);
		this.tableName = tableName;
	}

	public int Add(IUpdateable databaseObject) throws SQLException {
		try {
			ArrayList<DatabaseField> pairs = databaseObject.getDatabaseFields();
			String sqlStatement = "INSERT INTO " + this.tableName
					+ " VALUES (default,"
					+ this.createPreparedStatementPlaceholders(pairs.size()) + ");";
			
			PreparedStatement statement = this.connection.prepareStatement(sqlStatement, PreparedStatement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < pairs.size(); i++) {
				statement.setString(i + 1, pairs.get(i).getValue());
			}
			
			int affectedRows = statement.executeUpdate();
			

	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
		} catch (Exception e) {
			this.close();
			throw e;
		}

	}

	public int Update(IUpdateable databaseObject) throws SQLException {
		try {
			ArrayList<DatabaseField> pairs = databaseObject.getDatabaseFields();
			
			String updateValues = this.createPreparedStatementUpdateString(pairs);
			String sqlQuery = "UPDATE " + this.tableName + " SET " + updateValues + " WHERE id=" + databaseObject.getId();
			
			PreparedStatement statement = this.connection.prepareStatement(sqlQuery);
			
			for (int i = 0; i < pairs.size(); i++) {
				statement.setString(i + 1, pairs.get(i).getValue());
			}
			
			int affectedRows = statement.executeUpdate();
			
			return affectedRows;
			
		} catch (Exception e) {
			this.close();
			throw e;
		}
	}

	public boolean Delete(IUpdateable databaseObject) throws SQLException {
		try {
			String sqlQuery = "DELETE FROM " + this.tableName
					+ " WHERE id= ? ; ";

			PreparedStatement statement = this.connection
					.prepareStatement(sqlQuery);
			statement.setInt(1, databaseObject.getId());
			
			int affectedRows = statement.executeUpdate();
			
			return affectedRows == 1;

		} catch (Exception e) {
			this.close();
			throw e;
		}
	}
}
