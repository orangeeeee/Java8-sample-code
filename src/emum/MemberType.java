package emum;

public enum MemberType {

	NOMAL(1,"SRM"),
	PREMIUM(1,"SRM");
	
	private int key;
	private String name;
	
	private MemberType(int key, String name) {
		this.key = key;
		this.name= name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
