public class sqrt_x {

    class Solution {
        public int mySqrt(int x) {
            //自己写的解法会超时
//            //先找出范围，再使用二分法
//            if (x<0) return 0;
//            for (int i = 1; i < 46349; i++) {
//                if (i*i==x) return i;
//                else if (i*i>x){ //找到范围区间[i-1, i]
//                    return sqrt(i-1, i, x);
//                }
//                //小于x继续向后找
//            }
//            return 0;

            //官方二分查找解法
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }

        public int sqrt(int l, int r, int x){
            double error = 0.9;
            double small = l;
            double large = r;
            while (error > 0.5 && error > 0){
                double sqrtX = (r-l)/2.0 + l;
                error = sqrtX*sqrtX - x;
                if (error > 0.2) large = sqrtX;
                if (error < 0) small = sqrtX;
            }
            return (int) small;
        }
    }

    public static void main(String[] args) {
        sqrt_x sqrtX = new sqrt_x();
        Solution solution = sqrtX.new Solution();
        System.out.println(solution.mySqrt(89));
    }

}
