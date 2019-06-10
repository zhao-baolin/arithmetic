package structure.queue;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/5/24
 *
 * 循环队列实现
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */
public class MyCircularQueue {

    private int[] arr;
    private int k;//队列长度
    private int head = -1;//队首
    private int tail = -1;//队尾

    public MyCircularQueue(int k)
    {
        this.k = k;
        this.arr = new int[this.k];
    }

    public int Front()
    {
        if(isEmpty()){
            return -1;
        }
        int v = this.arr[head];
        return v;
    }

    public int Rear()
    {
        if(isEmpty()){
            return -1;
        }
        int v = this.arr[tail];
        return v;
    }

    public boolean enQueue(int value)
    {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            this.head++;
        }

        this.tail = (tail + 1) % k;
        this.arr[this.tail] = value;
        return true;
    }

    public boolean deQueue()
    {
        if(isEmpty()){
            return false;
        }
        this.head ++;
        if(this.head == this.tail + 1){
            this.head = -1;
            this.tail = -1;
        }
        return true;
    }

    public boolean isEmpty()
    {
        return this.head == -1;
    }

    public boolean isFull()
    {
        return ((tail + 1) % this.k) == head;
    }
}

/*
    public static void main(String[] args) {

        System.out.println("第1行开始-----------------------------------------");
        MyCircularQueue queue = new MyCircularQueue(30);
        System.out.println(queue.enQueue(71));
        System.out.println("队列是否是满的："+queue.isFull());
        System.out.println(queue.enQueue(32));
        System.out.println(queue.enQueue(1));
        System.out.println("队列是否是满的："+queue.isFull());
        System.out.println(queue.enQueue(32));
        System.out.println(queue.enQueue(8));
        System.out.println(queue.enQueue(6));
        System.out.println(queue.Front());

        System.out.println("第2行开始-----------------------------------------");
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(8));
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.Rear());
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(56));
        System.out.println(queue.enQueue(41));
        System.out.println(queue.Front());

        System.out.println("第3行开始-----------------------------------------");
        System.out.println(queue.enQueue(14));
        System.out.println(queue.enQueue(6));
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(25));
        System.out.println(queue.isEmpty());
        System.out.println(queue.Rear());
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(44));
        System.out.println(queue.Front());

        System.out.println("第4行开始-----------------------------------------");
        System.out.println(queue.enQueue(84));
        System.out.println(queue.Rear());
        System.out.println(queue.isEmpty());
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(59));
        System.out.println(queue.Front());
        System.out.println(queue.Front());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Front());

        System.out.println("第5行开始-----------------------------------------");
        System.out.println(queue.enQueue(40));
        System.out.println(queue.enQueue(11));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(94));
        System.out.println(queue.isFull());
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(72));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(19));
        System.out.println(queue.isEmpty());

        System.out.println("第6行开始-----------------------------------------");
        System.out.println(queue.isEmpty());
        System.out.println(queue.enQueue(20));
        System.out.println(queue.Front());
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(58));
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(54));

        System.out.println("第7行开始-----------------------------------------");
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        System.out.println(queue.Front());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(65));
        System.out.println(queue.deQueue());
        System.out.println(queue.Rear());
        System.out.println(queue.enQueue(95));
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(26));

        System.out.println("第8行开始-----------------------------------------");
        System.out.println(queue.enQueue(10));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(14));
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(2));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(37));
        System.out.println(queue.Front());
        System.out.println(queue.Front());
        System.out.println(queue.enQueue(46));

        */
/**
         测试结果
         true,false,true,true,false,true,true,true,71,
         71,6,true,8,true,3,71,true,true,71,
         true,true,6,true,false,25,71,25,true,71,
         true,84,false,84,true,71,71,true,true,32,
         true,true,true,true,false,1,true,true,true,false,
         false,true,32,32,20,true,8,true,58,true,
         54,54,8,true,true,true,65,true,8,true,
         true,true,true,3,true,true,true,56,56,true,
         *//*

    }

}
*/
