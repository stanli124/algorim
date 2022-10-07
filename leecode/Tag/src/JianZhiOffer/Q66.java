package JianZhiOffer;

public class Q66 {
    //暴力会超时
//    public int[] constructArr(int[] a){
//        int[] b = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            b[i] = 1;
//            for (int j = 0; j < a.length; j++) {
//                if (j == i) continue;
//                b[i] *= a[j];
//            }
//        }
//        return b;
//    }
    public static void main(String[] args) {
        System.out.println(constructArr(new int[]{1,2,3,4,5}));
    }

    public static int[] constructArr(int[] a) {
        if (a.length==0) return a;
        int[] l = new int[a.length];
        int[] r = new int[a.length];
        int[] b = new int[a.length];

        l[0]=a[0];
        r[a.length-1]=a[a.length-1];
        for (int i = 1, j=a.length-2; i < a.length && j >= 0; i++, j--) {
            l[i] = l[i-1]*a[i];
            r[j] = a[j]*r[j+1];
        }
        for (int i = 0; i < b.length; i++) {
            int ll = i == 0 ? 1 : l[i-1];
            int rr = i == a.length-1?1 : r[i+1];
            b[i] = ll * rr;
        }
        return b;
    }


}
