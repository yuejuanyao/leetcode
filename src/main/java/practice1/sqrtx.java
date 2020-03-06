package practice1;

public class sqrtx {

	public static int sq_1(int x) {
		long mid;
		long i=0, j=x;
		if(x>=4) {
			j=x/2;
		}
		while ((i-j)<=0) {
			mid =(i + j) / 2;
			if ((mid * mid) > x) {
				j = mid - 1;
			} else if((mid * mid) < x) {
				i = mid + 1;
			}else {
				return (int)mid;
			}
		}
		return (int)j;
	}
	
	public static int sq_2(int x) {
		long res = 1;
		while(true) {
			
			res = (res + x/res)/2;
			if((res*res-x)<1e-10) {
				return (int)res;
			}
		}
		
	}
	
	public static int sq_3(int x) {
		long res = x;
		while(x<res*res) {	
			res = (res + x/res)/2;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		int a = sq_1(1000000007);
		int b = sq_2(1000000007);
		int c = sq_3(0);
		System.out.println(a + "," + b + "," +c);
	}

}
