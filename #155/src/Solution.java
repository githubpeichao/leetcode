import java.util.Stack;

class MinStack {

    // ����ջ
    private Stack<Integer> data;
    // ����ջ
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // ˼· 1������ջ�͸���ջ���κ�ʱ��ͬ��

    public void push(int x) {
        // ����ջ�͸���ջһ��������Ԫ��
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // ����ջ���� pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
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
