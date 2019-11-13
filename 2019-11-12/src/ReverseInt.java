import java.util.*;

public class ReverseInt {
    public static int reverse(int x){
        long t = 0;
        while(x != 0){
            int m = x % 10;
            t = t * 10 + m;
            if(t > Integer.MAX_VALUE || t < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(reverse(x));
        }
    }
}
