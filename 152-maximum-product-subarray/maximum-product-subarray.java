class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int minSoFar=nums[0];
        int maxSoFar=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            if(curr<0){
                int temp=minSoFar;
                minSoFar=maxSoFar;
                maxSoFar=temp;
            }

            minSoFar=Math.min(curr, minSoFar*curr);
            maxSoFar=Math.max(curr, maxSoFar*curr);

            result=Math.max(result, maxSoFar);
        }
        return result;
    }
}