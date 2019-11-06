import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class Test1 {
   /*方法1：检查全部子字符串中是否有重复字符，并及时更新无重复子字符串的最大长度*
   *时间复杂度：O(n^3)
    */
    public int lengthOfLongestSubstring1(String s) {     //超出时间限制
        int ans = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i + 1;j <= s.length();j++){
                if(allUniques(s,i,j)){
                    ans = Math.max(ans,j - i);
                }
            }
        }
        return ans;
    }
    private boolean allUniques(String s, int begin, int end) {
        Set<Character> set = new HashSet<>();
        for(int i = begin;i < end;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    /*方法2：使用HashSet作为滑动窗口[i,j)
    * 如果从索引 i 到 j - 1之间的子字符串Sij已经被检查为没有重复字符，
    * 以后只需要检查s[j]是否已经存在于子字符串Sij中，并及时更新最大长度
​	*/
    public int lengthOfLongestSubstring2(String s) {    //执行用时：14ms   内存消耗：36.8MB
        int n = s.length();
        int ans = 0;
        int i = 0,j = 0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    /*方法3：优化的滑动窗口
    *如果 s[j] 在 [i, j)范围内有与 j'重复的字符，我们不需要逐渐增加 i。
    * 我们可以直接跳过 [i，j']范围内的所有元素，并将 i 变为 j' + 1
    * */
    public int lengthOfLongestSubstring3(String s){    //执行用时：12ms   内存消耗：37.2MB
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0,j = 0;j < n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j - i + 1);
            map.put(s.charAt(j),j + 1);   //如果已经存在s.charAt(j),更新它的位置？？？
        }
        return ans;
    }
}
