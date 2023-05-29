public class AverageValue {

    class Solution{

        public int averageValue(int[] nums){
            int evenCounts = 0;
            int evenSums = 0;
            for (int num : nums){
                if (num % 2 == 0 && num % 3 == 0){
                    evenSums += num;
                    evenCounts += 1;
                }
            }
            if (evenCounts==0) return 0;
            return evenSums / evenCounts;
        }

    }

    public static void main(String[] args) {

        AverageValue averageValue = new AverageValue();
        Solution solution = averageValue.new Solution();
        System.out.println(solution.averageValue(new int[]{1,2,4,10,7}));

    }

}