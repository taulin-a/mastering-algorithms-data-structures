package mastering.datastructures.stack;

public class StackExampleMain {
    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.push(10);
        stack.push(15);
        stack.push(8);
        stack.push(3);

        stack.display();

        stack.pop();

        stack.display();

        var exp1 = "((x + y) * (z * t))";

        System.out.println("Parenthesis match for " + exp1 + ": " + (isParenthesisMatching(exp1) ? "yes" : "no"));

        var exp2 = "(((x + y) * (z * t))";
        System.out.println("Parenthesis match for " + exp2 + ": " + (isParenthesisMatching(exp2) ? "yes" : "no"));

        var exp3 = "{[(x + y) * (z * t)]}";
        System.out.println("Parenthesis match for " + exp3 + ": " + (isParenthesisMatchingImproved(exp3) ? "yes" : "no"));

        var exp4 = "{[(x + y) * (z * t)]}}";
        System.out.println("Parenthesis match for " + exp4 + ": " + (isParenthesisMatchingImproved(exp4) ? "yes" : "no"));
    }

    private static boolean isParenthesisMatching(String expression) {
        var stack = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean isParenthesisMatchingImproved(String expression) {
        var stack = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '['
                    || expression.charAt(i) == '{') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) return false;

                var value = stack.pop();

                if (value != '(') return false;
            } else if (expression.charAt(i) == ']') {
                if (stack.isEmpty()) return false;

                var value = stack.pop();

                if (value != '[') return false;
            } else if (expression.charAt(i) == '}') {
                if (stack.isEmpty()) return false;

                var value = stack.pop();

                if (value != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
