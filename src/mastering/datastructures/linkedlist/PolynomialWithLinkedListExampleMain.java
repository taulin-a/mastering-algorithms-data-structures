package mastering.datastructures.linkedlist;
public class PolynomialWithLinkedListExampleMain {
    public static void main(String[] args) {
        var poly = new PolynomialWithLinkedList(5);
        poly.addTerm(6, 4);
        poly.addTerm(5, 3);
        poly.addTerm(9, 2);
        poly.addTerm(2, 1);
        poly.addTerm(3, 0);

        poly.display();

        System.out.println("Result: " + poly.evaluate());

        var poly2 = new PolynomialWithLinkedList(3);
        poly2.addTerm(5, 4);
        poly2.addTerm(2, 2);
        poly2.addTerm(5, 0);

        poly2.display();

        var poly3 = poly.add(poly2);

        poly3.display();
    }
}
