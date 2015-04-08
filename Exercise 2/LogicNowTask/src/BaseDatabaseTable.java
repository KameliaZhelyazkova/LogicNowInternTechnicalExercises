import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Basic implementation of the DatabasleTable
 *
 */
public abstract class BaseDatabaseTable {
	protected Connection connection = null;

	protected BaseDatabaseTable(Connection connection) {
		this.connection = connection;
	}
	
	protected String createPreparedStatementPlaceholders(int numberOfFields) {
		String result = "";

		for (int i = 0; i < numberOfFields; i++) {
			if (i == numberOfFields - 1) {
				result += ",?";
			} else {
				result += "?";
			}
		}

		return result;
	}

	protected String createPreparedStatementUpdateString(
			ArrayList<DatabaseField> fields) {
		String result = "";

		for (int i = 0; i < fields.size(); i++) {
			result += fields.get(i).getFieldName() + "=?";

			if (i != fields.size() - 1) {
				result += ",";
			}
		}

		return result;
	}

	protected PreparedStatement setPreparedStatementParams(
			PreparedStatement statement, ArrayList<DatabaseField> fields)
			throws SQLException {
		
		for (int i = 0; i < fields.size(); i++) {
			DatabaseField field = fields.get(i);
			
			if (field.getFieldType() == DatabaseFieldType.STRING) {
				statement.setString(i + 1, field.getValue());
			} else if (field.getFieldType() == DatabaseFieldType.INT) {
				statement.setInt(i + 1, Integer.parseInt(field.getValue()));
			} else {
				throw new SQLException("Unknown field type for prepared statement!");
			}
		}

		return statement;
	}

	protected void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
		}
	}
}
