class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        
        int maxLeft=0;
        int maxRight=0;
        int maxWater=0;

        while(left<right){
            maxLeft=Math.max(maxLeft, height[left]);
            maxRight=Math.max(maxRight, height[right]);

            if(maxLeft<maxRight){
                maxWater=maxWater+(maxLeft-height[left]);
                left++;
            }else{
                maxWater=maxWater+(maxRight-height[right]);
                right--;
            }
        }

        return maxWater;
    }
}