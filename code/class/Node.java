package classes;

import interfaces.I_Node;

public class Node implements I_Node{
	
	public Case currentCase;
	Node next;
	Node previous;
	
	public Node(Case currentCase) {
		next = previous = null;
		this.currentCase= currentCase;
	}
	
	public Node getPrev() {
		return previous;
	}
	
	public Node getNext() {
		if(next == null || next.currentCase == null)
			return null;
		return next;
	}
	
    public void setPrev(Node prev) {
    	previous = prev;
    }
    
    public void setNext(Node next) {
    	this.next = next;
    }
    
    public Case getCase() {
    	return currentCase;
    }
    
    //This method is called in Veterinary.printMostUrgentCases() method
    public String displayUrgentCase() { 
    	return currentCase.getOwner().getName() + ", " 
    			+ currentCase.getAnimal().getName() + ", " 
    			+ currentCase.getTreatment().toString() + ", ";
    }
    
}
