class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null || intervals.length==0) return new int[][]{newInterval};

        List<int[]> merged=new ArrayList<>();

        int newStart=newInterval[0];
        int newEnd=newInterval[1];

        int i=0;

        while(i<intervals.length&&intervals[i][1]<newStart){
            merged.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newEnd){
            newStart=Math.min(intervals[i][0], newStart);
            newEnd=Math.max(intervals[i][1], newEnd);
            i++;
        }
        merged.add(new int[]{newStart, newEnd});

        while(i<intervals.length){
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}