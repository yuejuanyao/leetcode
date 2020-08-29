package tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Hafufman {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>();
        while (n > 0){
            int input = sc.nextInt();
            queue.offer(input);
            n--;
        }
        int ans = 0;
        while (queue.size()>1){
            int min = queue.poll();
            int secondMin = queue.poll();
            queue.offer(min + secondMin);
            ans += min + secondMin;
        }
        System.out.println(ans);
    }


}
