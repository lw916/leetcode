import java.util.Deque;
import java.util.LinkedList;

// 使用双栈
class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void in2out() {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}

