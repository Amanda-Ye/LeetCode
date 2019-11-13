import java.util.*;
/*最长回文子串：
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
* */
public class LongestSub {
    public static String longestPalindrome(String s) {
        String t = "";
        String ans = "";
        int max = 0;
        //int begin = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i + 1;j <= s.length();j++){
                t = s.substring(i,j);
                StringBuilder sb = new StringBuilder(t);
                if(sb.equals(sb.reverse()) && t.length() > max){
                    ans = t;
                    max = ans.length();
                        //begin = i ;
                }
            }
        }
        return ans;
        //return s.substring(begin,begin + max);
    }
    private static boolean isHuiwen(String s){
        for(int i = 0;i < s.length() / 2;i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
