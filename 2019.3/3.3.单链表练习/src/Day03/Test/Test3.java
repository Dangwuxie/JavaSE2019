package Day03.Test;
//对着录屏敲遍

public class Test3 {
    public static void main(String[] args) {

        LinkedList3 linkedList3 = new LinkedList3();
        linkedList3.addFist(1);
        linkedList3.addFist(2);
        linkedList3.addFist(3);
        //linkedList3.addFist(4);
        Object[] datas;
        linkedList3.add(2,666);
        datas = linkedList3.toArray();
        for (Object o:datas) {
            System.out.print(o+"  ");
        }

      //  ((SequenceLinkImpl) sequence).add(2,333);
       // sequence.clear();
       // System.out.println(sequence.size());
       // sequence.add(null);
        //System.out.println(sequence.contains(2));
        //System.out.println(sequence.contains(null));
        //System.out.println(sequence.contains(666));

        /*
        sequence.remove(1);
        datas = sequence.toArray();
        for (Object o:datas) {
            System.out.print(o+"  ");
        }*/
    /*System.out.println();
        System.out.println(sequence.get(1));
        System.out.println(sequence.set(1,20));
        System.out.println(sequence.get(1));
     */

    }
}
