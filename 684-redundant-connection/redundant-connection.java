class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        UnionFind uf=new UnionFind(n+1);

        for(int[] edge:edges){
            int u =edge[0];
            int v =edge[1];

            if(!uf.union(u,v)){
                return edge;
            }
        }
        return new int[0];
    }
    class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int i){
            if(parent[i]==i){
                return i;
            }
            return parent[i]=find(parent[i]);
        }
        public boolean union(int i, int j){
            int rootI=find(i);
            int rootJ=find(j);

            if(rootI==rootJ){
                return false;
            }
            parent[rootI]=rootJ;
            return true;
        }
    }
}