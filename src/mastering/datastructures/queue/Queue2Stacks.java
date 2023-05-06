package mastering.datastructures.queue;

import mastering.datastructures.stack.Stack;

public class Queue2Stacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public Queue2Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T element) {
        stack1.push(element);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
