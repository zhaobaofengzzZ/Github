package zbf.chapter01;

import java.util.Arrays;

/**
 * ������Ϸ
 * ��������һЩ��ĸ���ɵĶ�ά����   �Լ�һ�鵥�����
 * 
 * @author zhaobaofeng
 *
 */
public class Demo04_Logogriph {
	private static String[] words = {"this", "two", "fat", "that"};
	private static char[][] chars = new char[4][];
	
	static{
		chars[0] = "this".toCharArray();
		chars[1] = "wats".toCharArray();
		chars[2] = "oahg".toCharArray();
		chars[3] = "fgdt".toCharArray();
	}
	
	public static void main(String[] args) {
		printChars(chars);
		//System.out.println(chars[2][3]);
		
		findWords(chars);
	}
	
	/**
	 * ��ӡ��ά����
	 * @param chars
	 */
	private static void printChars(char[][] chars){
		System.out.println("--------------------------------------------");
		for(int i =0; i<chars.length; i++){
			System.out.print("\t"+(i+1));
		}
		System.out.println();
		for(int i = 0; i<chars.length; i++){
			System.out.print(i+1);
			for(int j = 0; j <chars.length; j++){
				System.out.print("\t"+chars[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------");
	}
	/**
	 * �ж������д�chars[i][j] ��chars[m][n]�������ϵ���ĸ��ϳɵ��ַ��� word �ǲ������󵥴����� words�еĵ���
	 * @param word
	 * @param i
	 * @param j
	 * @param m
	 * @param n
	 */
	private static void printWords(String word, int i, int j, int m, int n){
		for(int k = 0; k <words.length; k++){
			if(word.equals(words[k])){
				System.out.println("find word:"+word);
				System.out.println("scalar:"+ "[" + (i+1) + "," + (j+1) + "]->[" + (m+1) + "," + (n+1) + "]");
			}
		}
	}
	/**
	 * ���ձ���(i, j)---->(m, n)����Ѱ�������������ַ���
	 * @param chars
	 */
	private static void findWords(char[][] chars){
		long startTime = System.currentTimeMillis();
		 for (int i = 0; i < chars.length; i++) {
	            for (int j = 0; j < chars.length; j++) {
	                for (int m = 0; m < chars.length; m++) {
	                    for (int n = 0; n < chars.length; n++) {
						//������ĸ
						if(i==m&&j==n){ 
							printWords(chars[i][j]+"",i,j,m,n);
							continue;
						}
						//�Ǳ���������ֱ��
						if(i!=m && j!=n && (m-i)!=(n-j) && (m-i)!=(j-n)){
							continue;
						}
						StringBuffer sb = new StringBuffer();
						//ͬһ��
						if(i==m){
							if(j<n){  //��������
								for(int k = j; k <= n; k++)
									sb.append(chars[i][k]);
							}else{  //��������
								for(int k = j; k>=n; k--)
									sb.append(chars[i][k]);
							}
						}
						//ͬһ��
						if(j==n){
							if(i<m){  //���ϵ���
								for(int k = i; k<=m; k++)
									sb.append(chars[k][j]);
							}else{	//���µ���    
								for(int k = i; k>=m; k--)
									sb.append(chars[k][j]);
							}
						}
						//�����ϵ�����
						if((m-i) == (n-j)){
							if(m>i){		//�����ϵ�����
								for(int k=i,l=j; k<=m&&l<=n; k++,l++)
									sb.append(chars[k][l]);
							}else{			//���µ�����
								for(int k=i,l=j; k>=m&&l>=n; k--,l--)
									sb.append(chars[k][l]);
							}
						}
						//���µ�����
						if((m-i)==(j-n)){
							if(i>m){   //���µ�����
								for(int k=i,l=j; k>=m&&l<=n; k--,l++)
									sb.append(chars[k][l]);
							}else{		//���ϵ�����
								for(int k=i,l=j; k<=m&&l>=n; k++,l--)
									sb.append(chars[k][l]);
							}
						}
						printWords(sb.toString(),i,j,m,n);
					}
				}
			}
		}
		System.out.println("----------------------");
		System.out.println("runTime:"+(System.currentTimeMillis() - startTime)+"ms");
	}
	
}
