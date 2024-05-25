package fr.efrei.jakartajo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "acheteur_id")
    private Acheteur acheteur;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    private Epreuve epreuve;

    private String name;
    private Float price;
    private LocalDateTime deletedAt = null;

    public Billet() {

    }

    public Billet(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public Acheteur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Acheteur acheteur) {
        this.acheteur = acheteur;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}
