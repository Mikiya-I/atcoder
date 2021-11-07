package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q072 {
	static int W;
	static int H;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] used;
	static int ans = -1;
	static boolean[][] grid;
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		grid = new boolean[H][W];
		used = new boolean[H][W];
		for(int i=0;i<H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=0;j<W;j++) {
				grid[i][j] = arr[j]=='.';
			}
		}
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(!grid[i][j])
					continue;
				int start = i*W+j;
				used[i][j] = true;
				dfs(start,start,0);
				used[i][j] = false;
			}
		}
		
		return ans;
	}
	
	static void dfs (int start,int current,int cnt) {
		int currentW = current%W;
		int currentH = current/W;
		for (int i = 0; i < 4; i++) {
			int nextW = currentW + dx[i];
			int nextH = currentH + dy[i];
			if (0 <= nextH && nextH < H && 0 <= nextW && nextW < W && grid[nextH][nextW]) {
				int next = nextW + nextH*W;
				//使用済み場合
				if(used[nextH][nextW]) {
					//ゴール地点の更新
					if(next == start && cnt >=3) {
						ans = Math.max(ans, cnt+1);
					}
				}else {
					used[nextH][nextW] = true;
					dfs(start,next,cnt+1);
					used[nextH][nextW] = false;
				}
			}
			
		}
	}
}
