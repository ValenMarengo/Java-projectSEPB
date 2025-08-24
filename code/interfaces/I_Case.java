package interfaces;

import classes.Animal;
import classes.Person;
import classes.Treatment;

public interface I_Case {
    Person getOwner();
    Animal getAnimal();
    Treatment getTreatment();

}
