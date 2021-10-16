package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int h = Integer.parseInt(strs[0]);
		int w = Integer.parseInt(strs[1]);
		int[][] costGrid = new int[h][w];
		//エッジ
		Map<Integer, Set<Integer>> path = new HashMap<Integer, Set<Integer>>();
		//コスト計算
		for(int i=0;i<h;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<w;j++) {
				costGrid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		//パス変換
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				HashSet<Integer> nodes =new HashSet<Integer>();
				int tmpNode = w*i+j;
				//四方のマス
				int right= tmpNode+1;
				int left = tmpNode-1;
				int up = tmpNode-w;
				int down = tmpNode+w;
				if(right%w != 0)
					nodes.add(right);
				if(left > -1 && left != w-1)
					nodes.add(left);
				if(up >=0)
					nodes.add(up);
				if(down/w < h)
					nodes.add(down);
				path.put(w*i+j, nodes);
			}
		}
		
		Dijkstra dj = new Dijkstra(null, 0, h*w-1,h*w);
		dj.setCost(costGrid);
		dj.path= path;
		
		dj.calcMinCost();
		System.out.println(dj.minCost[h*w-1]);
	}
}
