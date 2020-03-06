package practice1;

public class Valid_palindrome_125 {
	
    public static boolean isPalindrome(String s) {
    	boolean res = true;
    	
        if(s == null || s.length()<=0)
        	return res;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(true && start<=end) {
        	char a = s.charAt(start);
        	char b = s.charAt(end);
        	if(('0'<=a && a<='9') || ('a'<=a && a<='z')) {
        		if(('0'<=b && b<='9') || ('a'<=b && b<='z')) {
        			if(s.charAt(start) != s.charAt(end)) {
                		res = false;
                		break;
                	}
            		start ++;
            		end --;
        		}else {
        			end--;
        		}
        		
        	}else {
        		start++;
        	}
        }
        return res;
    }
    
    public boolean isPalindrome_1(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
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
