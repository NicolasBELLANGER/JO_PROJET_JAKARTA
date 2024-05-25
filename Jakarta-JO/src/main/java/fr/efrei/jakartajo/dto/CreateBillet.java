package fr.efrei.jakartajo.dto;

public class CreateBillet {
    private String name;

    private Float price;

    public CreateBillet(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}
