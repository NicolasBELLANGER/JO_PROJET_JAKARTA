package fr.efrei.jakartajo.dto;

public class UpdateAcheteur {
    
    private String name;
	
    private String firstName;

    public UpdateAcheteur(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
    }
}   
