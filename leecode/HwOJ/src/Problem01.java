import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem01 {

    // 待实现函数，在此函数中填入答题代码

    /**
     * @param arrayA a组告警id
     * @param arrayB b组告警id
     * @return
     */
    private static String[] getAllFault(String[] arrayA, String[] arrayB) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0, j = 0; i < arrayA.length || j < arrayB.length; i++, j++) {
            if (i < arrayA.length) set.add(arrayA[i]);
            if (j < arrayB.length) set.add(arrayB[i]);
        }

        String[] res = new String[set.size()];
        set.toArray(res);

        Arrays.sort(res, 0, res.length, (s1, s2) -> {
            int length1 = s1.length();
            int length2 = s2.length();
            int i = 0, j = 0;
            while (i++ < length1 && j++ < length2){
                if (s1.charAt(i) - s2.charAt(j) > 0) return 1;
                else if (s1.charAt(i) - s2.charAt(j) < 0) return -1;
            }

            if (i < length1) return 1;
            if (j < length2) return -1;

            return 0; //这里是i和j相等，也就是两个字符串相等的情况
        });

        return res;
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int arrayALen = Integer.parseInt(cin.nextLine().trim());
        String[] arrayA = new String[0];
        if (arrayALen > 0) {
            arrayA = cin.nextLine().trim().split(" ");
        } else {
            cin.nextLine();
        }


        int arrayBLen = Integer.parseInt(cin.nextLine().trim());
        String[] arrayB = new String[0];
        if (arrayBLen > 0) {
            arrayB = cin.nextLine().trim().split(" ");
        }

        cin.close();

        String[] result = getAllFault(arrayA, arrayB);
        System.out.print("[" + String.join(" ", result) + "]");
    }

}
