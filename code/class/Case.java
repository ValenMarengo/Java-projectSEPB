package classes;

import interfaces.I_Case;

public class Case implements I_Case{

	public Person owner;
	public Animal animal;
	Treatment treatment;
	
	public Case() {
		this.owner = null;
		this.animal = null;
		this.treatment = null;
	}
	
	public Case(Person owner, Animal animal , Treatment treatment) {
		this.owner = owner;
		this.animal = animal;
		this.treatment = treatment;
	}	
	
	public Person getOwner() {
		return owner;
	}
	
    public Animal getAnimal() {
    	return animal;
    }
    
    public Treatment getTreatment() {
    	return treatment;
    }
    
    
}
