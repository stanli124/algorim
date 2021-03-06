import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 用一个set来保存出现在第一位上的所有数字，另一个set来保存在第二位上出现的数字
 * 1.target不会出现在数字对的第一位上
 * 2.除了target外的每个数字都信任target，也就是都要与target结成数字对;记录下每个数字出现的次数，只有target出现的次数是n-1；
 */

public class Town_judge {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 2;
        int[][] trust = {};
        System.out.println(findJudge(n, trust));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    public static int findJudge(int n, int[][] trust){
//        if (trust.length ==0 && n==1) return 1;
////        HashMap<Integer,Integer> firstNum = new HashMap<Integer,Integer>();
//        HashSet<Integer> firstNum = new HashSet<>();
//        HashMap<Integer,Integer> secondNum = new HashMap<Integer,Integer>();
//
//
//        for (int[] numPair : trust){
////            System.out.print(numPair[0]);
////            System.out.println(numPair[1]);
////            if (firstNum.get(numPair[0])==null) firstNum.put(numPair[0], 1);
////            else firstNum.replace(numPair[0], firstNum.get(numPair[0])+1);
//            firstNum.add(numPair[0]);
//            if (secondNum.get(numPair[1])==null) secondNum.put(numPair[1], 1);
//            else secondNum.replace(numPair[1], secondNum.get(numPair[1])+1);
//        }
//
//        Set finalJudge = secondNum.keySet();     //出现在第二个位置的所有数字
//        firstNum.retainAll(finalJudge);  //求出在第二个位置，但不是target的数字；因为出现在第一个位置一定不是target
//        finalJudge.removeAll(firstNum);  //去掉不是target的数字，求出最终候选结果
//
//        if (finalJudge.size() > 1 || finalJudge.size() == 0) return -1;
//        if (secondNum.get(finalJudge.toArray()[0]) == n-1) return (int)finalJudge.toArray()[0];
//        else return -1;
////        System.out.println(firstNum.toString());
////        System.out.println(secondNum.toString());


        //使用图的方式来解题目；使用两个数组分别保存出度和入度。
        //target的出度为0表示不信任任何人，入度为n-1表示其它所有人都信任自己。
        int[] outDegree = new int[n+1];
        int[] inDegree = new int[n+1];

        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0]] = outDegree[trust[i][0]]+1;
            inDegree[trust[i][1]] = inDegree[trust[i][1]]+1;
        }

        for (int i = 1; i < outDegree.length; i++) {
            if (outDegree[i]==0 && inDegree[i]==n-1) return i;
        }
        return -1;
    }

}
