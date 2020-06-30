import java.util.ArrayList;
import java.util.Stack;

public class Day11 {
    public static void main(String[] args) {
        CQueue q = new CQueue();
        ArrayList<Integer> ans = new ArrayList<>();
        q.appendTail(8);
        ans.add(q.deleteHead());
        q.appendTail(10);
        q.appendTail(9);
        ans.add(q.deleteHead());
        ans.add(q.deleteHead());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}

//two stack implement a queue
class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int prev = 0;
    boolean append = true;

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) return -1;
        else return stack2.pop();
    }
}