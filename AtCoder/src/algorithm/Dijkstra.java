package algorithm;

import java.util.Arrays;

public class Dijkstra {
	//地点間の距離
	int distance[][];
	//地点数
	int point;
	int startPoint;
	int goalPoint;
	//出発地点から目的地までの最短経路の経由順
	int[] minRoute;
	//出発地点から目的地までの最短距離
	int minDistance;
	//出発地点から各地点までの最短距離
	int[] minDistances;
	//その地点への最短経路が確定されているか
	boolean[] fixed;
	
	public Dijkstra(int[][] dist) {
		Arrays.fill(minRoute, -1);
		distance = dist;
		
	}
	
	int calcMinRoute(int start,int goal) {
		
		
		
		return minDistance;
	}
}
