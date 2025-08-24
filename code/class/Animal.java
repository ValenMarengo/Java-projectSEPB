package classes;

import interfaces.I_Animal;

public class Animal implements I_Animal {
	
	String name;
	int age;
	double weight;
	String gender;
	String [] preexistingConditions;
	AnimalKind animalKind;
	
	public Animal(String name, int age, double weight, String gender) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.preexistingConditions = new String[0];
	}
	
	public Animal(String name, int age, double weight, String gender, String [] preexistingConditions) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.preexistingConditions = preexistingConditions;
	}
	
    public void addPreexistingCondition(String[] conditions) {
    	//determine the new size of array
    	int newConditionsSize = preexistingConditions.length;
    	for(String condition : conditions) {
    		if(!isRepeated(preexistingConditions,condition)) {
    			newConditionsSize++;
    		}
    	}
    	//create new array following new size
    	String[] newConditions = new String[newConditionsSize];
    	
    	//collect the original data and added conditions into new array
    	for (int i = 0; i < preexistingConditions.length; i++) {
            newConditions[i] = preexistingConditions[i];
        }
    	int index = preexistingConditions.length;
    	for(String str : conditions) {
    		if(!isRepeated(preexistingConditions,str)) {
    			newConditions[index] = str;
    			index++;
    		}
    	}
    	
    	//update preexistingConditions
    	preexistingConditions = newConditions;    	
    }
    
    private boolean isRepeated (String[] array, String str) {
    	for(String element : array) {
    		if(element.equalsIgnoreCase(str)) {
    			return true;
    		}
    	}
		return false;
    }
    
    public String[] getPreexistingCondition() {
    	return preexistingConditions;
    }
	
    public boolean setAnimalKind(String kind) {
    	for(AnimalKind kindString : AnimalKind.values()) {
    		if(kindString.name().equalsIgnoreCase(kind)) {
    			this.animalKind = kindString;
    			return true;
    		}
    	}
    	System.out.println("unknown animal");
    	return false;	
    }
    
    public void setWeight(double weight) {
    	this.weight = weight;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getAge() {
    	return age;
    }
    
    public double getWeight() {
    	return weight;
    }
    
    public AnimalKind getAnimalKind() {
    	return animalKind;
    }
    
    public String getGender() {
    	return gender;
    }
    
    
}
