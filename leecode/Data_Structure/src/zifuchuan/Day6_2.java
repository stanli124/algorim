/** 赎金信
 *  给你两个字符串：ransomNote和magazine，判断ransomNote能不能由magazine里面的字符构成。
 *  如果可以，返回 true；否则返回 false。
 *  magazine 中的每个字符只能在 ransomNote 中使用一次。
 *  如果字符a在magezine中出现两次，那么在ransomNote也能出现两次；
 */

package zifuchuan;

public class Day6_2 {

    public static void main(String[] args) {

        String note = "a";
        String magazine = "b";

        long startTime = System.currentTimeMillis();
        System.out.println(canConstruct(note, magazine));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        //使用两个int数组分别存储两个字符串的字符及对应出现次数；
        char c = 'a';
        int[] rn = new int[26];
        int[] mz = new int[26];
        int idx = 0;


        for (int i = 0; i < ransomNote.length(); i++) {
            idx = ransomNote.charAt(i) - c;  //找到ransomNote相应字符的索引位置并加1；
            rn[idx]++;
        }
        for (int i = 0; i < magazine.length(); i++) {   //找到magazine相应字符的索引位置并加1；
            idx = magazine.charAt(i) - c;
            mz[idx]++;
        }
        for (int i = 0; i < 26; i++) {   //若rn是被表示字符串，若rn中对应字符的出现次数比ma对应字符的多 或者ma中没有rn中的字符，那么ma无法表示rn，就返回false；
            if (rn[i] > mz[i]) return false;
        }

        return true;
    }


}
