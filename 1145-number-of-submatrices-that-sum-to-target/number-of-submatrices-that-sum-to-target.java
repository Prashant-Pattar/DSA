class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int count=0;

        for(int ceiling=0;ceiling<ROWS;ceiling++){
            int[] colSum= new int[COLS];

            for(int floor=ceiling;floor<ROWS;floor++){

                for(int c=0;c<COLS;c++){
                    colSum[c]+=matrix[floor][c];
                }

                HashMap<Integer, Integer> map= new HashMap<>();
                int currentSum=0;

                map.put(0,1);

                for(int c=0;c<COLS;c++){
                    currentSum=currentSum+colSum[c];

                    int pastMarker=currentSum-target;

                    if(map.containsKey(pastMarker)){
                        count=count+map.get(pastMarker);
                    }

                    map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
                }
            }
        }
        return count;
    }
}