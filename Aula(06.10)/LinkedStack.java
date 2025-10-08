import java.util.NoSuchElementException;

/**
 * Implementação de uma pilha utilizando lista duplamente encadeada
 * @author paulo Soares
 * @version 1.0
 * @since 2024-10-06
 * @param <T> tipo genérico para os elementos da pilha
 */

public class LinkedStack<T> implements Stackable<T>{
   /**aponta para o topo da pilha*/
    private DoubleNode<T> top;


   /**indica o número de elementos na pilha*/
    private int numberElements;

    /** indica o número máximo de elementos que a pilha pode armazenar*/
    private int maxElements;

    /** construtor padrão que cria uma pilha com capacidade máxima de 10 elementos  */
    public LinkedStack(){
        this(10);
    }
    
    

    /** construtor que cria uma pilha com capacidade máxima especificada
     * @param maxElements capacidade máxima da pilha
     * @throws illegalArgumentException se maxElements for menor ou igual a zero
     */
    public LinkedStack(int maxElements) {
        if (maxElements <= 0) {
            throw new IllegalArgumentException("O número máximo de elementos deve ser maior que zero.");
        }
        this.top = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }

    /**Remove e retorna o elemento do topo da pilha
     * @return o elemento removido
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha está vazia.");
        }

        T auxData = top.getData();
        top = top.getPrevious();

        if(top!= null){
            top.setNext(null);
        }

        numberElements--;
        return auxData;
    }



/**Adiciona um elemento no topo da pilha
 * @param item elemento a ser adicionado
 * @throws NoSuchElementException se a pilha estiver cheia 
 */
    @Override
    public void push(T item) {
        if (isFull()) {
            throw new NoSuchElementException("A pilha está cheia.");
        }
        
        DoubleNode<T> newNode = new DoubleNode<>(item);
          top.setPrevius(top);
       
        
        if (top != null) {
           newNode.setNext(newNode);
        }

        top = newNode;
        numberElements++;
    }

    /**Atualiza o elemento em uma posição específica da pilha 
     * @param index índice do elemento a ser atualizado (0 para o topo)
     * @param item novo valor do elemento
     * @throws IndexOutOfBoundsException se o índice for inválido
     * @throws NoSuchElementException se a pilha estiver vazia
     */

    @Override
    public void update(int index, T item) {
       if (item == null) {
            throw new IllegalArgumentException("Não é permitido atualizar com elemento null");
        }
        
        if (index < 0 || index >= numberElements) {
            throw new IndexOutOfBoundsException("Índice fora do limite: " + index);
        }
        
        DoubleNode<T> current = top;
        for (int i = 0; i < index; i++) {
            current = current.getPrevious();
        }
        current.setData(item);
    }
    
    
    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     * @return o elemento do topo ou null se a pilha estiver vazia
     * @throws NoSuchElementException se a pilha estiver vazia
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

    /**Retorna o número de elementos na pilha
     * @return o número de elementos na pilha
     */
    @Override
    public int size() {
        return numberElements;
    }

    /**Getters e Setters */

    /**Retorna o nó do topo da pilha
     * @return o nó do topo da pilha
     */
    public DoubleNode<T> getTop() {
        return top;
    }

    /**Define o nó do topo da pilha
     * @param top o nó a ser definido como topo da pilha
     */
    public void setTop(DoubleNode<T> top) {
        this.top = top;
    }

    /**Retorna o número de elementos na pilha
     * @return o número de elementos na pilha
     */
    public int getNumberElements() {
        return numberElements;
    }

    /**Define o número de elementos na pilha
     * @param numberElements o número a ser definido
     */
    public void setNumberElements(int numberElements) {
        this.numberElements = numberElements;
    }

    /**Retorna o número máximo de elementos que a pilha pode armazenar
     * @return o número máximo de elementos
     */
    public int getMaxElements() {
        return maxElements;
    }

    /**Define o número máximo de elementos que a pilha pode armazenar
     * @param maxElements o número a ser definido
     */
    public void setMaxElements(int maxElements) {
        this.maxElements = maxElements;
    }
}
