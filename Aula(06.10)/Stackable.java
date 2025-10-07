public interface Stackable<T> {
    T pop();
    void push(T item);
    void update(int index, T item); 
    T peek();
    
    boolean isEmpty();
    boolean isFull();
    int size();
}
   