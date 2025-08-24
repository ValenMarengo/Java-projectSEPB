package classes;

import interfaces.I_List;

public class List implements I_List{
		
	Node front;
	Node tail;
	int size;
	
	public List() {
		front = new Node(null);
		tail = new Node(null);
		front.next = tail;
		front.previous = null;
		tail.previous = front;
		tail.next = null;
		size = 0;
	}
	
	public boolean append(Node node) {
		Node newNode = node;
		if (size > 0) {
			newNode.next = tail;
			newNode.previous = tail.previous;
			tail.previous.next = newNode;
			tail.previous = newNode;
			size++;
			return true;
		} else if (size == 0){
			insertHead(newNode);
			return true;
		}
		return false;
	}
	
	public Node getHead() {
		return front.next;
	}
	
    public Node getTail() {
    	return tail.previous;
    }
    
    /**
     * reference :
     * https://www.geeksforgeeks.org/introduction-and-insertion-in-a-doubly-linked-list/
     */
    public boolean insert(int index, Node node) {
		if (index == 0) {
			insertHead(node);
			return true;
		} 
		else if(index >= size) { 
			return false;
		}
		else {
			//
			Node previous_node = getNodeAtIndex(index-1);
			node.next = previous_node.next;
			previous_node.next = node;
			node.previous = previous_node;
			if(node.next != null) {
				node.next.previous = node;
			}
			size++;
			return true;
		}	
	}
    
    public void insertHead (Node node) {
		Node newNode = node;
		if (size == 0) {
			newNode.next = tail;
			newNode.previous = front;
			tail.previous = newNode;
			front.next = newNode;
			size++;
			
		} else {
			newNode.next = front.next;
			newNode.previous = null;
			if (front.next != null)
				front.next.previous = newNode;
			front.next = newNode;
			size++;
		}
	}
    
    public boolean remove(int index) {
    	if (index<0 || index >= size) {
    		return false;    		
    	}
    	else {
    		Node removeNode = getNodeAtIndex(index);    		
    		if (removeNode(removeNode)) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
    
    public boolean removeNode(Node node) {
    	Node removeNode = node;
    	
    	if (front.next == null || removeNode.currentCase == null || front.next == tail) {
    		return false;
    	}
    	if (front.next == removeNode) {
    		front.next = removeNode.next;
    	}
    	if (removeNode.next != null) {
    		removeNode.next.previous = removeNode.previous;
    	}
    	if (removeNode.previous != null) {
    		removeNode.previous.next = removeNode.next;
    	}
    	size--;
    	return true;
    }
    

    /**
     * reference :
     * Add a node after a given node in a Doubly Linked List:
     * https://www.geeksforgeeks.org/swap-given-nodes-in-a-doubly-linked-list-without-modifying-data/
     */
	public boolean swap(int first_index, int second_index) {
		// Invalid indices or equal indices, no need to swap
		if (first_index < 0 || second_index < 0 || first_index >= size || second_index >= size 
	    		|| first_index == second_index) {
	        return false;
	    }

	    Node nodeFirst = getNodeAtIndex(first_index);
	    Node nodeSecond = getNodeAtIndex(second_index);
	    
	    // One or both nodes not found
	    if (nodeFirst == null || nodeSecond == null) {
	        return false;
	    }
	    
	    //Special cases that one or both node are at edge of lists
	    if (nodeFirst == front.next) {front.next = nodeSecond;}
	    else if (nodeSecond == front.next) {front.next = nodeFirst;}
	    if (nodeFirst == tail.previous) {tail.previous = nodeSecond;}
	    else if (nodeSecond == tail.previous) {tail.previous = nodeFirst;}

	    // Swap next pointers of nodeFirst and nodeSecond
	    Node tempNext = nodeFirst.next;
	    nodeFirst.next = nodeSecond.next;
	    nodeSecond.next = tempNext;
	    
	    // Update previous pointers of nodes next to nodeFirst and nodeSecond
	    if (nodeFirst.next != null) {nodeFirst.next.previous = nodeFirst;}
	    if (nodeSecond.next != null) {nodeSecond.next.previous = nodeSecond;}
	    
	    // Swap previous pointers of nodeFirst and nodeSecond
	    Node tempPrev = nodeFirst.previous;
	    nodeFirst.previous = nodeSecond.previous;
	    nodeSecond.previous = tempPrev;
	    
	    // Update next pointers of nodes previous to nodeFront and nodeSecond
	    if (nodeFirst.previous != null) {nodeFirst.previous.next = nodeFirst;} 
	    if (nodeSecond.previous != null) {nodeSecond.previous.next = nodeSecond;}	

	    return true;
	}
	
	private Node getNodeAtIndex(int nodeIndex) {
		if(nodeIndex<0) {
			return null;
		}
		Node it = front.next;
		int index = 0;
		while (it.currentCase != null) {
			if (nodeIndex == index) {
				break;
			}
			it = it.next;
			index++;
		}
		return it;
	}
    
    public int findIndex(String ownerName) {
    	Node it = front.next;
    	int itIndex = 0;//first index is zero
    	
    	while(it.currentCase != null) {
    		String name = it.currentCase.owner.name;
    		if(name.equalsIgnoreCase(ownerName)) {
    			return itIndex;
    		}
    		it = it.next;
    		itIndex++;
    	}
    	
    	return -1; //Return -1 if data is not found
    }
    
    public void sort() {
    	
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size-1-i; j++) {
    			Treatment frontCompare = getNodeAtIndex(j).currentCase.treatment;
    			Treatment backCompare = getNodeAtIndex(j+1).currentCase.treatment;
    			
    			// Swap if frontCompare is not emergency and backCompare is emergency
    			if(frontCompare != Treatment.emergency && backCompare == Treatment.emergency) {
    				swap(j,j+1);
    			}
    		}	
    	}	
    }

}
