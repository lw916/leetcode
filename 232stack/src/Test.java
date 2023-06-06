import java.util.Stack;

class MyQueue {

    public Stack<Integer> stack_a;
    public Stack<Integer> stack_b;
    /**
     使用int报错：required:reference found:int
     */

    /** Initialize your data structure here. */
    public MyQueue() {
        stack_a = new Stack<>();
        stack_b = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack_a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack_b.isEmpty()){
            while(!stack_a.isEmpty()){
                stack_b.push(stack_a.pop());
            }
        }
        return stack_b.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack_b.isEmpty()){
            while(!stack_a.isEmpty()){
                stack_b.push(stack_a.pop());
            }
        }
        return stack_b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack_a.isEmpty() && stack_b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */