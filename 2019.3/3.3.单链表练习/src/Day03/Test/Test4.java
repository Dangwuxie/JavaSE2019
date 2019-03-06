package Day03.Test;

public class Test4 {
    public static void main(String[] args) {
        LinkedList4 linkedList4 = new LinkedList4();
        linkedList4.add4(1);
        linkedList4.add4(2);
        linkedList4.add4(3);
        linkedList4.add4(4);
        //linkedList4.removeElements(2);
        //linkedList4.addElement4(1,66);
        //System.out.println(linkedList4.seekElement(66));
        linkedList4.replaceElement(1,66);
        Object datas[] = linkedList4.toArray();
        for (Object o:datas){
            System.out.print(o+"  ");
        }

    }
}
