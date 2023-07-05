public class KItemsWithMaxSum {

    class Solution{
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            if (k <= numOnes + numZeros) {
                if (k < numOnes) return k;
                else return numOnes;
            }
            else if (k > numOnes + numZeros) return numOnes - (k - (numOnes + numZeros));
            return 0;
        }
    }

    public static void main(String[] args) {
        KItemsWithMaxSum kItemsWithMaxSum = new KItemsWithMaxSum();
        Solution solution = kItemsWithMaxSum.new Solution();
        System.out.println(solution.kItemsWithMaximumSum(6, 6, 6, 13));
    }

}
