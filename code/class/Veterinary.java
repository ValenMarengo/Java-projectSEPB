package classes;
import java.util.ArrayList;

public class Veterinary {
	Doctor[] doctors;
	Assistant[] assistants;
	List queue;
	
	public Veterinary(Doctor[] doctors, Assistant[] assistants){
		this.doctors = doctors;
		this.assistants = assistants;
		this.queue = new List();
	}
	
	public Veterinary(){
		this.doctors = new Doctor[0];
		this.assistants = new Assistant[0];
		this.queue = new List();
	}

	public Doctor[] getDoctors() {
		return doctors;
	}

	public Assistant[] getAssistants() {
		return assistants;
	}
	
	
	public boolean addCase(Case newCase) {
		if(haveVeterinaryAuthorize(newCase)) {
			Node newNode = new Node(newCase);
			queue.append(newNode);
			return true;
		}
		return false;
	}
	
	
	private boolean haveVeterinaryAuthorize(Case newCase) {
		boolean canHandle = false;
		for(int i=0; i<doctors.length; i++) {
			for(int j=0; j<doctors[i].getAuthorizedFor().length; j++) {
				String authorizedAnimal = doctors[i].authorizedFor[j].toString();
				AnimalKind animalKind = newCase.animal.animalKind;
				String animalKindString = animalKind.toString();
				if(authorizedAnimal.equals(animalKindString)){
					canHandle = true;
				}
				
			}
		}
		return canHandle;
	}
	
	public List getCaseList() {
		return queue;
	}
	
	public boolean removeCase(String patientName) {
		int listIndex = queue.findIndex(patientName);
		
		if (listIndex == -1) {//In case, data is not found
			return false;
		}
		queue.remove(listIndex);
		return true;
	}
	
	public void printMostUrgentCases(int k) {

		if(k <0 || k>=queue.size) {
			System.out.println("Invalid index. Please provide a valid index.");
		}
		else {
			queue.sort();
			Node it = queue.getHead();
			for(int i=0; i<=k; i++) {
				System.out.println(it.displayUrgentCase() 
						+ calculateTreatmentTime(it.getCase().getTreatment().toString()));
				it = it.getNext();
			}
		}
	}
	
	private int calculateTreatmentTime (String treatmentType) {
		int standardTime;
		switch (treatmentType) {
	        case "vaccination":
	            standardTime = 15;
	            break;
	        case "injury":
	            standardTime = 30;
	            break;
	        case "diagnostics":
	            standardTime = 45;
	            break;
	        case "emergency":
	            standardTime = 60;
	            break;
	        default:
	            standardTime = 0;
		}
		if (assistants.length <= doctors.length) {
			standardTime = standardTime *2;
		}
		return standardTime;
	}
	
	
	public ArrayList<String> execute(){
		ArrayList<String> veterinaryResults = new ArrayList<>();
		queue.sort();
		int veterinaryTime = 0;
		boolean finishedStatus = false;
		
		while(queue.size != 0 || !finishedStatus) {

			for(int i=0; i<doctors.length; i++) {
				
				if(doctors[i].operationTime == 0) {
					doctors[i].handleCase = null;
					if(queue.size > 0) {
						Node currentCase = findNextCase(doctors[i]);
						if(currentCase != null) {
							registerDoctorCase(veterinaryTime, currentCase, doctors[i]);
						}
					}
				}else if (doctors[i].operationTime == 1) {
					//Conclude finished treatment
					if(veterinaryTime>0) {
						doctors[i].finishedTime = veterinaryTime;
						veterinaryResults.add(concludeCase(doctors[i]));								
					}
					doctors[i].operationTime--;
				}else { 		
					doctors[i].operationTime--;
				}
				
			}
			if(queue.size ==0) {
				int sum = 0;
				for (int i=0; i<doctors.length; i++) {
					if(doctors[i].handleCase == null) {
						sum++;
					}
				}
				if (sum == doctors.length) {
					finishedStatus = true;
				}
			}
			veterinaryTime++;//veterinary time increase
		}
		return veterinaryResults;
	}
	
	private boolean isDoctorAuthorized (Doctor doctor, Node node) {
		String animalKind = node.getCase().getAnimal().getAnimalKind().toString();
		for(int i=0; i<doctor.getAuthorizedFor().length; i++) {
			String authorize = doctor.authorizedFor[i].toString();
			if(authorize.equalsIgnoreCase(animalKind)) {
				return true;
			}		
		}
		return false;
	}
	
	private String concludeCase(Doctor doctor) {
		String caseConclusion = doctor.handleCase.getCase().getOwner().getName() + " with " +
				doctor.handleCase.getCase().getAnimal().getName() + " was treated by " + 
				doctor.getName() + ", " + doctor.handleCase.getCase().getTreatment().toString() + 
				", started at: " + doctor.startingTime + " ended at: " + doctor.finishedTime;
		return caseConclusion;
	}
	
	private void registerDoctorCase (int time, Node currentCase, Doctor doctor) {
		doctor.handleCase = currentCase;
		doctor.startingTime = time;
		doctor.operationTime = calculateTreatmentTime(currentCase.getCase().getTreatment().toString());
		queue.removeNode(doctor.handleCase);
	}
	
	private Node findNextCase(Doctor doctor) {
		int unMatchingTimes = 0;
		Node currentCase = queue.getHead();						
		// Iterate through the cases while checking doctor's authorization
		do {
			if(unMatchingTimes > 0) {
				currentCase = currentCase.getNext();
			}
			if (currentCase == null) {
				break;
			}
			unMatchingTimes++;
		}while(!isDoctorAuthorized (doctor,currentCase));
		
		return currentCase;
	}
	
}
