package mastering.datastructures.polynomial;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private int value;
    private final List<Term> terms;

    public Polynomial(int value) {
        this.value = value;
        this.terms = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void addTerm(int coefficient, int exponent) {
        terms.add(new Term(coefficient, exponent));
    }

    public void display() {
        for (Term t : terms) {
            var strCoef = t.getCoefficient() == 1 ? "" : t.getCoefficient() + "*";
            var strExp = t.getExponent() == 1 ? "" : "^" + t.getExponent();
            System.out.print("(" + strCoef + value + strExp + ")" + (terms.indexOf(t) == terms.size() - 1 ? "" : " + "));
        }
        System.out.print("\n");
    }

    public int evaluate() {
        var result = 0;
        for (Term t : terms) {
            result += t.getCoefficient() * Math.pow(value, t.getExponent());
        }

        return result;
    }

    public Polynomial add(Polynomial p) {
        var newPoly = new Polynomial(0);

        int i = 0, j = 0, k = 0;

        while (i < terms.size() && j < p.getTerms().size()) {
            if (terms.get(i).getExponent() == p.getTerms().get(j).getExponent()) {
                newPoly.addTerm(terms.get(i).getCoefficient() + p.getTerms().get(j).getCoefficient(),
                        terms.get(i).getExponent());
                i++;
                j++;
                k++;
            } else if (terms.get(i).getExponent() > p.getTerms().get(j).getExponent()) {
                newPoly.addTerm(terms.get(i).getCoefficient(), terms.get(i).getExponent());
                i++;
                k++;
            } else {
                newPoly.addTerm(p.getTerms().get(j).getCoefficient(), p.getTerms().get(j).getExponent());
                j++;
                k++;
            }
        }

        while (i < terms.size()) {
            newPoly.addTerm(terms.get(i).getCoefficient(), terms.get(i).getExponent());
            i++;
            k++;
        }

        while (j < p.getTerms().size()) {
            newPoly.addTerm(p.getTerms().get(j).getCoefficient(), p.getTerms().get(j).getExponent());
            j++;
            k++;
        }

        newPoly.setValue(k);

        return newPoly;
    }
}
