import java.util.Objects;

public class Node<T>{
    private T value;
    private Node<T> next;

    public Node (T value){
        this.value = value;
        next = null;
    }
    public void setValue(T value){
        this.value = value;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }
    public T getValue(){
        return value;
    }
    public Node<T> getNext(){
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
