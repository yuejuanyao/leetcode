package string;

public class Valid_palindrome_125 {
	
    public static boolean isPalindrome(String s) {
        if(s == null || s.length()<=0)
        	return true;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<=end) {
        	char a = s.charAt(start);
        	char b = s.charAt(end);
        	if (!Character.isLetterOrDigit(a)){
        		start++;
        		continue;
			}
			if (!Character.isLetterOrDigit(b)){
				end--;
				continue;
			}
			if (a != b)
				return false;
			start ++;
			end --;
        }
        return true;
    }
    
    public boolean isPalindrome_1(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){//注意i j 范围
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;

    }
	public static void main(String[] args) {
		//"A man, a plan, a canal: Panama"
		//"race a car"
		//"a"
		//""
		String test = "a b ";
		System.out.println(isPalindrome(test));
		System.out.println('a'<='a' && 'a'<='z');
	}

}
