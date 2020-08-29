package practice1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fizz_buzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = (i % 3 == 0);
            boolean isFive = (i % 5 == 0);
            if (isThree && isFive) {
                    list.add("FizzBuzz");
            }else if (isThree)
                list.add("Fizz");
            else if (isFive)
                list.add("Buzz");
            else
                list.add(String.valueOf(i));
        }
        return list;
    }
    public List<String> fizzBuzz_1(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder res = new StringBuilder();
            if (i % 3 == 0)
                res.append("Fizz");
            if (i % 5 == 0)
                res.append("Buzz");
            if (res.length() == 0)
                res.append(i);
            list.add(res.toString());
        }
        return list;
    }
}
