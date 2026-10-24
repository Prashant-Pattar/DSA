class Solution {
    public int maxScore(int[] cardPoints, int k) {


        int n=cardPoints.length;
        int windowSize=n-k;

            int windowSum=0;
            int maxSum=0;
            for(int i=0;i<n;i++){
                maxSum=maxSum+cardPoints[i];
                if(i<windowSize){
                    windowSum+=cardPoints[i];
                }
            }
        int minSum=windowSum;

        for(int i=windowSize;i<n;i++){
            windowSum+=cardPoints[i]-cardPoints[i-windowSize];
            minSum=Math.min(minSum, windowSum);
        }

        return maxSum-minSum;
    }
}