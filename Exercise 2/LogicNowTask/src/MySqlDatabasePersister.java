import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabasePersister implements IDatabasePersister {
	private String databaseName;
	private String username;
	private String password;
	private Connection connect = null;
	private DatabaseTable contanctTable = null;

	public MySqlDatabasePersister(String databaseName, String username,
			String password) {
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
		this.loadConnection();
		this.contanctTable = new DatabaseTable("contact", this.connect);
	}

	public DatabaseTable getContactTable() {
		return this.contanctTable;
	}

	private void loadConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String connectionString = String.format(
					"jdbc:mysql://localhost/%s?user=%s&password=%s",
					this.databaseName, this.username, this.password);

			// Setup the connection with the DB
			connect = DriverManager.getConnection(connectionString);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
