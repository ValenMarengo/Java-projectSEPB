package interfaces;

import classes.Node;

public interface I_List {
    Node getHead();
    Node getTail();
    boolean append(Node node);
    boolean insert(int index, Node node);
    boolean remove(int index);
    boolean swap(int first_index, int second_index);
    void sort();
    int findIndex(String personName);


}
