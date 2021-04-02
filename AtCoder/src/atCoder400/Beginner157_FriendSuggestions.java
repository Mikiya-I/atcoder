package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner157_FriendSuggestions {

	public static void main(String[] args) throws IOException {
		slove();

	}

	static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		final int K = Integer.parseInt(strs[2]);

		UnionFindTree uf = new UnionFindTree(N);
		int relation[] = new int[N + 1];
		//要素+要素+1を友人関係に
		for (int i = 0; i < M; i++) {
			String str[] = reader.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			uf.unite(a, b);
			relation[a]++;
			relation[b]++;
		}

		//ブロック関係
		for (int i = 0; i < K; i++) {
			String str[] = reader.readLine().split(" ");
			int c = Integer.parseInt(str[0]);
			int d = Integer.parseInt(str[1]);
			if(uf.same(c, d)){
				relation[c]++;
				relation[d]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++)
			sb.append(uf.getSize(i)-relation[i]-1+" ");

		System.out.println(sb.toString());
	}
}

class UnionFindTree {
	int[] root;
	int[] rank;
	int[] size;

	public UnionFindTree(int n) {
		this.root = new int[n + 1];
		this.rank = new int[n + 1];
		this.size = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			root[i] = i;
			size[i] = 1;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		while (root[x] != x) {
			x = root[x];
		}
		return x;
	}

	//要素xの木と要素yの木の結合
	public boolean unite(int x, int y) {
		//xとyの根を取得
		int rootX = find(x);
		int rootY = find(y);
		//そもそも同じ木だったら何もしない
		if (rootX == rootY)
			return false;

		//ランクが低い方を高い方に繋げる
		if (rank[rootX] > rank[rootY]) {
			root[rootY] = rootX;
			size[rootX] += size[rootY];
		} else {
			if (rank[rootX] == rank[rootY])
				rank[rootY]++;
			root[rootX] = rootY;
			size[rootY] += size[rootX];
		}
		return true;
	}

	//要素xのサイズ=根のサイズ
	int getSize(int x) {
		return size[root[x]];
	}

	boolean same(int x,int y) {
		return find(x) == find(y);
	}
}