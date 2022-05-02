/**
 * 用栈实现队列，用两个栈实现先入先出队列
 * 应该支持，push、pop、peek、empty操作。
 */

package dataStructure;

import java.util.Stack;

public class problem232 {

    public static void main(String[] args) {

        myQueue<Integer> a = new myQueue<Integer>();
        System.out.println(a.push(1));
        System.out.println(a.push(2));
        System.out.println(a.push(3));

        System.out.println(a.peek());
        System.out.println(a.pop());
        System.out.println(a.peek());
        System.out.println(a.push(2341));
        System.out.println(a.peek());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());

    }
}

class myQueue<E>{

    Stack<E> a ; //只用来push元素
    Stack<E> b ; //peek和pop都从这个栈里面取


    public myQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public E push(E e){
        a.push(e);
        return e;
    }

    public E pop(){
        if (b.empty()){
            while (!a.empty())
                b.push(a.pop()); //b为空，则需要从a中取出元素
        }

        return b.pop();
    }

    public E peek(){
        if (b.empty()){
            while (!a.empty())
                b.push(a.pop()); //b为空，则需要从a中取出元素
        }
        return b.peek();
    }

    public boolean empty(){
        return a.empty() && b.empty();
    }

}
