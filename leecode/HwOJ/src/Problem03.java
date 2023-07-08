import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Problem03 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String binaryString = cin.nextLine();
        cin.close();
        int result = binaryToDecimal(binaryString);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int binaryToDecimal(String binaryString) {
        BigInteger integer = null;
        if (binaryString.charAt(0) == '1'){
            integer = new BigInteger(binaryString, 2);
            return integer.intValue();
        }
        return Integer.parseInt(binaryString, 2);
    }

}
