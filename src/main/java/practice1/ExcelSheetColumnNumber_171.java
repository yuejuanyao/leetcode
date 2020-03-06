package practice1;

public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String s) {
        int sum = 0;
        for(int i=0; i< s.length();i++){
            int num = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
