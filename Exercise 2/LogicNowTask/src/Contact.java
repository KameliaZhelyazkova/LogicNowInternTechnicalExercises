import java.util.ArrayList;

public class Contact implements IContact, IUpdateable {

	private int id;
	private String firstName;
	private String lastName;
	private IDatabasePersister persiter;

	public Contact(
			String firstName, 
			String lastName,
			IDatabasePersister persiter) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.persiter = persiter;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void save() {
		try {
			if (this.getId() == 0) {
				this.id = this.persiter.getContactTable().Add(this);
			} else {
				this.persiter.getContactTable().Update(this);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void delete() {
		try {
			if (this.getId() != 0) {
				this.persiter.getContactTable().Delete(this);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public ArrayList<DatabaseField> getDatabaseFields() {
		ArrayList<DatabaseField> pairs = new ArrayList<>();
		pairs.add(new DatabaseField("first_name", this.getFirstName(), DatabaseFieldType.STRING));
		pairs.add(new DatabaseField("last_name", this.getLastName(), DatabaseFieldType.STRING));

		return pairs;
	}
}
