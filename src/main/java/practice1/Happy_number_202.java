package practice1;

import java.util.HashSet;
import java.util.Set;

public class Happy_number_202 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n!=1){
            n = change(n);
            System.out.println(n);
            if(set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }

    private static int change(int n) {
        int new_n = 0;
        while (n != 0){
            new_n += Math.pow((n%10),2);
            n /= 10;
        }
        return new_n;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(18));
    }
}
