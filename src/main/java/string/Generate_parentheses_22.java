package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Generate_parentheses_22 {

    //第一种方法，暴力法
    public List<String> generateParenthesis_1(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid_1(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid_1(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
    // 第二种方法，对第一中进行剪枝
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        char[] curChars = new char[2 * n];
        generateSub(res, 0, curChars);
        return res;
    }

    private void generateSub(List<String> res, int position, char[] curChars) {
        if (position == curChars.length) {
            if (valid(curChars, true,position)) {
                res.add(new String(curChars));
            }
        } else {
            if (valid(curChars, false,position)) { //剪枝操作，注意需要修改之前的认证方法
                curChars[position] = '(';
                generateSub(res, position + 1, curChars);
                curChars[position] = ')';
                generateSub(res, position + 1, curChars);
            }
        }
    }

    private boolean valid(char[] curChars, boolean isLast,int position) {
        int num = 0;
        for (int i = 0; i< position; i++){
            if (curChars[i] == '(')
                num++;
            if (curChars[i] == ')')
                num--;
            if (num < 0)
                return false;
        }
        if (isLast) {
            return num == 0;
        }
        return true;
    }

    // 第三种方法，回溯法，
    // 如果左括号数量不大于 nn，我们可以放一个左括号。
    // 如果右括号数量小于左括号的数量，我们可以放一个右括号。
    public List<String> generateParenthesis_2(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll_1(new StringBuilder(), 0, 0,n,combinations);
        return combinations;
    }
    private void generateAll_1(StringBuilder cur, int curLeft, int curRight, int max, List<String> combinations){
        if (cur.length() == max * 2){
            combinations.add(cur.toString());
            return;
        }
        if (curLeft < max){
            cur.append('(');
            generateAll_1(cur, curLeft+1, curRight, max, combinations);
            cur.deleteCharAt(cur.length()-1);
        }
        if (curRight < curLeft){
            cur.append(')');
            generateAll_1(cur, curLeft, curRight+1, max, combinations);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(2));
    }
}
