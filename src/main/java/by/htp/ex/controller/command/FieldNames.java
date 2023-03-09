package by.htp.ex.controller.command;

public enum FieldNames {
	
	PRESENTATION("presentation"), LINK_LOCALE("link_locale"), ERROR("error"),
	LOGIN("login"), PASSWORD("password"), EMAIL("email"), COMMAND("command"), NEWS("news"),ID_NEWS("idNews"), 
	LINK("link"), LOCALE("locale"), GUEST("guest"), USER("user"), ROLE("role"), ID_USER("idUser"), ID("id"),
	COUNT(5), TITLE("title"), BRIEF("briefNews"), CONTENT("content"), ADMIN("admin");
	
	private String fieldName;
	private int number;
	
	
	private FieldNames(String fieldName) {
		this.fieldName = fieldName;
	}


	private FieldNames(int number) {
		this.number = number;
	}


	public String getFieldName() {
		return fieldName;
	}


	public int getNumber() {
		return number;
	}


	
	
	
	

}
