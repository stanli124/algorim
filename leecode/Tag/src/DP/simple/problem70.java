package DP.simple;

public class problem70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(9));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return help(n, memo);
    }

    public static int help(int n, int[] memo){
        if (memo[n] > 0)
            return memo[n];
        if (n==1){
            memo[n] = 1;
        }else if (n==2){
            memo[n] = 2;
        }else {
            memo[n] = help(n-1, memo) + help(n-2, memo);
        }

        return memo[n];
    }
    
    

}
