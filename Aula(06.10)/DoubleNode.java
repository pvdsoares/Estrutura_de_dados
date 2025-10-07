public class DoubleNode<T> {
 private T data;
 private DoubleNode<T> next;
 private DoubleNode<T> previus;  
 
 
// Getters and setters
public Object getData() {
    return data;
}

public void setData(T data) {
    this.data = data;
}

public DoubleNode<T> getNext() {
    return next;
}

public void setNext(DoubleNode next) {
    this.next = next;
}

public DoubleNode getPrevius() {
    return previus;
}

public void setPrevius(DoubleNode previus) {
    this.previus = previus;
}
}
