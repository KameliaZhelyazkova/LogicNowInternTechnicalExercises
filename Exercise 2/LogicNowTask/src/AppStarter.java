
/**
 * 
 * Main entry point for our application
 *
 */
public class AppStarter {
	public static void main(String[] args) throws Exception {
		IDatabasePersister mySqlPersister = new MySqlDatabasePersister("logicnowexdb", "root", "");
		Contact myCustomer = new Contact("Kami", "test", mySqlPersister);
		myCustomer.save();
		
		Contact anotherCustomer = new Contact("Teo", "test", mySqlPersister);
		anotherCustomer.save();
		
		Contact thirdCustomer = new Contact("Meo", "test", mySqlPersister);
		thirdCustomer.save();

		
//		myCustomer.setFirstName("Kami Kami");
//		myCustomer.save();
//		myCustomer.delete();
	}
}
