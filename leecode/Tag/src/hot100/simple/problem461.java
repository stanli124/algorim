package hot100.simple;

public class problem461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x!=0 && y!=0){
            if (x%2 != y%2){
                count++;
            }
            x = x>>>1;
            y = y>>>1;
        }
        while (x!=0){
            if (x%2==1) count++;
            x = x>>>1;
        }
        while (y!=0){
            if (y%2==1) count++;
            y = y>>>1;
        }

        return count;
    }

}
