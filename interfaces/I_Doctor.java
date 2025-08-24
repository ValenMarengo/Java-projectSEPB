package interfaces;

import classes.AnimalKind;

public interface I_Doctor extends I_Person {
    AnimalKind[] getAuthorizedFor();
    boolean addAuthorizedAnimal(String animalKind);

}
