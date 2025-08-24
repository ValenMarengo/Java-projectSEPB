package interfaces;

import classes.AnimalKind;

public interface I_Animal {
    void setWeight(double weight);
    boolean setAnimalKind(String kind);
    void addPreexistingCondition(String[] conditions);
    String getName();
    int getAge();
    double getWeight();
    AnimalKind getAnimalKind();
    String getGender();
    String[] getPreexistingCondition();


}
