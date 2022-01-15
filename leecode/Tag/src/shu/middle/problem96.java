/** 不同的二叉搜索树
 *  给你一个整数n，求恰由n个节点组成且节点值从1到n互不相同的二叉搜索树有多少种？
 *  二叉搜索树，大的只能在当前节点间右边，小的只能在当前节点左边
 */

package shu.middle;

import java.util.LinkedList;

public class problem96 {

//    public static void main(String[] args) {
//
//        System.out.println(numTrees(5));
//
//    }
//
//    public static int numTrees(int n) {
//
//        Integer cate = 0;
//        find(cate, n, new LinkedList<Integer>() );
//        System.out.println(cate);
//
//        return cate;
//    }
//
//    public static void find(Integer cate, int n, LinkedList<Integer> track){
//        if (track.size() == n){
//            cate+=1;
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (track.contains(i)) continue;
//            int len = track.size();
//            for (int j = 0; j < len; j++) {
//                if (i > track.get(j)) continue;
//                else track.add(j, i);
//            }
//            find(cate, n, track);
//            track.removeLast();
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));
    }

    public static int numTrees(int n) {

        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] = G[i] + G[j-1] * G[i-j];
            }
        }
        return G[n];

    }


}
