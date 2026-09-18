class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)return 0;

        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    queue.offer(new int[] {r,c});
                }else if(grid[r][c]==1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges==0)return 0;

        int minutes=0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && freshOranges>0){
            int size=queue.size();
            minutes++;

            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];

                for(int[] dir:directions){
                    int nextR = r+dir[0];
                    int nextC = c+dir[1];

                    if(nextR<0 || nextC <0 || nextR >= rows || nextC >= cols || grid[nextR][nextC] != 1){
                        continue;
                    }

                    grid[nextR][nextC]=2;
                    freshOranges--;
                    queue.offer(new int[] {nextR, nextC});
                }
            }
        } 
        return freshOranges == 0 ? minutes : -1;
    }
}