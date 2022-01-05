/** 最长回文子串
 *  给定一个字符串s， 找到s中最长的回文子串
 *
 */

package zifuchuan.middle;

public class problem5 {

    public static void main(String[] args) {

        String s = "qkajbumzdzkiplmbcpnhbzweoevrvbptpozhtrfntszvnwbdahvkykmezrwruhvvslngruvwqebudtfxgpbmwefczwrecpqjegxkqknpobzkemmtruidulnxgntjxcmxtwmlxhzmbqfqylwvzjyojhfawwuupiipvxjiyxkqvsxbhgzzegfkdihizvjoxzrmeorikzsdyphbujaqmykrfblneqmwwxsoonzsgvligqxrrumspylfvquklbanjhkudlprwoycpxdsueokruoofyubirbhbyfuvgllijywuqmkcsfjttbnmelrylivkefllepgxnoeummujbaoyvryukyoumvuxezegpwgmwsupjuaarvbtbfmisrifjadqjypmzipvjysgakvjhfeaqwpsqijvqibshctuabwqqsjwotjopahoaptmxkwerkjkmwiodgblhtnhykzjuaoluoyokroxuvqtkpggfanzabgjejdfsgybhxbscubdpufywbxgutheskuhixasnksoayjngvhfoxxclykfobrwxjwgefarzczvptlfrgrtrjcemaeihpukhbeoezgvrwxgyhpkkfvmfvquwtswkdwqqgrgasopladdnteulqofmjhewpghkibbrewnhdllfppctgkfkoedoiwqocnpvfviochrokrgrzthrvyhqfsrzyyvqwkhuzsrkfaympcdodkwaojnghzytkhf";
        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome(String s) {
        int reverLen = s.length();

        for (int window = reverLen; window > 0; window--) {
            for (int j = 0; j <= reverLen - window ; j++) {
                String subStr = s.substring(j, j+window);
                if (reverse(subStr, window-1)){
                    return subStr;
                }
            }
        }
        return "";
    }

    public static boolean reverse(String subStr, int len){
        int left = 0;
        while (left < len){
            if (subStr.charAt(left++)!=subStr.charAt(len--)) return false;
        }
        return true;
    }

}
