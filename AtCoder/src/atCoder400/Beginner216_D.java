package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Beginner216_D {
	static List<ArrayDeque<Integer>> list;
	static HashMap<Integer, Integer> findBall;
	static ArrayDeque<Integer> removeFrom;
	//その番号のボールが何個見つかっているか
	static int[]findBalls;
	static int removeCnt;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//		slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		//		findBalls = new int[N+1][2];
		list = new ArrayList<ArrayDeque<Integer>>();
		findBalls = new int[N+1];
		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(reader.readLine());
			strs = reader.readLine().split(" ");
			ArrayDeque<Integer> que = new ArrayDeque<Integer>();
			for (int j = 0; j < k; j++) {
				que.add(Integer.parseInt(strs[j]));
			}
			list.add(que);
			findBalls[que.peek()]++;
		}

		findBall = new HashMap<Integer, Integer>();
		removeFrom = new ArrayDeque<Integer>();
		removeCnt = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i).size() != 0) {
				int tmp = list.get(i).peek();
				if (findBall.containsKey(tmp)) {
					removeFrom.add(i);
				} else {
					findBall.put(tmp, i);
				}
			}
		}
		while (removeFrom.size() > 0) {
			int i = removeFrom.pop();
			removeCnt++;
			//i番目の筒からボールを捨てる
			int tmp = list.get(i).pop();
			//i番目の筒にボールが残っていた場合
			if (list.get(i).size() > 0) {
				int new1 = list.get(i).peek();
				if (findBall.containsKey(new1)) {
					removeFrom.add(i);
				} else {
					findBall.put(new1, i);
				}
			}
			//元々あった方から捨てる
			int idx = findBall.get(tmp);
			list.get(idx).pop();
			//idx番目の筒にボールが残っていた場合
			if (list.get(idx).size() > 0) {
				int new2 = list.get(idx).peek();
				if (findBall.containsKey(new2)) {
					removeFrom.add(idx);
				} else {
					findBall.put(new2, idx);
				}
			}
		}

		if (removeCnt == N) {
			return "Yes";
		} else {
			return "No";
		}
	}
}
//	//ボールが既に存在していた場合の処理
//	private static void operateBall(int i) {
//		removeCnt++;
//		//i番目の筒からボールを捨てる
//		int tmp = list.get(i).pop();
//		//i番目の筒にボールが残っていた場合
//		if (list.get(i).size() > 0) {
//			int new1 = list.get(i).peek();
//			if (findBall.containsKey(new1)) {
//				removeFrom.add(i);
//			} else {
//				findBall.put(new1, i);
//			}
//		}
//		//元々あった方から捨てる
//		int idx = findBall.get(tmp);
//		list.get(idx).pop();
//		//idx番目の筒にボールが残っていた場合
//		if (list.get(idx).size() > 0) {
//			int new2 = list.get(idx).peek();
//			if (findBall.containsKey(new2)) {
//				removeFrom.add(idx);
//			} else {
//				findBall.put(new2, idx);
//			}
//		}
//	}
//}