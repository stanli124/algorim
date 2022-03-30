/** 替换空格
 *  把给定字符串中的每个空格替换成"%20"
 */

package doublePoint.easy;

public class jianzhiOffer05 {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        if (s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if (c == ' '){
                sb.append("%20");
            }else sb.append(c);
        }
        return sb.toString();
    }

}
