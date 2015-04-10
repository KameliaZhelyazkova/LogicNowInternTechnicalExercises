
public class Mailstore {
	private String name;
	private boolean isMounted;
	
	public Mailstore(String name, boolean isMounted) {
		this.setName(name);
		this.setMounted(isMounted);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMounted() {
		return this.isMounted;
	}

	public void setMounted(boolean isMounted) {
		this.isMounted = isMounted;
	}

}