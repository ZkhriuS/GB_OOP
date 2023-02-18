import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(3);
        list.push(2).push(4).push(0);
        System.out.println(list);
//        list.remove((Integer) 3);
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
        list.pop().pop().pop();
        System.out.println(list);
        list.set(7, 1);
        System.out.println(list);
        System.out.println(list.get(1));
        list.insert(8, 5);
        System.out.println(list);
    }
}
