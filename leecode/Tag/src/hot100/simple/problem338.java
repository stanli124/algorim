package hot100.simple;

public class problem338 {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <= n; i++) {
            int count = countOneInBits(i);
            ans[i] = count;
        }

        return ans;
    }

    //计算给定数字的二进制中1的个数
    public int countOneInBits(int i){

        if (i==0) return 0;
        int count = 0;
        while (i != 0){
            if (i % 2 == 1) count++;
            i/=2;
        }

        return count;
    }


}
