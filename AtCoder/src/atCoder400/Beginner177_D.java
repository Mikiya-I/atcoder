package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner177_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);

		UnionFind uf = new UnionFind(N);
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int A = Integer.parseInt(strs[0])-1;
			int B = Integer.parseInt(strs[1])-1;
			uf.unite(A, B);
//			if(rootlist[Math.max(A, B)] == 0 || rootlist[Math.max(A, B)] >Math.min(A, B)) {
//				rootlist[Math.max(A, B)] = Math.min(A, B);
//			}else if(rootlist[Math.max(A, B)] <Math.min(A, B)) {
//				rootlist[Math.min(A, B)]=rootlist[Math.max(A, B)];
//			}
		}
//		
			
//		for(int i=1;i<=N;i++) {
//			rootlist[i] = findRoot(rootlist,i);
//		}
//		int[] nodeCnt = new int[N+1];
//		for(int i=1;i<=N;i++) {
//			nodeCnt[rootlist[i]]++;
//		}
		int ans =0;
//		for(int i=1;i<=N;i++) {
//			if(ans< nodeCnt[i]) {
//				ans = nodeCnt[i];
//			}
//		}
		for(int i=0;i<N;i++) {
			ans = Math.max(ans, uf.getSize(i));
		}
		return ans;
	}
	
//	public static int findRoot(int[] rootList,int val) {
//		int i= val;
//		while(rootList[i] != i && rootList[i]!=0) {
//			i= rootList[i];
//		}
//		if(rootList[i] == 0) {
//			rootList[i] = i;
//		}
//		return i;
//	}
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