package interfaces;

import java.util.ArrayList;

import classes.Doctor;
import classes.List;
import classes.Assistant;
import classes.Case;

public interface I_Veterinary {
    Doctor[] getDoctors();
    Assistant[] getAssistants();
    List getCaseList();
    boolean addCase(Case newCase);
    boolean removeCase(String patientName);
    void printMostUrgentCases(int k);
    ArrayList<String> execute();
}
