package zbf.chapter01;

import java.util.Arrays;

/**
 * 字谜游戏
 * 输入是由一些字母构成的二维数组   以及一组单词组成
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
	 * 打印二维数组
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
	 * 判断数组中从chars[i][j] 到chars[m][n]的向量上的字母组合成的字符串 word 是不是所求单词数组 words中的单词
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
	 * 按照标量(i, j)---->(m, n)方向寻找满足条件的字符串
	 * @param chars
	 */
	private static void findWords(char[][] chars){
		long startTime = System.currentTimeMillis();
		 for (int i = 0; i < chars.length; i++) {
	            for (int j = 0; j < chars.length; j++) {
	                for (int m = 0; m < chars.length; m++) {
	                    for (int n = 0; n < chars.length; n++) {
						//单个字母
						if(i==m&&j==n){ 
							printWords(chars[i][j]+"",i,j,m,n);
							continue;
						}
						//非标量，不成直线
						if(i!=m && j!=n && (m-i)!=(n-j) && (m-i)!=(j-n)){
							continue;
						}
						StringBuffer sb = new StringBuffer();
						//同一行
						if(i==m){
							if(j<n){  //方向向右
								for(int k = j; k <= n; k++)
									sb.append(chars[i][k]);
							}else{  //方向向左
								for(int k = j; k>=n; k--)
									sb.append(chars[i][k]);
							}
						}
						//同一列
						if(j==n){
							if(i<m){  //从上到下
								for(int k = i; k<=m; k++)
									sb.append(chars[k][j]);
							}else{	//从下到上    
								for(int k = i; k>=m; k--)
									sb.append(chars[k][j]);
							}
						}
						//从左上到右下
						if((m-i) == (n-j)){
							if(m>i){		//从左上到右下
								for(int k=i,l=j; k<=m&&l<=n; k++,l++)
									sb.append(chars[k][l]);
							}else{			//右下到左上
								for(int k=i,l=j; k>=m&&l>=n; k--,l--)
									sb.append(chars[k][l]);
							}
						}
						//左下到右上
						if((m-i)==(j-n)){
							if(i>m){   //左下到右上
								for(int k=i,l=j; k>=m&&l<=n; k--,l++)
									sb.append(chars[k][l]);
							}else{		//右上到左下
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
