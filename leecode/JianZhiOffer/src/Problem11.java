public class Problem11 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!(numbers[i] <= numbers[i + 1])) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
