package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class q072_2 {
	
	static int H,W;
	static boolean[][] path,used;
	static ArrayDeque<Integer> que;
	static int[] xDif = {-1,0,1,0};
	static int[] yDif = {0,-1,0,1};
	static int ans;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		path = new boolean[H][W];
		for(int i=0;i<H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j = 0;j<W;j++) {
				path[i][j] = arr[j] =='.';
			}
		}
		reader.close();
	}
	
	public static int slove() throws  IOException {
		ans = -1;
//		que = new ArrayDeque<Integer>();
		for(int i=0;i<H;i++) {
			for(int j = 0;j<W;j++) {
				if(!path[i][j]) {
					continue;
				}
				used = new boolean[H][W];
				dfs(i*W+j ,i*W+j,0);
			}
		}
		return ans;
	}
	
	static void dfs(int startPoint,int currentPoint, int loopCnt) {
		int x = currentPoint % W;
		int y = currentPoint /W;
		used[y][x] = true;
		for(int i=0;i<4;i++) {
			int nextX = x+xDif[i];
			int nextY = y+yDif[i];
			int nextPoint = nextY*W + nextX ;
			//グリッドの範囲外or行けないマス
			if(nextX == -1 || nextX == W || nextY == H || nextY == -1 ||! path[nextY][nextX]) {
				continue;
			}
			//スタート地点に戻ってきた時にループの更新
			if(nextPoint == startPoint && loopCnt>= 3) {
				ans = Math.max(loopCnt+1, ans);
			}
			//そうじゃない場合は先に進む
			else if ( ! used[nextY][nextX]) {
				used[nextY][nextX] = true;
				dfs(startPoint,nextPoint,loopCnt+1);
				used[nextY][nextX] = false;
			}
		}
	}
}
