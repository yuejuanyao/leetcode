package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_primes_204 {
    public static int countPrimes(int n) {
        int count = 0;
        Boolean[] array = new Boolean[n];
        Arrays.fill(array,true);
        for(int i=2; i*i<n; i++){
            if(prime(i)){
                System.out.println(i);
                for(int j=i*i; j<n; j+=i)
                    array[j] = false;
            }

        }
        for(int i=2;i<n;i++){
            if(array[i])
                count++;
        }
        return count;
    }

    private static boolean prime(int n) {
        for(int i=2; i*i<=n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
