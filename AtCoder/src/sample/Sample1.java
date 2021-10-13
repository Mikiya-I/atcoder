package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sample1 {
	//地点間の距離
		static int distance[][];
		//地点
		static int nextPoint;
		static int startPoint;
		static int goalPoint;
		//出発地点から目的地までの最短経路の経由順
		static int[] minRoute;
		//出発地点から目的地までの最短距離
		static int minDistance;
		//出発地点から各地点までの最短距離
		static int[] minDistances;
		//その地点への最短経路が確定されているか
		static boolean[] fixed;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = 6;
		HashMap<Integer,Set<Integer>> path = new HashMap<Integer, Set<Integer>>();
		for(int i=0;i<N;i++) {
			path.put( i, new HashSet<Integer>());
		}
		distance = new int[N][N];
		for(int i=0;i<N;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				if(arr[j]!='-')
					path.get(i).add(j);
					distance[i][j] = arr[j]-48;
					distance[j][i] = arr[j]-48;
			}
		}
		distance[0][0] = 0;
		startPoint = 0;
		nextPoint = 0;
		while(fixed[N-1]) {
			fixed[nextPoint]=true;
			
		}
		
		
	}

}

//ノード
class Node implements Comparable<Node> {

    int tyoten;
    long minDistance;

    public Node(int t, long m) {
        tyoten = t;
        minDistance = m;
    }

    @Override
    public int compareTo(Node o) {
        int res = -1;
        if (this.minDistance - o.minDistance >= 0) {
            res = 1;
        }
        return res;
    }
}