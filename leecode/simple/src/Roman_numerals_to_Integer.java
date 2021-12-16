import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *罗马数字包含： I、V、X、L、C、D、M
 *一般情况下，罗马数字中小的数字在大的数字右边。但也存在特例，4写做IV不写作IIII。小数在大树坐标表示减法，小数在大数右边表示加法；
 *
 * //每次匹配一个字符，从左到右；因为只有六种情况，所以只需要检测这六种情况有没有发生就行；
 *
 * 正则匹配字符串；挨个字符检验，如果是特殊情况直接计算特殊情况的值，并跳过相应的位置
 */



public class Roman_numerals_to_Integer {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s){
        HashMap<String, Integer> map = new HashMap();  //用来取得罗马字符对应的数值；
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        StringBuffer S = new StringBuffer();
        int temp = 0;
        int flag = 0;

        for (int i = 0; i < s.length()-1;) {
            String  c1 = String.valueOf(s.charAt(i));
            String  c2 = String.valueOf(s.charAt(i+1));
            S.append(c1);
            S.append(c2);
            if (map.get(c1)!=null) {
                if ( map.get(S.toString()) != null ){temp += map.get(S.toString()); i+=2;}
                else {temp += map.get(c1); i++;}
            }
            S.delete(0, 2);
            flag = i;
        }
        if (flag >= s.length()){}
        else {temp += map.get(String.valueOf(s.charAt(s.length()-1)));}

        return temp;
    }
}
