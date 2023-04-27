package mastering.datastructures.linkedlist;

import javax.naming.OperationNotSupportedException;

public class LinkedListExampleMain {
    public static void main(String[] args) throws OperationNotSupportedException {
        var linkedList = new LinkedList<Integer>();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        linkedList.display();

        System.out.println("Size of list: " + linkedList.sizeRecursive());

        System.out.println("Sum of elements: " + linkedList.sumRecursive());

        System.out.println("List's max value: " + linkedList.maxRecursive());

        System.out.println("Is element 5 present: " + linkedList.linearSearch(5));

        System.out.println("Is element 2 present: " + linkedList.linearSearchRecursive(2));

        System.out.println("Is element 3 present: " + linkedList.linearSearchHead(3));

        linkedList.display();

        linkedList.insert(6, 3);

        linkedList.display();

        var linkedList2 = new LinkedList<Integer>();

        linkedList2.insert(5, 0);
        linkedList2.insert(8, 1);
        linkedList2.insert(3, 2);
        linkedList2.insert(6, 3);

        linkedList2.display();

        System.out.println("-----------");

        var linkedList3 = new LinkedList<Integer>();
        linkedList3.insert(1, 0);
        linkedList3.insert(3, 1);
        linkedList3.insert(5, 2);
        linkedList3.insert(6, 3);
        linkedList3.insert(9, 4);

        linkedList3.insertSorted(-2);

        linkedList3.display();

        System.out.println("Deleted value: " + linkedList3.delete(5));

        linkedList3.display();

        System.out.println("Is List sorted: " + (linkedList3.isListSorted() ? "yes" : "no"));

        linkedList2.display();

        System.out.println("Is List sorted: " + (linkedList2.isListSorted() ? "yes" : "no"));

        System.out.println("-----------");

        var linkedList4 = new LinkedList<Integer>();
        linkedList4.insert(1, 0);
        linkedList4.insert(3, 1);
        linkedList4.insert(5, 2);
        linkedList4.insert(5, 3);
        linkedList4.insert(9, 4);
        linkedList4.insert(11, 5);
        linkedList4.insert(12, 6);
        linkedList4.insert(12, 7);
        linkedList4.insert(14, 8);
        linkedList4.insert(16, 9);
        linkedList4.insert(16, 10);
        linkedList4.insert(16, 10);

        linkedList4.display();

        System.out.println("Removed duplicates");

        linkedList4.removeDuplicates();

        linkedList4.display();

        System.out.println("Reverse");

        linkedList4.reverse();

        linkedList4.display();

        System.out.println("Reverse again");

        linkedList4.reverseSliding();

        linkedList4.display();

        System.out.println("Reverse another time");

        linkedList4.reverseRecursive();

        linkedList4.display();

        System.out.println("-----------");

        System.out.println("Concat this two lists: ");
        linkedList3.display();
        linkedList4.display();

        System.out.println("The result:");
        linkedList3.concat(linkedList4);

        linkedList3.display();

        System.out.println("-----------");
        var linkedList5 = new LinkedList<Integer>();
        linkedList5.insert(2, 0);
        linkedList5.insert(8, 1);
        linkedList5.insert(10, 2);
        linkedList5.insert(15, 3);

        var linkedList6 = new LinkedList<Integer>();
        linkedList6.insert(4, 0);
        linkedList6.insert(7, 1);
        linkedList6.insert(12, 2);
        linkedList6.insert(14, 3);

        System.out.println("Merging two lists: ");
        linkedList5.display();
        linkedList6.display();

        System.out.println("Result: ");
        linkedList5.mergeInto(linkedList6);

        linkedList5.display();

        System.out.println("Is list circular: " + (linkedList5.isCircular() ? "yes" : "no"));

        System.out.println("-----------");
        linkedList5.append(7);

        linkedList5.display();

        System.out.println("Middle value: " + linkedList5.findMiddle());
        System.out.println("Middle value: " + linkedList5.findMiddleImproved());
        System.out.println("Middle value: " + linkedList5.findMiddleStack());

        System.out.println("-----------");
        var linkedList7 = new LinkedList<Integer>();
        linkedList7.insert(8, 0);
        linkedList7.insert(6, 1);
        linkedList7.insert(3, 2);
        linkedList7.insert(9, 3);
        linkedList7.insert(10, 4);
        linkedList7.insert(4, 5);
        linkedList7.insert(2, 6);
        linkedList7.insert(12, 7);

        var linkedList8 = new LinkedList<Integer>();
        linkedList8.insert(20, 0);
        linkedList8.insert(30, 1);
        linkedList8.insert(40, 2);
        linkedList8.insert(10, 3);
        linkedList8.insert(4, 4);
        linkedList8.insert(2, 5);
        linkedList8.insert(12, 6);

        linkedList7.display();
        linkedList8.display();

        var intersection = linkedList7.getIntersection(linkedList8);

        System.out.println("Iterseção: " + intersection.getKey() + " - " + intersection.getValue());
    }
}
