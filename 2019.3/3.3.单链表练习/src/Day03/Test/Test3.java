package Day03.Test;
//对着录屏敲遍

public class Test3 {
    public static void main(String[] args) {
        Sequence sequence = new SequenceLinkImpl();
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);

      //  ((SequenceLinkImpl) sequence).add(2,333);
       // sequence.clear();
       // System.out.println(sequence.size());
        sequence.add(null);
        System.out.println(sequence.contains(2));
        System.out.println(sequence.contains(null));
        System.out.println(sequence.contains(666));
        /*Object[] datas = sequence.toArray();
        for (Object o:datas) {
            System.out.print(o+"  ");
        }
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
