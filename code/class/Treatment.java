package classes;

public enum Treatment {
	vaccination("vaccination"), 
	injury("injury"), 
	diagnostics("diagnostics"), 
	emergency("emergency");
	
	private final String value;
	
	Treatment(String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
