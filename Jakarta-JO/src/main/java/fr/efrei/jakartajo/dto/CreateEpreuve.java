package fr.efrei.jakartajo.dto;

import java.time.LocalDateTime;

public class CreateEpreuve {

    private String name;

    private LocalDateTime dateEpreuve;

    public CreateEpreuve(String name, LocalDateTime dateEpreuve) {
        this.name = name;
        this.dateEpreuve = dateEpreuve;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateEpreuve() {
        return dateEpreuve;
    }

}
