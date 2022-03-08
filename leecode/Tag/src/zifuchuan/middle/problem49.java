/** 字母异位词分组
 *  给你一个字符串数组，请你将字母异位词组合在一起，可以按任意顺序返回结果列表。
 *  字母异位词是由重新排列源单词的字母得到的一个新单词，所有源单词汇总的字母通常恰好只用一次
 *
 *
 */

package zifuchuan.middle;

import java.util.*;

public class problem49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"ill","cab","tin","pew","duh","may","buy","bar","max","doc"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

//        HashMap<Integer, List<String>> ans = new HashMap<>(); //ascii码的和->相应的字母异位词列表
//        for (int i = 0; i < strs.length; i++) {
//            String s = strs[i]; //取出当前字符串
//            HashSet<Character> same = new HashSet<>(); //判断字符是否相同
//            //求ascii码的和
//            int sum = 0;
//            for (int j = 0; j < s.length(); j++) {
//                same.add(s.charAt(j));
//                sum+=s.charAt(j);
//            }
//
//            if (ans.containsKey(sum)){ //若包含当前字母异位词，则将其添加进对应的列表。
//                String lf = ans.get(sum).get(0);
//                for (int j = 0; j < lf.length(); j++) {
//                    if (!same.contains(lf.charAt(j))){
//                        ans.put(sum, new LinkedList());
//                        ans.get(sum).add(s);
//                        break;
//                    }
//                }
//
//                ans.get(sum).add(s);
//            }else {  //不包含当前字母异位词，则新建对应的列表；
//                ans.put(sum, new LinkedList());
//                ans.get(sum).add(s);
//            }
//        }
//
//        List<List<String>> res = new ArrayList<>();
//
//        Set<Integer> k = ans.keySet(); //取得key，并通过key遍历map，将其添加进返回结果中。
//        for(Integer n : k){
//            res.add(ans.get(n));
//        }
//
//        return res;

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>()); //getOrDefault是有这个key，就使用对应的键，否则创建一个新的列表。
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());


    }

}










