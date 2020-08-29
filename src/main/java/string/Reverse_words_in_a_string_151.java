package string;

import org.junit.Test;

import java.util.*;

public class Reverse_words_in_a_string_151 {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0)
            return s;

        String[] strings = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        if (strings.length <= 0)
            return "";
        for (int i = strings.length - 1; i >= 0; i--) {
            res.append(strings[i]);
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public String reverseWords_1(String s) {
        if (s == null || s.length() <= 0)
            return s;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder word = new StringBuilder(); //陷阱1，使用stringbuider压入站的时候，如果修改了内容之前压入的都会需改
        Deque<String> d = new ArrayDeque(); //陷阱2不可以使用stack因为stack的本质还是数组，Itertor还是从头遍历
        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c==' '){
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if (c != ' '){
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }

    

    @Test
    public void test() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
//        Iterator<Integer> iterator = s.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        ListIterator<Integer> listIterator = s.listIterator(3);

        while (listIterator.hasPrevious()){
            System.out.println("previousIndex " + listIterator.previousIndex());
            System.out.println("nextIndex " + listIterator.nextIndex());
            System.out.println(listIterator.previous());
        }
    }
}
