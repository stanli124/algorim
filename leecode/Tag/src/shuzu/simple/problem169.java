package shuzu.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class problem169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {

        int counts = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }

        Set<Integer> a = map.keySet();
        for (int n : a){
            if (map.get(n)>counts) return n;
        }

        return 0;
    }

}
