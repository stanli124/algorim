package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

//队列实现栈
public class problem225 {

    public static void main(String[] args) {
        myStack<Integer> a = new myStack<>();
        System.out.println(a.push(1));
        System.out.println(a.push(2));
        System.out.println(a.push(3));

        System.out.println(a.top());
        System.out.println(a.pop());

        System.out.println(a.push(232));
        System.out.println(a.top());

        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());


    }

}


class myStack<E>{

    Queue<E> a ;
    Queue<E> b ;

    public myStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public E push(E e){
        a.offer(e);
        while (!b.isEmpty()) //来一个元素就把该元素，放在队列头部
            a.offer(b.poll());
        Queue<E> swap = b;
        b = a;
        a = swap;

        return e;
    }

    public E pop(){
        return b.poll();
    }

    public E top(){

        return b.peek();
    }

    public boolean empty(){
        return a.isEmpty() && b.isEmpty();
    }



}
