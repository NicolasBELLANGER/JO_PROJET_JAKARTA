package fr.efrei.jakartajo.dto;

public class UpdateStade {
    
    private String name;
    private String adresse;

    public UpdateStade(String name, String adresse) {
		this.name = name;
		this.adresse = adresse;
	}

	public String getName() {
		return name;
	}

	public String getAdresse() {
		return adresse;
    }
}   

