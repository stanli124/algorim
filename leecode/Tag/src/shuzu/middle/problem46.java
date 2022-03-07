/** 全排列
 *  给定一个不含重复数字的数组nums，返回其所有可能的全排列。可以按照任意顺序返回答案
 */

package shuzu.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class problem46 {

    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);

//        while (!reader.hasNext(";")){
//            String s = reader.next();
//            System.out.println("输入为" + s);
//        }

//        while (reader.hasNextInt()){
//            int n = reader.nextInt();
//            System.out.println("输入数字为"+n);
//        }
//
//        reader.close();
//        ArrayList<Integer> l = new ArrayList<>(4);
//        l.add(1);
//        l.add(2);
//        l.add(1);
//        l.add(3);
//        System.out.println(l);
//        System.out.println(l.contains(33));

        permute(new int[]{0,1,2,3});

    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();


        //路径：记录当前已有的选择
        //选择列表：选过的就不能在选了
        //结束条件：长度和数组的长度相等就已选择了全部的数字，可以添加到列表中
        trackback(nums, track, ans);
        System.out.println(ans);

        return ans;

    }

    public static void trackback(int[] nums, ArrayList<Integer> track, List<List<Integer>> ans){
        if (track.size() == nums.length){
            ans.add(new LinkedList(track)); //要new一个对象，不然每次添加的都是同一个对象
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            trackback(nums, track, ans);
            track.remove(track.size()-1);
        }

    }

}
