class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
        
        int currentEnd=intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];
            if(currentEnd>nextStart){
                count++;
            }else{
                currentEnd=nextEnd;
            }
        }
        return count;
    }
}