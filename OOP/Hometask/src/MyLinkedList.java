import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    private int count;
    private Node<T> head;

    public MyLinkedList(){
        head = null;
        count = 0;
    }

    public MyLinkedList<T> pop(){
        remove(size()-1);
        return this;
    }

    public MyLinkedList<T> push(T value){
        add(value);
        return this;
    }

    @Override
    public void add(T value) {
        if(isEmpty()){
            head = new Node<>(value);
        } else{
            Node<T> temp = head;
            while(temp.getNext()!=null)
                temp=temp.getNext();
            temp.setNext(new Node<>(value));
        }
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        MyIterator<?> it1 = iterator();
        MyIterator<?> it2 = that.iterator();
        while(it1.hasNext() && it2.hasNext())
            if(!it1.next().equals(it2.next()))
                return false;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, head);
    }

    @Override
    public T get(int index) {
        if(index<count && index >= 0){
            Node<T> temp = head;
            for(int i=0; i<index; i++)
                temp = temp.getNext();
            return temp.getValue();
        }
        return null;
    }

    @Override
    public boolean insert(T value, int index) {
        Node<T> temp = head;
        if(index<count+1 && index > 0) {
            for (int i = 0; i < index-1; i++) {
                temp = temp.getNext();
            }
            Node<T> next = temp.getNext();
            temp.setNext(new Node<>(value));
            temp.getNext().setNext(next);
            count++;
            return true;
        }
        if(index==0){
            head = new Node<>(value);
            head.setNext(temp);
            count++;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<>(head);
    }

    @Override
    public boolean remove(int index) {
        if(index<count && index > 0){
            Node<T> temp = head;
            for(int i=0; i<index-1; i++)
                temp = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            count--;
            return true;
        }
        if(!isEmpty()&&index==0){
            head = head.getNext();
            count--;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(!isEmpty()){
            if(head.getValue().equals(value)){
                head = head.getNext();
                count--;
                return true;
            }
            Node<T> temp = head;
            while(temp.getNext()!=null) {
                if(temp.getNext().getValue().equals(value)) {
                    temp.setNext(temp.getNext().getNext());
                    count--;
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean set(T value, int index) {
        if(index<count && index >= 0){
            Node<T> temp = head;
            for(int i=0; i<index; i++)
                temp = temp.getNext();
            temp.setValue(value);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        MyIterator<T> it = iterator();
        while(it.hasNext()){
            result.append(it.next());
            result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

}
