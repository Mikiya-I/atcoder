package algorithm;

public class Warshall_FloydSample {
	//各地点間の距離
	int[][] dist;

	//初期化で各地点間の距離を保持
	public Warshall_FloydSample(int[][] map) {
		//入力方法による
	}

	void warshall_Floyd() {
		for (int k = 0; k < dist.length; k++) { // 経由する頂点
			for (int i = 0; i < dist.length; i++) { // 始点
				for (int j = 0; j < dist.length; j++) { // 終点
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}

}
