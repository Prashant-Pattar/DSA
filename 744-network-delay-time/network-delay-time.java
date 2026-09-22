class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            adj.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        minHeap.offer(new int[] {k,0});

        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int u=curr[0];
            int d=curr[1];

            if(d>dist[u])continue;

            for(int[] neighbor:adj.get(u)){
                int v=neighbor[0];
                int w=neighbor[1];

                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    minHeap.offer(new int[] {v,dist[v]});
                }
            }
        }
        int maxDelay=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxDelay=Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }
}