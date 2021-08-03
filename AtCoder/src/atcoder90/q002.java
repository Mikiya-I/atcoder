package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q002 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(reader.readLine());
		PriorityQueue<String> ans = new PriorityQueue<String>();
//		List<String> ans = new ArrayList<String>();
		reader.close();
		if(N%2 == 1) {
			return "";
		}
		
	    //ループ回数
	    int loop = 1<<N;
	    //全てのケース
	    for(int i = 0;i<loop;i++) {
	    	char[] c = new char[N];
	    	int rightCnt=0;
	    	//桁分の繰り返し
	    	for(int j=0;j<N;j++) {
	    		//ビットが立っている場所を特定
	    		if(((i>>j) & 1)==1)  {
	    			rightCnt++;
	    			c[j]=')';
	    		}else {
	    			c[j]='(';
	    		}
	    	}
	    	if(rightCnt != N/2){
	    		continue;
	    	}
	    	int leftCnt =0;
	    	for(char ch:c) {
	    		if(ch =='(') {
	    			leftCnt++;
	    		}else {
	    			if(leftCnt == 0) {
	    				leftCnt --;
	    				break;
	    			}else {
	    				leftCnt--;
	    			}
	    		}
	    	}
	    	if(leftCnt == 0) {
	    		ans.add(new String(c));
	    	}
	    }
//	    Collections.sort(ans);
		while(ans.size()>0) {
			sb.append(ans.poll());
			sb.append("\n");
		}
//	    for(String s: ans) {
//	    	sb.append(s);
//    		sb.append("\n");
//	    }
		return sb.toString();
	}
	
//	public static boolean judge(int[] arr) {
//		for(int i=0;i<arr.length;i++) {
//			
//		}
//	}
}
