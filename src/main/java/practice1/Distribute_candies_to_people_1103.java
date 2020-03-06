package practice1;

import org.junit.Test;

public class Distribute_candies_to_people_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] person_candy = new int[num_people];
        int times = 0;
        int candy_num = 1;
        while (candies > 0) {
            if (candies > candy_num) {
                person_candy[times % num_people] += candy_num;
                candies -= candy_num;
            } else {
                person_candy[times % num_people] += candies;
                candies -= candies;
            }
            times++;
            candy_num++;
        }
        return person_candy;
    }

    public int[] distributeCandies_1(int candies, int num_people) {
        int[] person_candy = new int[num_people];
        int times = 0;
        while (candies > 0){
            int cur_person_candy = Math.min(times+1,candies);
            person_candy[times % num_people] += cur_person_candy;
            candies -= cur_person_candy;
            times ++;
        }
        return person_candy;
    }

    @Test
    public void test() {
        int[] person_candy = distributeCandies_1(10, 3);
        for (int x : person_candy) {
            System.out.print(x + " ");
        }
    }
}
