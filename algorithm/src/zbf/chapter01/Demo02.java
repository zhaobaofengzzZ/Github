package zbf.chapter01;
/**
 * 递归
 * @author zhaobaofeng
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		//System.out.println(f1(3));
		printOut2(76234);
	}
	    
	
	/**
	 * f(0)=0 , 且 f(x)=2f(x-1)+x^2
	 * @param x
	 * @return
	 */
	private static int f1(int x){
		if( x==0 ){
			return 0;
		}
		return 2*f1(x-1) +x*x;
	}
	/**
	 * 将数字的每个数逐个正序输出
	 * @param n
	 */
	private static void printOut1(int n){
		if(n>=10){
			printOut1(n/10);
		}
		System.out.print(n%10);
	}
	/**
	 * 倒序输出数字
	 * @param n
	 */
	private static void printOut2(int n){
		if(n>0){
			System.out.println(n%10);
			printOut2(n/10);
		}
	}
}
