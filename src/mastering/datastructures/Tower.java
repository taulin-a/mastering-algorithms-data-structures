package mastering.datastructures;

import java.util.Stack;

public class Tower {
    private String id;
    private Stack<Integer> stack = new Stack<>();

    public Tower(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }
}
