package fr.efrei.jakartajo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Acheteur {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private String firstName;
    private LocalDateTime deletedAt = null;

    public Acheteur() {
    }

    public Acheteur(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
