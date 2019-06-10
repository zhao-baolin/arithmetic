package structure.stack;

import java.util.ArrayList;

/**
 * @Description 栈
 * @Author zhaobaolin
 * @Date 2019/5/26
 */
public class MyStack<T> {

    private ArrayList<T> arr = new ArrayList<>();

    public void push(T data)
    {
        arr.add(data);
    }
    private boolean isEmpty()
    {
        return arr.isEmpty();
    }

    public T pop()
    {
        if(isEmpty()){
            return null;
        }
        int index = arr.size() - 1;
        T data = arr.get(index);
        arr.remove(index);
        return data;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("hello");
        myStack.push(666);
        myStack.push("world");
        myStack.push(888);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
