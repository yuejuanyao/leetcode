package string;

import org.junit.Test;

import java.util.Stack;

public class Add_strings_415 {
    public String addStrings(String num1, String num2) {
        int lengthOne = num1.length();
        int lengthTwo = num2.length();
        int maxLength = Math.max(lengthOne, lengthTwo);
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();
        for (int i = 0; i < maxLength; i++) {
            if (i < lengthOne)
                stackOne.push(num1.charAt(i));
            if (i < lengthTwo)
                stackTwo.push(num2.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        int c = 0;
        int cur = 0;
        while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
            if (stackOne.isEmpty())
                cur = stackTwo.pop()-'0' + c;
            else if (stackTwo.isEmpty())
                cur = stackOne.pop()-'0' + c;
            else
                cur = stackOne.pop()-'0' + stackTwo.pop()-'0' + c;
            if (cur > 9) {
                cur -= 10;
                c = 1;
            } else
                c = 0;
            res.insert(0, (char) (cur+'0'));
        }
        if (c == 1)
            res.insert(0, '1');
        return res.toString();
    }

    public String addStrings1(String num1, String num2) {
        int indexOne = num1.length()-1;
        int indexTwo = num2.length()-1;
        int cur = 0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for(; indexOne>=0 || indexTwo>=0; indexOne--,indexTwo--){
            if (indexOne<0)
                cur = num2.charAt(indexTwo)-'0' + carry;
            else if (indexTwo<0)
                cur = num1.charAt(indexOne)-'0' + carry;
            else
                cur = num1.charAt(indexOne) -'0' + num2.charAt(indexTwo) -'0' + carry;
            if (cur > 9){
                cur -= 10;
                carry = 1;
            }else {
                carry =0;
            }
            res.append(cur);
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addStrings("99", "11111"));
    }
}
