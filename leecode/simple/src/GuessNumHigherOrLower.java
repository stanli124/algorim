public class GuessNumHigherOrLower {

    public static void main(String[] args) {

    }

    public int guessNumber(int n){
        int low = 1;
        int high = n;
        n = binarySearch(low, high);

        while (n >= 1){
            int guess = guess(n);

            if (guess == 0) return n;
            else if (guess == -1){
                high = n;
                n = binarySearch(low, high);
            }else {
                low = n;
                n = binarySearch(low+1, high);
            }
        }
        return 0;
    }

    public int binarySearch(int low, int high){
        return (high-low)/2 + low;
    }

    public int guess(int n){
        return 0;
    }

}
