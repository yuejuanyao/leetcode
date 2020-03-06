package practice1;


public class _58 {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
	}
	
	
    public static int lengthOfLastWord(String s) {
    	String s_t = s.trim();
    	if(s.isEmpty() || s_t.isEmpty()) {
    		return 0;
    	}
    	//char[] s1 = s_t.toCharArray();
    	
        int count = 0;
        for (int i = s_t.length()-1; i>=0; i--) {
        	char l = s_t.charAt(i);
        	if(l == ' ') {
        		break;
        	}
        	count++;
        	System.out.println(count);
        }
        return count;
        
        
    }

}
