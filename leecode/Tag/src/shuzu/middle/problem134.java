/** 加油站
 *
 */

package shuzu.middle;

public class problem134 {

    public static void main(String[] args) {

        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int oil = 0;
        int idx = -1;
        int index = 0;

        if (len > 1){
            while (index < len){
                if (gas[index]!=cost[index]) break;
                index++;
            }
            if (index==len-1) return 0;
        }


        for (int i = index; i < len; i++) {
            if (idx!=-1) break;
            oil = 0;
            for (int j = i; j < len+i; j++) {
                oil = oil + gas[j%len] - cost[j%len];
                if (oil < 0) break;
            }
            if (oil>=0) idx=i;
        }
        return idx;

    }
}
