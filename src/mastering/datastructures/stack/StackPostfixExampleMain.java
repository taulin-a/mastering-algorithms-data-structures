package mastering.datastructures.stack;

import java.util.HashMap;
import java.util.Map;

public class StackPostfixExampleMain {
    public static void main(String[] args) {
        Map<Character, Integer> symbolTable = new HashMap<>();

        symbolTable.put('+', 1);
        symbolTable.put('-', 1);
        symbolTable.put('*', 2);
        symbolTable.put('/', 2);

        var exp = "a+b*c-d/e";

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

        System.out.println(postfix);
    }
}
