import java.util.*;

/*8.字符串转换整数：
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空
     或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。
* */
public class StringToInt {
    public static int myAtoi(String str) {
        str = str.trim();  //该方法去除了原字符串首尾的空格
        if(str == null || str.length() == 0){
            return 0;
        }
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if(firstChar == '+'){
            sign = 1;
            start++;
        }else if(firstChar == '-'){
            sign = -1;
            start++;
        }
        for(int i = start;i < str.length();i++){
            if(!Character.isDigit(str.charAt(i))){   //判断所取得的字符是否为数字
                return (int)res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            //将字符串中的数字变为long类型 , res是long类型。
            // 比如：0123, res = 0 + 0；res = 0 * 10 + 1；res = 1 * 10 + 2；res = 12 * 10 + 3； res = 123 。
            if(sign == 1 && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && res > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)res * sign;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            System.out.println(myAtoi(str));
        }
    }
}
