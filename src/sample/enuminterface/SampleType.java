package sample.enuminterface;

public enum SampleType implements SampleEnumIf<SampleType> {

	NOMAL("1"),
	PREMIUM("2");

	private String code;

	private SampleType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
