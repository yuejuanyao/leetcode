package practice1;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int tmp = n % 26;
            //注意当出现余数为0，及能够被整除时，如26此时应该是26，而不应该是0
            if(tmp == 0){
                tmp = 26;
                n -= 1;
            }
            result.insert(0, (char)('A' + tmp - 1));
            n /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
