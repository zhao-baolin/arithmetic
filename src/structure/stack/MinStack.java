package structure.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/5/26
 *
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(int x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    private List arr;
    private int minIndex = -1;
    public MinStack() {
        arr = new ArrayList();
    }

    public void push(int x) {
        if(arr.isEmpty()){
            minIndex = 0;
        }
        arr.add(x);
        if(x < (int)arr.get(minIndex)){
            minIndex = arr.size() - 1;
        }
    }

    public void pop() {
        if(!arr.isEmpty()){
            int i = arr.size() - 1;
            arr.remove(i);
            if(i == this.minIndex){
                this.minIndex = getArrayListMinIndex();
            }
        }
    }

    public int top() {
        if(arr.isEmpty()){
            return -1;
        }
        int i = arr.size() - 1;
        int data = (int) arr.get(i);
        if(i == this.minIndex){
            this.minIndex = getArrayListMinIndex();
        }
        return data;
    }

    private int getArrayListMinIndex()
    {
        if(arr.isEmpty()){
            return -1;
        }
        Object obj = Collections.min(arr);
        return arr.indexOf(obj);
    }

    public int getMin() {
        return this.minIndex >= 0 ? (int) arr.get(this.minIndex) : -1;
    }

    public static void main(String[] args) {
/*
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top()); //  --> 返回 2
        System.out.println(minStack.getMin()); //  --> 返回 1
        minStack.pop();
        System.out.println(minStack.getMin()); //  --> 返回 1
        System.out.println(minStack.top()); //  --> 返回 1
*/


/*        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); //  --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());   //   --> 返回 0.
        System.out.println(minStack.getMin());//   --> 返回 -2.
        */
    }
}
