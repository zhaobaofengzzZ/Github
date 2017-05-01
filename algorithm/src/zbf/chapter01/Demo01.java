package zbf.chapter01;

import java.util.Arrays;

/**
 * һ��N����Ҫȷ�����е�k�������
 * @author zhaobaofeng
 *
 */
public class Demo01 {
	static int[] N = {1,7,9,5,6,11,85,33,4};
	/**
	 * ��N�����Ž�һ�����飬ð������,ȡ��k��ֵ
	 * @param k
	 * @return
	 */
	static int method1(int k){
		N = bubbleSort(N);
		return N[k-1];
	}
	/**
	 * ��ȡN��ǰk��Ԫ�ط���һ������n�У��ڶ�nð������,�ٱ���N��ʣ�µ�Ԫ�أ�
	 * ��n����С�ĶԱȣ�������n����СԪ�أ������滻����n��������ֱ�����һ��Ԫ��
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
	  * �����㷨
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
