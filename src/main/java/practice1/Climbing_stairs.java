package practice1;

public class Climbing_stairs {

	static int count = 0;

	public void climbStairs() {
		//暴力解决法
		 System.out.println(climb(0, 50));
	}
	
	private long climb(int i, int n) {
		if(i>n) {
			return 0;
		}
		if(i==n) {
			count ++;
			return 1;
		}
		return climb(i+1, n)+climb(i+2, n);
	}

	public void climbStrirs1() {
		//再暴力解决法的基础上加上用数组作为记忆
		int n = 100;
		long memo[] = new long[n+1];
		System.out.println(climb1(0,n,memo));
	}
	
	private long climb1(int i, int n, long memo[]) {
		if(i > n) {
			return 0;
		}
		if(i == n) {
			return 1;
		}
		if(memo[i]>0) {
			return memo[i];
		}
		memo[i] = climb1(i+1, n, memo)+climb1(i+2, n, memo);
		return memo[i];
	}

	public void climbStart2() {
		//利用n是i-1和i-2的种类的和
		int n=10;
		if(n==1) {
			System.out.println(1);
		}
		long memo[] = new long[n+1];
		memo[1] = 1;
		memo[2] = 2;
		for(int i=3; i<=n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		System.out.println(memo[n]);
	}

	public void climbStart3() {
		int n = 100;
		if(n == 1) {
			System.out.println(1);
		}
		long first = 1;
		long second = 2;
		long third;
		for(int i=3; i<=n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		System.out.println(second);
	}

	public void climbStart4() {
		int n = 8;
		double sqrt_5 = Math.sqrt(5);
		double result = 0;
		
		result = Math.pow(((1+sqrt_5)/2),n+1)-Math.pow(((1-sqrt_5)/2),n+1);
		System.out.println((int)(result/sqrt_5));
	}
	
}
