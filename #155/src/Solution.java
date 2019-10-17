import java.util.Stack;

class MinStack {

    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // 思路 1：数据栈和辅助栈在任何时候都同步

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack min=new MinStack();
		min.push(9);
		System.out.println(min.getMin());
		min.push(10);
		System.out.println(min.getMin());
		min.push(0);
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
	}

}
