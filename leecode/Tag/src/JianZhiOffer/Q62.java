package JianZhiOffer;

//圆圈中最后剩下的数字

import java.util.ArrayList;
import java.util.LinkedList;

public class Q62 {

    public static void main(String[] args) {

    }

    public int lastRemaining(int n, int m){
//        int index = 0;
//        int count = 0;
//        boolean[] res = new boolean[n];
//        while (count != n-1){
//            int counts = 0;
//            if (index >= n) index = index % n;
//            while (counts!=m){
//                if (res[index]) continue;
//                index++;
//                counts++;
//                if (index >= n) index = index % n;
//            }
//            res[index] = true;
//        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(i);
        }

        int index = 0;
        while (a.size()!=1){ //删到只剩下最后一个数字
            index += m; //计算下一个需要删除的值的位置
            index = (index-1) % a.size(); //如果超过了长度，需要求余
            a.remove(index);
        }
        return a.get(0);
    }

}
