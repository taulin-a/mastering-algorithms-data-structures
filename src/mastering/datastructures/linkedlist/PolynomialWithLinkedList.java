package mastering.datastructures.linkedlist;

import mastering.datastructures.polynomial.Polynomial;
import mastering.datastructures.polynomial.Term;

public class PolynomialWithLinkedList {
    private int value;
    private final LinkedList<Term> terms;

    public PolynomialWithLinkedList(int value) {
        this.value = value;
        this.terms = new LinkedList<>();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addTerm(int coefficient, int exponent) {
        terms.append(new Term(coefficient, exponent));
    }

    public void display() {
        var iterator = terms.getIterator();
        while (true) {
            var t = iterator.getValue();
            var strCoef = t.getCoefficient() == 1 ? "" : t.getCoefficient() + "*";
            var strExp = t.getExponent() == 1 ? "" : "^" + t.getExponent();
            System.out.print("(" + strCoef + value + strExp + ")" + (!iterator.hasNext() ? "" : " + "));

            if (iterator.hasNext()) iterator.next();
            else break;
        }

        System.out.print("\n");
    }

    public int evaluate() {
        var result = 0;

        var iterator = terms.getIterator();
        while (true) {
            var t = iterator.getValue();
            result += t.getCoefficient() * Math.pow(value, t.getExponent());

            if (iterator.hasNext()) iterator.next();
            else break;
        }

        return result;
    }

    public Polynomial add(PolynomialWithLinkedList p) {
        var newPoly = new Polynomial(0);

        var iterator1 = terms.getIterator();
        var iterator2 = p.terms.getIterator();

        int k = 0;
        while (!iterator1.currentIsNull() && !iterator2.currentIsNull()) {
            if (iterator1.getValue().getExponent() == iterator2.getValue().getExponent()) {
                newPoly.addTerm(iterator1.getValue().getCoefficient() + iterator2.getValue().getCoefficient(),
                        iterator1.getValue().getExponent());
                iterator1.next();
                iterator2.next();
                k++;
            } else if (iterator1.getValue().getExponent() > iterator2.getValue().getExponent()) {
                newPoly.addTerm(iterator1.getValue().getCoefficient(), iterator1.getValue().getExponent());
                iterator1.next();
                k++;
            } else {
                newPoly.addTerm(iterator2.getValue().getCoefficient(), iterator2.getValue().getExponent());
                iterator2.next();
                k++;
            }
        }

        while (!iterator1.currentIsNull()) {
            newPoly.addTerm(iterator1.getValue().getCoefficient(), iterator1.getValue().getExponent());
            iterator1.next();
            k++;
        }

        while (!iterator2.currentIsNull()) {
            newPoly.addTerm(iterator2.getValue().getCoefficient(), iterator2.getValue().getExponent());
            iterator2.next();
            k++;
        }

        newPoly.setValue(k);

        return newPoly;
    }
}
