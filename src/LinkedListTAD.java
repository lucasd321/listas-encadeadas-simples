public interface LinkedListTAD<T> {

    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T peekFirst();
    T peekLast();
    boolean isEmpty();
    int size();
    void addAscendingSorted(T element);
    void deleteWithoutPredecessor(Node<T> p);
    void reverse();
    void mergeSorted(MyLinkedList<T> other);
    void removeNthFromEnd(int n);
}
