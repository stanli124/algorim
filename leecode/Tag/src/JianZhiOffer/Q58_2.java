package JianZhiOffer;

//左旋转字符串

public class Q58_2 {

    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n){
        int k = n % s.length();

        String str1 = s.substring(k,s.length());
        String str2 = s.substring(0, k);

        return str1 + str2;

    }

}
