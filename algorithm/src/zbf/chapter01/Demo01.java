package zbf.chapter01;

import java.util.Arrays;

/**
 * 一组N个数要确定其中第k个最大者
 * @author zhaobaofeng
 *
 */
public class Demo01 {
	static int[] N = {1,7,9,5,6,11,85,33,4};
	/**
	 * 将N个数放进一个数组，冒泡排序,取第k个值
	 * @param k
	 * @return
	 */
	static int method1(int k){
		N = bubbleSort(N);
		return N[k-1];
	}
	/**
	 * 先取N中前k个元素放在一个数组n中，在对n冒泡排序,再遍历N中剩下的元素，
	 * 和n中最小的对比，若大于n中最小元素，则将其替换并对n重新排序，直至最后一个元素
	 * @param k
	 * @return
	 */
	static int method2(int k){
		int[] n = new int[k];
		System.arraycopy(N, 0, n, 0, k);
		n = bubbleSort(n);
		for(int i = k; i<N.length; i++){
			if(n[k-1]<N[i]){
				n[k-1] = N[i];
				n = bubbleSort(n);
			}
		}
		return n[k-1];
	}
	 
	 public static void main(String[] args) {
		//int a = method1(3);
		 int a = method2(3);
		System.out.println(a);
		//System.out.println(Arrays.toString(bubbleSort(N)));
	}
	 /**
	  * 排序算法
	  * @param N
	  * @return
	  */
	 public static int[] bubbleSort(int[] N){
		 for(int i = 0; i<N.length; i++){
			 for(int j = 0; j<N.length-1-i; j++){
				 int tmp = N[j];
				if( N[j] < N[j+1]){
					N[j] = N[j+1];
					N[j+1] = tmp;
				}
			 }
		 }
		 return N;
	 }
	
}
