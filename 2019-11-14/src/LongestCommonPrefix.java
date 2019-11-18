import java.util.*;

/*14.最长公共前缀：
* 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
* */
public class LongestCommonPrefix {
    //方法1：水平扫描法
    public static String func1(String[] strs){
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {  //指定子字符串在字符串strs[i]中第一次出现的下标不为0时
                prefix = prefix.substring(0, prefix.length() - 1);   //重新截取子字符串
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //方法2：从前往后枚举字符串的每一列，
    // 先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）
    // 然后再进行对下一列的比较
    public static String func2(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        for(int i = 0;i < strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if( i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
