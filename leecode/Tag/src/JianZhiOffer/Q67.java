package JianZhiOffer;

public class Q67 {

    public static void main(String[] args) {
        System.out.println(strToInt("2147483648"));
    }

    //丢弃开头无用的空格
    public static int strToInt(String str) {
        //丢弃开头空格
        str = str.trim();
        if (str.equals("")) return 0;
        StringBuffer sb = new StringBuffer();

        int countFlag = 0;
        for(char c: str.toCharArray()){
            if (c == '-' || c == '+'){
                countFlag++;
                if (countFlag > 1) return 0;
                sb.append(c);
            }
            else if (c >= '0' && c <= '9'){
                sb.append(c);
            }
            else if (c < '0' || c > '9'){
                break;
            }
        }
        if (sb.length()==0) return 0;

        int sum = 0;
        for (int i = sb.length()-1, j=0; i >= 0; i--, j++) {

            if (sb.charAt(0) == '-'){
                if (i!=0){
                    if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && sb.charAt(i)-'0' < -8)) return Integer.MIN_VALUE;
                    sum = sum + -(int)Math.pow(10,j) * (sb.charAt(i)-'0');
                }
            }else {
                if (sb.charAt(0) == '+'){
                    if (i!=0){
                        if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && sb.charAt(i)-'0' > 7)) return Integer.MAX_VALUE;
                        sum = sum + (int)Math.pow(10,j) * (sb.charAt(i)-'0');
                    }
                }else {
                    if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && sb.charAt(i)-'0' > 7)) return Integer.MAX_VALUE;
                    sum = sum + (int)Math.pow(10,j) * (sb.charAt(i)-'0');
                }
            }
        }
        return sum;
    }

}
