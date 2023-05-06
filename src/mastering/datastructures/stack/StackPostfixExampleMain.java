package mastering.datastructures.stack;

import java.util.HashMap;
import java.util.Map;

public class StackPostfixExampleMain {
    private static Map<Character, Integer> symbolTable;

    /**
     * Improved symbol table containing '(' and ')'
     */
    private static Map<Character, OutInPrecendence> iSymbolTable;

    private static class OutInPrecendence {
        private int out;
        private int in;

        public OutInPrecendence(int out, int in) {
            this.out = out;
            this.in = in;
        }

        public int getOut() {
            return out;
        }

        public int getIn() {
            return in;
        }
    }

    public static void main(String[] args) {
        symbolTable = new HashMap<>();

        symbolTable.put('+', 1);
        symbolTable.put('-', 1);
        symbolTable.put('*', 2);
        symbolTable.put('/', 2);

        var exp = "a+b*c-d/e";

        System.out.println(infixToPostfix(exp));

        iSymbolTable = new HashMap<>();

        iSymbolTable.put('+', new OutInPrecendence(1, 2));
        iSymbolTable.put('-', new OutInPrecendence(1, 2));
        iSymbolTable.put('*', new OutInPrecendence(3, 4));
        iSymbolTable.put('/', new OutInPrecendence(3, 4));
        iSymbolTable.put('^', new OutInPrecendence(6, 5));
        iSymbolTable.put('(', new OutInPrecendence(7, 0));
        iSymbolTable.put(')', new OutInPrecendence(0, 0));

        var exp2 = "((a+b)*c)-d^e^f";

        System.out.println(infixToPostfixImproved(exp2));

        var exp3 = "35*62/+4-";
        System.out.println(exp3 + " = " + evaluatePostfix(exp3));
    }

    private static String infixToPostfix(String exp) {
        var postfix = "";
        var symbolStack = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            var symbol = exp.charAt(i);

            if (symbolTable.get(symbol) == null) {
                postfix = postfix.concat(Character.toString(symbol));
                continue;
            }

            var symbolPrecedence = symbolTable.get(symbol);

            if (symbolStack.isEmpty() || symbolTable.get(symbolStack.peek(0)) < symbolPrecedence) {
                symbolStack.push(symbol);
            } else {
                while (!symbolStack.isEmpty() && symbolTable.get(symbolStack.peek(0)) >= symbolPrecedence) {
                    postfix = postfix.concat(Character.toString(symbolStack.pop()));
                }
                symbolStack.push(symbol);
            }
        }

        while (!symbolStack.isEmpty()) {
            postfix = postfix.concat(Character.toString(symbolStack.pop()));
        }

        return postfix;
    }

    private static String infixToPostfixImproved(String exp) {
        var postfix = "";
        var symbolStack = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            var symbol = exp.charAt(i);

            if (iSymbolTable.get(symbol) == null) {
                postfix = postfix.concat(Character.toString(symbol));
                continue;
            }

            var precedence = iSymbolTable.get(symbol);

            if (symbolStack.isEmpty() || iSymbolTable.get(symbolStack.peek(0)).getIn() < precedence.getOut()) {
                symbolStack.push(symbol);
            } else {
                while (!symbolStack.isEmpty() && iSymbolTable.get(symbolStack.peek(0)).getIn() >= precedence.getOut()) {
                    var topOfStack = symbolStack.peek(0);

                    if (topOfStack == '(' || topOfStack == ')') {
                        symbolStack.pop();
                        continue;
                    }

                    postfix = postfix.concat(Character.toString(symbolStack.pop()));
                }

                symbolStack.push(symbol);
            }
        }

        while (!symbolStack.isEmpty()) {
            var symbol = symbolStack.peek(0);

            if (symbol == '(' || symbol == ')') {
                symbolStack.pop();
                continue;
            }

            postfix = postfix.concat(Character.toString(symbolStack.pop()));
        }

        return postfix;
    }

    private static int evaluatePostfix(String postfix) {
        var opStack = new Stack<Integer>();

        for (int i = 0; i < postfix.length(); i++) {
            var symbol = postfix.charAt(i);
            if (iSymbolTable.get(symbol) == null) {
                opStack.push(Integer.valueOf(Character.toString(symbol)));
            } else {
                var operator1 = opStack.pop();
                var operator2 = opStack.pop();

                switch (symbol) {
                    case '*':
                        opStack.push(operator1 * operator2);
                        break;
                    case '/':
                        opStack.push(operator2 / operator1);
                        break;
                    case '+':
                        opStack.push(operator2 + operator1);
                        break;
                    case '-':
                        opStack.push(operator2 - operator1);
                        break;
                }
            }
        }

        return opStack.pop();
    }
}
