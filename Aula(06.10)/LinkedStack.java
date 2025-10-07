import java.util.NoSuchElementException;

/**
 * Implementação de uma pilha utilizando lista encadeada
 * @author paulo Soares
 * @version 1.0
 * @since 2024-10-06
 */

public class LinkedStack<T> implements Stackable<T>{
   /**aponta para o topo da pilha*/
    private DoubleNode<T> top;
   /**indica o número de elementos na pilha*/
    private int numberElements;
    private int maxElements;
    private DoubleNode<T> previus;
    private DoubleNode<T> next;
    
    public LinkedStack(){
        this(10);
    }

    /**cosnturtor recebe 1 elemento que indica o tamanho máximo da pilha
     * @param maxElements 
     * */
    public LinkedStack(int maxElements) {
        this.top = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha está vazia.");
        }
        T auxData = top.getData();
        top = top.getPrevius();
        numberElements--;
        top.setNext(null);
        return auxData;

    }
/**Adiciona um elemento no topo da pilha
 * 
 * @param item elemento a ser adicionado
 * @throws NoSuchElementException se a pilha estiver cheia 
 */
    @Override
    public void push(T item) {
        if (isFull()) {
            throw new NoSuchElementException("A pilha está cheia.");
        }
        DoubleNode<T> newNode = new DoubleNode<>(item);
        newNode.setNext(top);
        top = newNode;
        numberElements++;
    }

    @Override
    public void update(int index, T item) {
        if (index < 0 || index >= numberElements) {
            throw new IndexOutOfBoundsException("Índice fora do limite.");
        }
        DoubleNode<T> current = top;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(item);
    }
    
    
    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     * @return o elemento do topo ou null se a pilha estiver vazia
     */
    public T peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha está vazia.");
        }
        return top.getData();
    }
    
    /**Verifica se a pilha está vazia
     * @return true se a pilha estiver vazia ou false caso contrário
     */
    @Override
    public boolean isEmpty(){
        return numberElements == 0;
    }

    /**Verifica se a pilha está Cheia
     * @return true se a pilha estiver Cheia ou false caso contrário
     */
    @Override
    public boolean isFull(){
        return numberElements == maxElements;
    }


    @Override
    public int size() {
        return numberElements;
    }


    public DoubleNode<T> getTop() {
        return top;
    }

    public void setTop(DoubleNode<T> top) {
        this.top = top;
    }

    public int getNumberElements() {
        return numberElements;
    }

    public void setNumberElements(int numberElements) {
        this.numberElements = numberElements;
    }

    public int getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(int maxElements) {
        this.maxElements = maxElements;
    }
}