package zbf.chapter01;
/**
 * �ݹ�
 * @author zhaobaofeng
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		//System.out.println(f1(3));
		printOut2(76234);
	}
	    
	
	/**
	 * f(0)=0 , �� f(x)=2f(x-1)+x^2
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
	 * �����ֵ�ÿ��������������
	 * @param n
	 */
	private static void printOut1(int n){
		if(n>=10){
			printOut1(n/10);
		}
		System.out.print(n%10);
	}
	/**
	 * �����������
	 * @param n
	 */
	private static void printOut2(int n){
		if(n>0){
			System.out.println(n%10);
			printOut2(n/10);
		}
	}
}
