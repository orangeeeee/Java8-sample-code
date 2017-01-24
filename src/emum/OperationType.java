package emum;

public enum OperationType implements kubun {

	NEW("1", "NEW"),
	CHANGE("2", "CHANGE"),
	DELETE("3", "DELETE");
	
	private String key;
	private String name;

	private OperationType(String key, String name) {
		this.key = key;
		this.name= name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
