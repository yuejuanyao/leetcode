package practice1;
import java.lang.Integer;

public class _66 {

	public static void main(String[] args) {
		
		int[] digits = {9,8,7,6,5,4,3,2,1,0};
		
		doit.plusOne(digits);
	}
}

class doit {
	
    public static int[] plusOne(int[] digits) {
    	
    	StringBuffer sf = new StringBuffer() ;
    	for(int j=0; j<digits.length;j++) {
    		sf.append(String.valueOf(digits[j]));
    	}
    	System.out.println(sf);
    	Integer a = Integer.parseInt("876543210");
    	//Integer a = Integer.parseInt(sf.toString());
        a += 1;
        System.out.println(a);
        String b = a.toString();
        int[] res = new int[b.length()];
        for(int i=0; i<b.length(); i++) {
        	res[i] = Integer.parseInt(String.valueOf(b.charAt(i)));	
        	System.out.println(res[i]);
        }
        return res;
    }
}