class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int u=flight[0];
            int v=flight[1];
            int price=flight[2];
            adj.get(u).add(new int[]{v,price});
        }
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        minHeap.offer(new int[]{src,0,0});

        int[] minStops= new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int u=curr[0];
            int cost=curr[1];
            int stops=curr[2];

            if(u==dst){
                return cost;
            }
            if(stops>k){
                continue;
            }
            if(stops>=minStops[u]){
                continue;
            }
            minStops[u]=stops;
            for(int[] neighbor:adj.get(u)){
                int v=neighbor[0];
                int price=neighbor[1];

                minHeap.offer(new int[]{v,cost+price,stops+1});
            }
        }
        return -1;
    }
}