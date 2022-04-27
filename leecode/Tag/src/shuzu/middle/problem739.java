package shuzu.middle;

import java.util.Deque;
import java.util.LinkedList;

public class problem739 {

    public static void main(String[] args) {
        int[] a = new int[]{30,11,11};
        int[] res = dailyTemperatures(a);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }


//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] answer = new int[temperatures.length];
//
//
//        for(int i = answer.length-2; i>=0 ;i--){
//            if(temperatures[i]>temperatures[i+1]){
//                int index = i+1;
//                while(index < answer.length){
//                    if(temperatures[i] > temperatures[index]) index++;
//                    else if(temperatures[i] == temperatures[index]){
//                        answer[i] = answer[index];
//                        break;
//                    }
//                    else{
//                        answer[i] = index - i;
//                        break;
//                    }
//                }
//                if(index==answer.length){
//                    answer[i] = 0;
//                }
//            }
//            else if (temperatures[i] == temperatures[i+1]){
//                if (answer[i+1] > 0) answer[i] = answer[i+1]+1;
//                else answer[i] = answer[i+1];
//            }
//            else{
//                answer[i] = 1;
//            }
//        }
//
//        return answer;
//    }

    public static int[] dailyTemperatures(int[] temperatures){
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


}
