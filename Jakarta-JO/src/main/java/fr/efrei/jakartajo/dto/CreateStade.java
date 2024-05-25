package fr.efrei.jakartajo.dto;

public class CreateStade {
    private String name;

    private String adresse;

    public CreateStade(String name, String adresse) {
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
