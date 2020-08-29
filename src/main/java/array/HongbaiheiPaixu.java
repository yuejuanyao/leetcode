package array;

import org.junit.Test;

public class HongbaiheiPaixu {
    public int[] arraySort(int[] balls) {
        if (balls == null || balls.length <= 1)
            return balls;
        int red = 0;
        int black = balls.length - 1;
        for (int white = 0; white < balls.length; white++) {
            while (red <= white && white <= black) {
                if (balls[white] == 1){
                    swap(balls, red, white);
                    red ++;
                }else if(balls[white] == 3){
                    swap(balls, white, black);
                    black --;
                }else
                    break;;
            }
        }
        return balls;
    }

    private void swap(int[] ball, int i, int j) {
        int tmp = ball[i];
        ball[i] = ball[j];
        ball[j] = tmp;
    }

    @Test
    public void test(){
        int[] balls = {1,2,3,3,2,1,1,1,2,3,1,2,2,3};
        arraySort(balls);
        for (int num : balls){
            System.out.println(num);
        }
    }

}
