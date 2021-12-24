package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q046_2 {
	
	static int N;
	static int Q;
	static int[] arr;
	static int[] command;
	static int[] xArr;
	static int[] yArr;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
//		 slove();
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		Q = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		command = new int[Q];
		xArr = new int[Q];
		yArr = new int[Q];
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			command[i] = Integer.parseInt(strs[0]);
			xArr[i] = Integer.parseInt(strs[1])-1;
			yArr[i] = Integer.parseInt(strs[2])-1;
		}
		reader.close();
	}

	static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		int shiftCnt = 0;
		for(int i=0;i<Q;i++) {
			switch (command[i]) {
				case 1:
					int x = xArr[i] - shiftCnt;
					if(x<0) {
						x*= -1;
						x %= N;
						x = N-x;
					}else if (N <= x) {
						x %= N;
					}
					int y =  yArr[i] - shiftCnt;
					if(y<0) {
						y*= -1;
						y %= N;
						y = N-y;
					}else if ( N <= y) {
						y %= N;
					}
					int tmp = arr[x];
					int tmp2 = arr[y];
					arr[x] = arr[y];
					arr[y] = tmp;
					break;
				case 2:
					shiftCnt++;
					shiftCnt%= N;
					break;
				case 3:
					int idx = xArr[i] -shiftCnt;
					if(N <= idx) {
						idx %= N;
					}else if(idx<0) {
						idx*= -1;
						idx %= N;
						idx = N-idx;
					}
					sb.append(arr[idx] + "\n");
					break;
			}
		}
		
		return sb.toString();
	}
}