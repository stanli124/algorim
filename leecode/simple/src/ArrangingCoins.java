public class ArrangingCoins {

    /**
     * layerCounts用来计算每层累加，当小于n时循环继续
     */
    class Solution {
        public int arrangeCoins(int n) {
            int ans = 0;
            int layerNums = 1;
            long layerCounts = 0; //这里不用long的话，由于最大值是2147483647，再下一次循环的时候layerCounts再加一个数就超出了int的表数范围，所以会死循环
            while (layerCounts <=n ){
                layerCounts += layerNums;
                layerNums++;
                ans++;
            }
            return --ans;

//            long sum=0;
//            for(int i=1;;i++){
//                sum+=i;
//                if(sum>n){return i-1;}
//            }
        }
    }

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        Solution solution = arrangingCoins.new Solution();
        System.out.println(solution.arrangeCoins(2147483647));
    }

}
