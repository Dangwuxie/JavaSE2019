package Day07.Test;


public class Test1 {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        //doubleLinkedList.add(4);
        //doubleLinkedList.add(5);
       // System.out.println(doubleLinkedList.get(1));
        //doubleLinkedList.set(1,666);
        //System.out.println(doubleLinkedList.get(1));
        //System.out.println(doubleLinkedList.contains());
        doubleLinkedList.remove(0);
        Object[] data = doubleLinkedList.toArray();
        for (Object o : data){
            System.out.print(o+"  ");
        }
        //doubleLinkedList.clear();
        System.out.println();
        System.out.println(doubleLinkedList.size());
    }
}
