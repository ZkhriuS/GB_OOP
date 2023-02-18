
public class MyIterator<T> {
    private Node<T> node;

    public MyIterator(Node<T> node){
        this.node = node;
    }

    public boolean hasNext() {
        return node!=null;
    }

    public T next() {
        T value = node.getValue();
        node = node.getNext();
        return value;
    }
}
