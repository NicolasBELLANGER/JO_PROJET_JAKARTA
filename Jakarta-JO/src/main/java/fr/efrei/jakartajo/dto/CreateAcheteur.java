package fr.efrei.jakartajo.dto;

public class CreateAcheteur {

    private String name;

    private String firstName;

    public CreateAcheteur(String name, String firstName) {
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
