package classes;

public enum AnimalKind {
	dog("dog"),
    cat("cat"),
    bird("bird"),
    reptile("reptile"),
    rodent("rodent");
	
	private final String value;
	
	AnimalKind(String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
}
