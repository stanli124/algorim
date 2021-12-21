/**
 * 2021 12 21    一年中的第几天
 * 给定一个字符串date，按照YYYY-MM-DD格式表示一个现行公元纪年法日期。请你计算并返回该日期是当年的第几天；
 * 一般我们设定1月1日是第一天，1月2日是第二天，以此类推；
 *
 * 因为二月份的天数会变化，所以需要额外定义一个二月的天数；
 */

package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class dayOfYear {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println(day_of_year("2012-01-02"));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static int day_of_year(String date){
        //使用枚举还是map来保存月份和天数的映射关系；
//        HashMap<Integer, Integer> Month = new HashMap();
//        Month.put(1, 31);
//        Month.put(2, 28);
//        Month.put(3, 31);
//        Month.put(4, 30);
//        Month.put(5, 31);
//        Month.put(6, 30);
//        Month.put(7, 31);
//        Month.put(8, 31);
//        Month.put(9, 30);
//        Month.put(10, 31);
//        Month.put(11, 30);
//        Month.put(12, 31);
//
//        HashMap<Integer, Integer> Month_r = new HashMap();
//        Month_r.put(1, 31);
//        Month_r.put(2, 29);
//        Month_r.put(3, 31);
//        Month_r.put(4, 30);
//        Month_r.put(5, 31);
//        Month_r.put(6, 30);
//        Month_r.put(7, 31);
//        Month_r.put(8, 31);
//        Month_r.put(9, 30);
//        Month_r.put(10, 31);
//        Month_r.put(11, 30);
//        Month_r.put(12, 31);
//
//
//
//        ArrayList<Integer> day_mon_year = new ArrayList<>();
//        boolean flag = false;
//        int days = 0;
//
//        for (String s : date.split("-")) day_mon_year.add(Integer.valueOf(s));
//
//        if ((day_mon_year.get(0)%4==0&&day_mon_year.get(0)%100!=0) || day_mon_year.get(0)%400==0) flag=true;
//        if (flag) {
//            for (int i = 1; i < day_mon_year.get(1); i++) {
//                days+=Month_r.get(i);
//            }
//        }
//        else  {
//            for (int i = 1; i < day_mon_year.get(1); i++) {
//                days+=Month.get(i);
//            }
//        }
//
//        days+=day_mon_year.get(2);
//
//        return days;


        //如果是闰年且超过月份超过2月，则最后加1就行；
//        HashMap<Integer, Integer> Month = new HashMap();
//        Month.put(1, 31);
//        Month.put(2, 28);
//        Month.put(3, 31);
//        Month.put(4, 30);
//        Month.put(5, 31);
//        Month.put(6, 30);
//        Month.put(7, 31);
//        Month.put(8, 31);
//        Month.put(9, 30);
//        Month.put(10, 31);
//        Month.put(11, 30);
//        Month.put(12, 31);
//
//
//        ArrayList<Integer> day_mon_year = new ArrayList<>();
//        boolean flag = false;
//        int days = 0;
//
//        for (String s : date.split("-")) day_mon_year.add(Integer.valueOf(s));
//
//        if ((day_mon_year.get(0)%4==0&&day_mon_year.get(0)%100!=0) || day_mon_year.get(0)%400==0) flag=true;
//        for (int i = 1; i < day_mon_year.get(1); i++) days+=Month.get(i);
//        days+=day_mon_year.get(2);
//
//        if (flag && day_mon_year.get(1)>2) days+=1;
//
//        return days;



        //不用建立映射关系，只要知道是几个月以及是不是闰年；按照顺序加起来，是闰年则在加一就行；
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(5,7));
        int day = Integer.valueOf(date.substring(8));

        int days = 0;
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        for (int i = 0; i < month-1; i++) {
            days += months[i];
        }  //最后一个月之前相加；

        if ((year%4==0&&year%100!=0 || year%400==0) && month>2){
            days += 1;
        } //闰年+1
        days+=day;  //加上最后一个月已经过了的天数；

        return days;
    }

}
