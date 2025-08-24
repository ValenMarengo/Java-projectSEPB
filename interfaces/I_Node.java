package interfaces;

import classes.Case;
import classes.Node;

public interface I_Node {

    Node getPrev();
    void setPrev(Node prev);
    Node getNext();
    void setNext(Node next);
    Case getCase();
}
