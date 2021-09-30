package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class q012 {
//	static ArrayList<ArrayList<Integer>> path;
	static boolean[] used;
	static ArrayDeque<Integer> que;
	static int H;
	static int W;
	static boolean[][] grid;
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
	
		grid = new boolean[H+2][W+2];
		used = new boolean[ (H+2) * (W+2)  ];
		que = new ArrayDeque<Integer>();
		unionFind uf = new  unionFind((H+2) * (W+2)  );
		
		final int Q = Integer.parseInt(reader.readLine());  
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int[] query = new int[strs.length];
			for(int j=0;j<strs.length;j++) {
				query[j] = Integer.parseInt(strs[j]);
			}
			if(query.length==3) {
				int h = query[1],w = query[2];
				grid[h][w]= true;
				int pos = h*(W+2)+w;
				//上下左右のマスが塗られていれば結合
				if(grid[h-1][w]) {
					uf.unite(pos,pos-W-2 );
				}
				if(grid[h+1][w]) {
					uf.unite(pos,pos+W+2 );
				}
				if(grid[h][w-1]) {
					uf.unite(pos,pos-1);
				}
				if(grid[h][w+1]) {
					uf.unite(pos,pos+1 );
				}
					
			}else {
				if(!grid[query[1]][query[2]] || ! grid[query[3]][query[4]]) {
					sb.append("No");
				}else {
					int h1 = query[1],w1 = query[2];
					int h2 = query[3],w2 = query[4];
					int a = h1*(W+2)+w1;
					int b = h2*(W+2)+w2;
					if(uf.same(a, b)) {
						sb.append("Yes");
					}else {
						sb.append("No");
					}
			}
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	
		static class unionFind{
		//親要素を保持する配列
	    int[] parent;
	    int[] rank;
	    int[] size;
		public unionFind(int n) {
			parent = new int[n+1];
			this.rank = new int[n+1];
	        this.size = new int[n+1];
	        //初期値は自身が根、サイズ(繋がっている要素の数)とランク(木の高さ)は1
	        for(int i=0;i<=n;i++){
	            parent[i] = i;
	            rank[i] =1;
	            size[i] = 1;
	        }
		}
		
		int findRoot(int n) {
			if(parent[n] != n) 
				return findRoot(parent[n]);
			else {
				return n;
			}
		}
		
		boolean unite(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			
			//そもそも同じ木だったら何もしない
	    	if(rootX == rootY )
	    		return false;
	    	
	    	//結合(ランクが大きい方に小さい方を繋げる)
	    	if(rank[rootX] > rank[rootY]) {
	    		parent[rootY] = rootX;
	    		size [rootX] += size[rootY];
	    	}else {
	    		if (rank[rootX] == rank[rootY])
	    			rank[rootY]++;
				parent[rootX] = rootY;
				size[rootY] += size[rootX];
	    	}
	    	return true;
	    }
		
		//要素x,yが同じグループに属するかどうかの判定
	    boolean  same(int x ,int y) {
	    	int rootX = findRoot(x);
	    	int rootY = findRoot(y);
	    	return rootX == rootY;
	    }

	    //サイズの取得
	    int getSize(int x) {
	    	return size[parent[x]];
	    }
	}
}


