package classes;

import interfaces.I_Doctor;

public class Doctor extends Person implements I_Doctor{

	public AnimalKind[] authorizedFor;
	public int operationTime;
	public int startingTime;
	public int finishedTime;
	public Node handleCase;
	
	public Doctor(String name, int age, String address) {
		super(name, age, address);
		this.authorizedFor = new AnimalKind[0];
		this.operationTime = 0;
		this.startingTime = 0;
		this.finishedTime = 0;
		this.handleCase = null;
	}
	
	public Doctor(String name, int age, String address, AnimalKind[] authorizedFor) {
		super(name, age, address);
		this.authorizedFor = authorizedFor;
		this.operationTime = 0;
		this.startingTime = 0;
		this.finishedTime = 0;
		this.handleCase = null;
	}
	
	public AnimalKind[] getAuthorizedFor() {
		return authorizedFor;
	}
	
	//from chatGPT
	public boolean addAuthorizedAnimal(String stringAnimalKind) {
		
        // Check if the provided animalKind is a valid kind of animal
        if (isValidAnimalKind(stringAnimalKind)) {
        	
        	// Check if the animalKind is not already in the authorizedFor
        	for (int i=0; i<authorizedFor.length; i++) {
        		if(stringAnimalKind.equalsIgnoreCase(authorizedFor[i].toString())){
        			return false; // animalKind is already in the set
        		}
            }   
                
            // Add the corresponding animalKind to the authorizedFor array
            AnimalKind[] newArray = new AnimalKind[authorizedFor.length + 1];
            for(int j=0; j<authorizedFor.length; j++) {
            	newArray[j] = authorizedFor[j];
            }
            newArray[authorizedFor.length] = AnimalKind.valueOf(stringAnimalKind);
            authorizedFor = newArray;

            // added successfully
            return true; 
            
        //If the provided animalKind is invalid animalKind    
        } else { 
            return false; 
        }
    }

    private boolean isValidAnimalKind(String animalKind) {
        for (AnimalKind kind : AnimalKind.values()) {
            if (kind.toString().equalsIgnoreCase(animalKind)) {
                return true; // Valid animalKind
            }
        }
        return false; // Invalid animalKind
    }    
	
}
