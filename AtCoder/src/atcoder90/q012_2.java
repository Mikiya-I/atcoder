package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q012_2 {

	static int H,W,Q;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	static List<HashSet<Integer>> path;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		Q = Integer.parseInt(reader.readLine());
//		reader.close();
	}

	static String slove() throws IOException {
		//座標用(↑、←、↓、→)
		int[] d1 = {-1,0,1,0};
		int[] d2 = {0,-1,0,1};
		StringBuilder sb = new StringBuilder();
		int size = H*W;
		boolean[] isRed = new boolean[size+1];
		UnionFind uf = new UnionFind(size);
		for(int i=0;i<Q;i++) {
			String[] strs = reader.readLine().split(" ");
			if(strs.length == 3) {
				int row = Integer.parseInt(strs[1]);
				int column = Integer.parseInt(strs[2]);
				int baseNode = (row -1 )*W + column;
				isRed[baseNode] = true;
				for(int j=0;j<4;j++) {
					int tmpNode = baseNode + d1[j]*W + d2[j];
					if(1<= tmpNode  && tmpNode <= size &&  isRed[tmpNode] ) {
						uf.unite(baseNode, tmpNode);
					}
				}
			}else {
				int row = Integer.parseInt(strs[1]);
				int column = Integer.parseInt(strs[2]);
				int baseNode = (row -1 )*W + column;
				int row2 = Integer.parseInt(strs[3]);
				int column2 = Integer.parseInt(strs[4]);
				int baseNode2 = (row2 -1 )*W + column2;
				if(uf.same(baseNode, baseNode2)) {
					sb.append("Yes \n");
				}else {
					sb.append("No \n");
				}
			}
				
		}
		
		return sb.toString();
	}
}

class UnionFind {
	//親要素を保持する配列
    int[] parents;
    int[] rank;
    int[] size;
    
    public UnionFind(int n) {
        this.parents = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];
        //初期値は自身が根&サイズ(繋がっている要素の数)とランク(木の高さ)は1
        for(int i=0;i<=n;i++){
            parents[i] = i;
            rank[i] =1;
            size[i] = 1;
        }
    }

    //要素の根を求める
    public int root(int x){
       while(parents[x] != x)
    	   x = parents[x];
       return x;
    }

    //xとyの木を結合
    boolean unite(int x, int y) {
    	int rootX = root(x);
    	int rootY = root(y);
    	//そもそも同じ木だったら何もしない
    	if(rootX == rootY )
    		return false;
    	//結合(ランクが大きい方に小さい方を繋げる)
    	if(rank[rootX] > rank[rootY]) {
    		parents[rootY] = rootX;
    		size [rootX] += size[rootY];
    	}else {
    		if (rank[rootX] == rank[rootY])
    			rank[rootY]++;
			parents[rootX] = rootY;
			size[rootY] += size[rootX];
    	}
    	return true;
    }

    //要素x,yが同じグループに属するかどうかの判定
    boolean  same(int x ,int y) {
    	int rootX = root(x);
    	int rootY = root(y);
    	return rootX == rootY;
    }

    //サイズの取得
    int getSize(int x) {
    	return size[parents[x]];
    }
	
}