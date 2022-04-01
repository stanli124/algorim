package Stack_Queue;

import java.util.PriorityQueue;

public class problem295 {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(3);
        obj.addNum(3);
        double num = obj.findMedian();
        System.out.println(num);
    }



}

class MedianFinder {
    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;

    public MedianFinder() {
        l = new PriorityQueue<>((a, b)->b-a); //大根堆
        r = new PriorityQueue<>((a, b)->a-b); //小根堆，默认就是
    }

    public void addNum(int num) {
        int size1 = l.size();
        int size2 = r.size();
        if (size1 == size2){ //在插入当前数之前，已有偶数个元素
            if (r.isEmpty() || num <= r.peek()){ //若小堆为空，或当前值比小堆最小的值小，那么直接插入左边
                l.add(num);
            }else{ //r不为空，且当前元素比小堆最小的元素大，表明当前值应插入后半部分，则插入小堆中。
                l.add(r.poll()); //将后半部分的堆顶元素放入左半部分。
                r.add(num);      //当前值加入后半部分
            }
        }else {   //在插入当前值之前，已有奇数个元素
            if (num >= l.peek()){ //当前元素大于前半部分的最大值，添加到右边
                r.add(num);
            }else {   //当前元素小于前半部分的最大值，则加入到前半部分；
                r.add(l.poll()); //为了保持左右元素数量相等，所以将左边的堆顶元素加入到右边的堆中
                l.add(num);    //将当前值加入到左边堆中
            }
        }
    }

    public double findMedian() {
        if (l.size() == r.size()){
            return (l.peek() + r.peek()) / 2.0;
        }else {
            return l.peek();
        }
    }
}