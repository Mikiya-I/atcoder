package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beginner212_D {
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(reader.readLine());
		PriorityQueue<Long> que = new PriorityQueue<Long>();
		long offset = 0;

		for(int i=0;i<Q;i++) {
			String[] strs = reader.readLine().split(" ");
			if(strs.length == 2) {
				if(strs[0].equals("1")) {
					//追加した時点でのoffsetを引いておくことで大小を担保しておく
					que.add(Long.parseLong(strs[1])-offset);
				}else {
					offset+= Long.parseLong(strs[1]);
				}
			}else {
				sb.append(que.poll()+offset);
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
//	public static String slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int Q = Integer.parseInt(reader.readLine());
////		long[] events = new long[Q];
////		HashSet<Integer> removeBalls = new HashSet<Integer>() ;
//		ArrayList<Long> events = new ArrayList<>();
//		for(int i=0;i<Q;i++) {
//			String[] strs = reader.readLine().split(" ");
//			if(strs.length == 2) {
//				if(strs[0].equals("1")) {
////					events[i]= Long.parseLong(strs[1]);
//					events.add(Long.parseLong(strs[1]));
//				}else {
////					events[i] = Long.parseLong(strs[1]) * -1;
//					events.add(Long.parseLong(strs[1]) *-1);
//				}
//			}else {
//				long addTmp =0;
//				long minVal=Long.MAX_VALUE;
//				int removeBall=0;
////				for(int j=i;j>=0;j--) {
////					if(events[j] <= 0) {
////						addTmp+=events[j]*-1;
////					}else {
////						if(events[j]+addTmp < minVal && !removeBalls.contains(j)) {
////							minVal=events[j]+addTmp;
////							removeBall = j;
////						}
////					} 
////				}
//				for(int j=events.size()-1;j>=0;j--) {
//					if(events.get(j) <= 0) {
//						addTmp+=events.get(j)*-1;
//					}else {
//						if(events.get(j)+addTmp < minVal ) {
//							minVal=events.get(j)+addTmp;
//							removeBall = j;
//						}
//					} 
//				}
//				sb.append(minVal);
//				sb.append("\n");
////				removeBalls.add(removeBall);
//				events.remove(removeBall);
//			}
//		}
//		
//		return sb.toString();
//	}
}