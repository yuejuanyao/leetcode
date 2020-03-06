package practice1;

public class add_binary {
	
	public static String add(String a, String b) {
		StringBuffer result = new StringBuffer();;
		int add = 0;
		int push = 0;
		if(a.length() <= b.length()) {
			String tmp = null;
			tmp = a;
			a = b;
			b = tmp;
		}
		a = new StringBuffer(a).reverse().toString();
		b = new StringBuffer(b).reverse().toString();
		
		for(int i=0; i<a.length(); i++) {
			if(i>b.length()-1) {
				add = a.charAt(i)-'0'+ push;
			}else {
				add = a.charAt(i)-'0' + b.charAt(i) - '0' + push;
			}
			if(add >=2) {
				add -= 2;
				push = 1;
			}else {
				push = 0;
			}
			result = result.append(add);
		}
		if(push == 1) {
			result = result.append(push);
		}
		
		return result.reverse().toString();
	}

	public static String add_another(String a, String b) {
		
		int push = 0;
		
		StringBuffer result = new StringBuffer();
		
		for(int i=a.length()-1,j=b.length()-1; i>=0 || j>=0; i--,j--) {
			System.out.println(i);
			System.out.println(j);
			int add = 0;
			add += i >= 0 ? a.charAt(i) - '0' : 0; 
			add += j >= 0 ? b.charAt(j) - '0' : 0;
			add += push;
			if(add >= 2) {
				add -= 2;
				push = 1;
			}else {
				push = 0;
			}
			result.append(add);
		}
		if(push == 1) {
			result.append(1);
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		String a = "1110";
		String b = "10110";
		
		String res = add(a,b);
		System.out.println(res);
		
		res = add_another(a, b);
		System.out.println(res);
	}

}
