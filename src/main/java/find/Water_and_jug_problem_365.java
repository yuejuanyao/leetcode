package find;

import javafx.util.Pair;

import java.util.*;

public class Water_and_jug_problem_365 {
    /*
    有8种可能的状态
    1. A是满的，把A倒空
    2. B是满的，把B倒空
    3. A是空的，把A倒满
    4. B是空的，把B倒满
    5. A是空的B是满的，把B导入A，A不满，B空了
    6. A是空的B是满的，把B导入A，A满了，B还剩
    7. B是空的A是满的，把A导入B，B不满，A空了
    8. B是空的A是满的，把A导入B，B满，A还剩
         */
    Queue<Pair<Integer, Integer>> nextState = new LinkedList<>();
    Set<Pair<Integer, Integer>> hasTry = new HashSet<>();

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x + y < z)
            return false;
        if (x == y && x != z && x + y != z)
            return false;
        Pair<Integer, Integer>start = new Pair<>(0, 0);
        nextState.add(start);
        List<Pair<Integer, Integer>> maybeNext;
        hasTry.add(start);
        while (!nextState.isEmpty()) {
            Pair<Integer, Integer> cur = nextState.poll();
            int cur_x = cur.getKey();
            int cur_y = cur.getValue();
            if (z == cur_x || z == cur_y || z == cur_x + cur_y)
                return true;
            maybeNext = findNextState(cur_x, cur_y, x, y);
            for (Pair<Integer, Integer> pair: maybeNext ){
                if (!hasTry.contains(pair)){
                    nextState.add(pair);
                    hasTry.add(pair);
                }
            }
        }
        return false;
    }

    private List<Pair<Integer, Integer>> findNextState(int cur_x, int cur_y, int x, int y) {
        List<Pair<Integer, Integer>> next = new ArrayList<>(8);
        if (cur_x == 0)
            next.add(new Pair<>(x, cur_y));
        if (cur_y == 0)
            next.add(new Pair<>(cur_x, y));
        if (cur_x == x)
            next.add(new Pair<>(0, cur_y));
        if (cur_y == y)
            next.add(new Pair<>(cur_x, 0));
        // 从 A导入B ,A有水，B不满
        if (cur_x > 0 && cur_y < y){
            if (cur_x > y-cur_y) //A的 水比B缺的多
                next.add(new Pair<>(cur_x-(y-cur_y), y));
            else //A的 水比B缺的少
                next.add(new Pair<>(0,cur_y+cur_x));
        }
        // 从 B导入A ,B有水，A不满
        if (cur_x <x && cur_y > 0){
            if (cur_y > (x - cur_x)) //B的 水比A缺的多
                next.add(new Pair<>(x, cur_y- (x - cur_x)));
            else //B的 水比A缺的少
                next.add(new Pair<>(cur_x + cur_y,0));
        }
        return next;
    }

    public boolean canMeasureWater_1(int x, int y, int z) {
        if (z > x+y)
            return false;
        if (x == z || y == z || x+y ==z )
            return true;
        return z % gbc(x,y) == 0;
    }
    private int gbc(int a, int b){
        if (a % b == 0)
            return b;
        return gbc(b, a%b);
    }
}
