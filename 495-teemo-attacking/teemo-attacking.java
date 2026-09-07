class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0 || timeSeries==null) return 0;
        int count=0;
        for(int i=0;i<timeSeries.length-1;i++){
           int gap=timeSeries[i+1]-timeSeries[i];
            count+=Math.min(gap,duration);
        }
        count+=duration;
        return count;
    }
}