import java.util.Arrays;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MatrixC {

	private int[][] data;
	private int m; //矩阵的第一维长度
	private int n; //矩阵的第二维长度
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MatrixC(int[][] a){
		this.data = a;
		m=a.length;
		n=a[0].length;
	}

	/**
	 * 返回2维int矩阵
	 * @return int[][]
	 */
	public int[][] getArray(){
		return data;
	}

	/**
	 * 返回矩阵的第一维长度
	 * @return int
	 */
	public int getM(){
		return m;
	}

	/**
	 * 返回矩阵的第二维长度
	 * @return
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MatrixC plus(MatrixC B){
		int[][] b=new int[m][n];
		int[][] result=new int[m][n];
		b=B.getArray();
		if(m==B.getM()&&n==B.getN()){
			for(int i=0;i<m;i++){
				for (int j = 0; j < n; j++) {
					result[i][j]=data[i][j]+b[i][j];
				}
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
		
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MatrixC times(MatrixC B){
		int[][] b=new int[B.getM()][B.getN()];
		int[][] result=new int[m][B.getN()];
		if(n==B.getM()){
			b=B.getArray();
			for (int i = 0; i <m ; i++) {
				for (int j = 0; j < B.getN(); j++) {
					for (int a = 0; a < n; a++) {
						result[i][j]=result[i][j]+data[i][a]*b[a][j];
					}
					
				}
				
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MatrixC times(int b){
		int[][] result=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j]=b*data[i][j];
			}
			
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MatrixC transpose(){
		int[][] result=new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[j][i]=data[i][j];
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MatrixC plusFromConsole(){
		Scanner scanner=new Scanner(System.in);
		int m1=scanner.nextInt();
		int n1=scanner.nextInt();
		int[][] temp=new int[m1][n1];
		int[][] result=new int[m][n];
		if(m==m1&&n==n1){
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j]=scanner.nextInt();
					result[i][j]=temp[i][j]+data[i][j];
				}
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MatrixC timesFromConsole(){
		Scanner scanner=new Scanner(System.in);
		int m1=scanner.nextInt();
		int n1=scanner.nextInt();
		int[][] temp=new int[m1][n1];
		int[][] result=new int[m][n];
		for (int i = 0; i < m1; i++) {
			for (int j = 0; j < n1; j++) {
				temp[i][j]=scanner.nextInt();
				}
			}
		if(n==m1){
			for (int i = 0; i <m ; i++) {
				for (int j = 0; j < n1; j++) {
					for (int a = 0; a < n; a++) {
						result[i][j]=result[i][j]+data[i][a]*temp[a][j];
					}
					
				}
				
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.println("");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n-1; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println(data[i][n-1]);
		}
		System.out.println("");
		
	}
	
	/**
	 * 判断是否相等的方法，考生不要修改！！
	 */
	public boolean equals(Object obj){
		
		if(obj instanceof MatrixC){
			MatrixC matrix = (MatrixC) obj;
			
			if(this.data.length != matrix.data.length){
				return false;
			}
			
			for(int i=0 ; i<this.data.length ; ++i){
				if(!Arrays.equals(this.data[i], matrix.data[i])){
					return false;
				}
			}
			
			return true;
			
		}else{
			return false;
		}
	}
	
}
