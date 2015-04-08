public class DatabaseField {
	private String fieldName;
	private String value;
	private DatabaseFieldType fieldType;

	public DatabaseField(String key, String value, DatabaseFieldType fieldType) {
		this.fieldName = key;
		this.value = value;
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public String getValue() {
		return this.value;
	}

	public String setFieldName(String fieldName) {
		return this.fieldName = fieldName;
	}

	public String setValue(String value) {
		return this.value = value;
	}

	public DatabaseFieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(DatabaseFieldType filedType) {
		this.fieldType = filedType;
	}
}
