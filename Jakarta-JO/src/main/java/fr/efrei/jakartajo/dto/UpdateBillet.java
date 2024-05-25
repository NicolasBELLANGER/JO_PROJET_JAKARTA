package fr.efrei.jakartajo.dto;

public class UpdateBillet {
    
    private String name;
    private Float price;

    public UpdateBillet(String name, Float price) {
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

